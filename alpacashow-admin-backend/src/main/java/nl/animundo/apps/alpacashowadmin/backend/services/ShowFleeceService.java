package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.helpclasses.FleeceWeightPoints;
import nl.animundo.apps.alpacashowadmin.backend.repositories.FleeceWeightPointsRepository;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ShowFleeceService {
    private static Logger logger = LoggerFactory.getLogger(FleeceWeightPointsRepository.class);

    private static ApplicationRepositoryService service = new ApplicationRepositoryService();

    private ShowFleeceService() throws InstantiationException {
        throw new InstantiationException("Instances of this type are forbidden!");
    }

    public static float getCleanFleeceWeightPoints (LocalDate dateOfBirth, LocalDate sheerDate, LocalDate beforeSheerDate, BreedClass breed, float fleeceweight) throws IOException {

        if (breed.equals(BreedClass.HUACAYA_FLEECE))
        {
            breed = BreedClass.HUACAYA;
        }
        if (breed.equals(BreedClass.SURI_FLEECE))
        {
            breed = BreedClass.SURI;
        }

        float cleanFleeceWeight = fleeceWeightCorrection(dateOfBirth, sheerDate, beforeSheerDate, fleeceweight);

        if (cleanFleeceWeight > 5.0f) {
            cleanFleeceWeight = 5.0f;
        }
        // Convert cleanFleeceWeight to String with dot as seperator
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        String cleanFleeceWeightConvert = decimalFormat.format(cleanFleeceWeight);
        String cleanFleeceWeightConvertToPoint = cleanFleeceWeightConvert.replace(",", ".");

        AgeClass ageClass = AgeClassService.getAgeClass(sheerDate, dateOfBirth);

        float cleanFleeceWeightPoints = 0.0f;
        FleeceWeightPointsRepository fleeceWeightPointsRepository = service.loadFleeceWeightPointsRepository();
        for (FleeceWeightPoints fleeceWeightPoints : fleeceWeightPointsRepository.getAllFleeceWeightPoints()) {
            if (fleeceWeightPoints.getBreed().equals(breed) &&
                    fleeceWeightPoints.getAgeClass().equals(ageClass) &&
                    fleeceWeightPoints.getCleanFleeceWeight().equals(cleanFleeceWeightConvertToPoint))
            {
                cleanFleeceWeightPoints = fleeceWeightPoints.getWeightPoints();
            }
        }
        return cleanFleeceWeightPoints;
    }


    public static int fleeceGrowthInDays (LocalDate dateOfBirth, LocalDate sheerDate, LocalDate beforeSheerDate) {

        if (beforeSheerDate == null) {
            beforeSheerDate = dateOfBirth;
        }

        return (int) ChronoUnit.DAYS.between(beforeSheerDate, sheerDate);
    }

    public static float fleeceWeightCorrection (LocalDate dateOfBirth, LocalDate sheerDate, LocalDate beforeSheerDate, float fleeceweight) {

        int fleeceGrowthInDays = fleeceGrowthInDays(dateOfBirth, sheerDate, beforeSheerDate);
        return (fleeceweight*365)/fleeceGrowthInDays;
    }
}
