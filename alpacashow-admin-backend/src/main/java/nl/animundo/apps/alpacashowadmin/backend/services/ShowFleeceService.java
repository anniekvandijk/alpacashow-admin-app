package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.helpclasses.FleeceWeightPoints;
import nl.animundo.apps.alpacashowadmin.backend.repositories.FleeceWeightPointsRepository;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ShowFleeceService {
    private static Logger logger = LoggerFactory.getLogger(FleeceWeightPointsRepository.class);

    private static ApplicationRepositoryService service = new ApplicationRepositoryService();
    private static FleeceWeightPointsRepository fleeceWeightPointsRepository;

    private ShowFleeceService() throws InstantiationException {
        throw new InstantiationException("Instances of this type are forbidden!");
    }

    public static float getCleanFleeceWeightPoints (Animal animal, float fleeceweight) throws IOException {

        LocalDate dateOfBirth = animal.getDateOfBirth();
        LocalDate sheerDate = animal.getAnimalShowDetail().getSheerDate();
        LocalDate beforeSheerDate = animal.getAnimalShowDetail().getBeforeSheerDate();
        BreedClass breed = animal.getBreed();

        if (breed.equals(BreedClass.HUACAYA_FLEECE))
        {
            breed = BreedClass.HUACAYA;
        }
        if (breed.equals(BreedClass.SURI_FLEECE))
        {
            breed = BreedClass.SURI;
        }

        if (beforeSheerDate == null) {
            beforeSheerDate = dateOfBirth;
        }

        int fleeceGrowthInDays = fleeceGrowthInDays(sheerDate, beforeSheerDate);
        Float cleanFleeceWeight = fleeceWeightCorrection(fleeceGrowthInDays, fleeceweight);
        AgeClass ageClass = AgeClassService.getAgeClass(sheerDate, dateOfBirth);

        float weightPoints = 0.0f;
        fleeceWeightPointsRepository = service.loadFleeceWeightPointsRepository();
        for (FleeceWeightPoints fleeceWeightPoints : fleeceWeightPointsRepository.getAllFleeceWeightPoints()) {
            if (fleeceWeightPoints.getBreed().equals(breed) &&
                    fleeceWeightPoints.getAgeClass().equals(ageClass) &&
                    fleeceWeightPoints.getCleanFleeceWeight().equals(cleanFleeceWeight))
            {
                weightPoints = fleeceWeightPoints.getWeightPoints();
            }
        }
        return weightPoints;
    }


    public static int fleeceGrowthInDays (LocalDate sheerDate, LocalDate beforeSheerDateOrDateOfBirth) {
        return (int) ChronoUnit.DAYS.between(beforeSheerDateOrDateOfBirth, sheerDate);
    }

    public static Float fleeceWeightCorrection (int fleeceGrowthInDays, float fleeceweight) {

        float weightcorrection = (fleeceweight*365)/fleeceGrowthInDays;

        return weightcorrection;
    }

    private static boolean equality(float a, float b, float epsilon)
    {
        return Math.abs(a - b) < epsilon;
    }
}
