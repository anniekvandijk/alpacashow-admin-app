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

    public static double getCleanFleeceWeightPoints (Animal animal, double fleeceweight) {

        LocalDate dateOfBirth = animal.getDateOfBirth();
        LocalDate sheerDate = animal.getAnimalShowDetail().getSheerDate();
        LocalDate beforeSheerDate = animal.getAnimalShowDetail().getBeforeSheerDate();

        if (beforeSheerDate == null) {
            beforeSheerDate = dateOfBirth;
        }
        double cleanFleeceWeight = fleeceWeightCorrection(sheerDate, beforeSheerDate, fleeceweight);

        NumberFormat format = new DecimalFormat("#.#");

        BreedClass breed = animal.getBreed();
        AgeClass ageClass = AgeClassService.getAgeClass(sheerDate, dateOfBirth);

        double fleeceWeightPoints = calculateFleeceWeightPoints(breed, ageClass, cleanFleeceWeight);

        return Double.parseDouble(format.format(fleeceWeightPoints));
    }

    public static double fleeceWeightCorrection (LocalDate sheerDate, LocalDate beforeSheerDate, double fleeceweight) {

        final long fleeceGrowthInDays = ChronoUnit.DAYS.between(sheerDate, beforeSheerDate);

        double fleeceWeightCor = (fleeceweight*365)/fleeceGrowthInDays;

        NumberFormat format = new DecimalFormat("#.#");
        return Double.parseDouble(format.format(fleeceWeightCor));
    }

    public static double calculateFleeceWeightPoints (BreedClass breed, AgeClass ageClass, double cleanFleeceWeight) {

        // Read the table with points and return the points.

        double weightPoints = 1.5;
        return weightPoints;

    }
}
