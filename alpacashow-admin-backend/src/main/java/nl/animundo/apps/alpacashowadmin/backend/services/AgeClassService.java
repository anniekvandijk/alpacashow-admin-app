package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgeClassService {

    private static Logger logger = LoggerFactory.getLogger(AgeClassService.class);


    public static AgeClass getAgeClass(final LocalDate showDate, final LocalDate sheerOrBirthDate) {

        long ageInMonths = getAgeInMonths(showDate, sheerOrBirthDate);

        for (AgeClass ageClass : AgeClass.values()) {
            if (ageInMonths >= ageClass.getMonthMin() && ageInMonths <= ageClass.getMonthMax()) {
                logger.info("AgeClass = " + ageClass);
                return ageClass;
            }
        }
        // If enums are changed, code will break. Throw exeption.
        throw new IllegalArgumentException("Unable to determen AgeClass, for given showDate '" + showDate + "' and dateOfBirth '" + sheerOrBirthDate + "'");
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
