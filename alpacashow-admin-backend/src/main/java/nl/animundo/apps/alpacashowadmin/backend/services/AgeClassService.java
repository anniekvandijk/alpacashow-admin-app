package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgeClassService {

    private static Logger logger = LoggerFactory.getLogger(AgeClassService.class);

    private AgeClassService() throws InstantiationException {
        throw new InstantiationException("Instances of this type are forbidden!");
    }

    public static AgeClass ageClass(final ShowEvent showEvent, final Animal animal) {

        LocalDate showEventDate = showEvent.getDate();
        ShowType showType = showEvent.getShowType();
        LocalDate dateOfBirth = animal.getDateOfBirth();
        LocalDate sheerDate = animal.getAnimalShowDetail().getSheerDate();

        if (sheerDate != null) {
            if (sheerDate.isBefore(dateOfBirth)) {
                throw new IllegalArgumentException("Sheerdate before date of birth");
            }
            long yearsBetweenSheeringAndShow = ChronoUnit.YEARS.between(sheerDate, showEventDate);
            if (yearsBetweenSheeringAndShow >= 3) {
                throw new IllegalArgumentException("Sheerdate more than 3 years ago");
            }
        }
        if (sheerDate == null)
        {
            long yearsBetweenShowAndDateOfBirth = ChronoUnit.YEARS.between(dateOfBirth, showEventDate);
            if (yearsBetweenShowAndDateOfBirth >= 3) {
                throw new IllegalArgumentException("Sheerdate must be filled if date of birth is more than 3 years ago");
            }
        }

        AgeClass ageClass = null;
        if ((ShowType.FLEECESHOW).equals(showType)) {
            if (sheerDate == null){
                 throw new IllegalArgumentException("Sheerdate can not be empty for a fleeceshow");
            }
            else
            {
                ageClass = AgeClassService.getAgeClass(sheerDate, dateOfBirth);
            }
        }
        else
        {
            ageClass = AgeClassService.getAgeClass(showEventDate, dateOfBirth);
        }
        return ageClass;
    }

    static AgeClass getAgeClass(final LocalDate sheerOrShowDate, final LocalDate dateOfBirth) {

        int ageInMonths = getAgeInMonths(sheerOrShowDate, dateOfBirth);
        AgeClass ageClass = null;

        for (AgeClass ageClassValue : AgeClass.values()) {
            if (ageInMonths >= ageClassValue.getMonthMin() && ageInMonths <= ageClassValue.getMonthMax()) {
                logger.info("Age in months = " + ageInMonths + ", AgeClass = " + ageClassValue);
                ageClass = ageClassValue;
            }
        }
        return ageClass;
    }

    private static int getAgeInMonths(final LocalDate sheerOrShowDate, final LocalDate dateOfBirth) {

        final long ageInMonths = ChronoUnit.MONTHS.between(dateOfBirth, sheerOrShowDate);

        if (ageInMonths < 0 ) {
            throw new IllegalArgumentException("Age below zero months. Check date of birth.");
        }
        if (ageInMonths < 6) {
            throw new IllegalArgumentException("Animals under 6 months can not participate.");
        }
        if (ageInMonths >= 600  ) {
            throw new IllegalArgumentException("Animal age to high. Check the date of birth.");
        }
        else
        {
            return (int) ageInMonths;
        }
    }
}
