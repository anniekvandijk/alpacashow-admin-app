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

    // FIXME: How to get animal showdetails which are dynamic for each show

//        AgeClass ageClass = null;
//        if ((ShowType.FLEECESHOW).equals(showEvent.getShowType())) {
//            if (animal.getSheerDate() == null){
//                 throw new IllegalArgumentException("Sheerdate can not be empty for a fleeceshow");
//            }
//            else
//            {
//                ageClass = AgeClassService.getAgeClass(animal.getSheerDate(), animal.getDateOfBirth());
//            }
//        }
//        else
//        {
//            ageClass = AgeClassService.getAgeClass(showEvent.getDate(), animal.getDateOfBirth());
//        }
//        return ageClass;

        return AgeClassService.getAgeClass(showEvent.getDate(), animal.getDateOfBirth());
    }

    public static AgeClass getAgeClass(final LocalDate sheerOrShowDate, final LocalDate birthDate) {

        int ageInMonths = getAgeInMonths(sheerOrShowDate, birthDate);
        AgeClass ageClass = null;

        for (AgeClass ageClassValue : AgeClass.values()) {
            if (ageInMonths >= ageClassValue.getMonthMin() && ageInMonths <= ageClassValue.getMonthMax()) {
                logger.info("Age in months = " + ageInMonths + ", AgeClass = " + ageClassValue);
                ageClass = ageClassValue;
            }
        }
        return ageClass;
    }

    private static int getAgeInMonths(final LocalDate sheerOrShowDate, final LocalDate birthDate) {

        final long ageInMonths = ChronoUnit.MONTHS.between(birthDate, sheerOrShowDate);

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
