package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ShowFleeceService {

    private ShowFleeceService() throws InstantiationException {
        throw new InstantiationException("Instances of this type are forbidden!");
    }

    public static float getCleanFleeceWeightPoints (Animal animal, float fleeceweight) {

        LocalDate dateOfBirth = animal.getDateOfBirth();
        LocalDate sheerDate = animal.getAnimalShowDetail().getSheerDate();
        LocalDate beforeSheerDate = animal.getAnimalShowDetail().getBeforeSheerDate();
        BreedClass breed = animal.getBreed();

        if (beforeSheerDate == null) {
            beforeSheerDate = dateOfBirth;
        }

        int fleeceGrowthInDays = fleeceGrowthInDays(sheerDate, beforeSheerDate);
        float cleanFleeceWeight = fleeceWeightCorrection(fleeceGrowthInDays, fleeceweight);
        float fleeceWeightPoints = calculateFleeceWeightPoints(breed, sheerDate, dateOfBirth, cleanFleeceWeight);

        return (float) fleeceWeightPoints;
    }


    public static int fleeceGrowthInDays (LocalDate sheerDate, LocalDate beforeSheerDateOrDateOfBirth) {
        return (int) ChronoUnit.DAYS.between(beforeSheerDateOrDateOfBirth, sheerDate);
    }

    public static float fleeceWeightCorrection (int fleeceGrowthInDays, float fleeceweight) {
        return (float) (fleeceweight*365)/fleeceGrowthInDays;
    }

    public static float calculateFleeceWeightPoints (BreedClass breed, LocalDate sheerDate, LocalDate dateOfBirth, float cleanFleeceWeight) {

        AgeClass ageClass = AgeClassService.getAgeClass(sheerDate, dateOfBirth);
        // Read the table with points and return the points.

        return (float) 8.0;

    }

}
