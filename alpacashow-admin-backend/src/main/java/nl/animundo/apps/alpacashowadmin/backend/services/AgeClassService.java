package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgeClassService {

    private static Logger logger = LoggerFactory.getLogger(AgeClassService.class);

    private AgeClassService() throws InstantiationException {
        throw new InstantiationException("Instances of this type are forbidden!");
    }

    public static AgeClass getAgeClass(final LocalDate showDate, final LocalDate sheerOrBirthDate) {

        long ageInMonths = getAgeInMonths(showDate, sheerOrBirthDate);

        AgeClass ageClass = null;
        for (AgeClass ageClassValue : AgeClass.values()) {
            if (ageInMonths >= ageClassValue.getMonthMin() && ageInMonths <= ageClassValue.getMonthMax()) {
                logger.info("AgeClass = " + ageClassValue);
                ageClass = ageClassValue;
            }
        }
        return ageClass;
    }

    private static long getAgeInMonths(final LocalDate showDate, final LocalDate sheerOrBirthDate) {

        final long ageInMonths = ChronoUnit.MONTHS.between(sheerOrBirthDate, showDate);
        logger.info("Age in months = " + ageInMonths);

        if (ageInMonths < 0 ) {
            throw new IllegalArgumentException("Age below zero months. Check date of birth.");
        }
        if (ageInMonths >= 0 && ageInMonths < 6) {
            throw new IllegalArgumentException("Animals under the age of 6 can not participate.");
        }
        if (ageInMonths >= 600  ) {
            throw new IllegalArgumentException("Animal age to high. Check the date of birth.");
        }

        else {
            return ageInMonths;

        }

    }
}
