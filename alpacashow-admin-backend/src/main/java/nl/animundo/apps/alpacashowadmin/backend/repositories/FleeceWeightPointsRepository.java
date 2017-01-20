package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.helpclasses.FleeceWeightPoints;
import nl.animundo.apps.alpacashowadmin.backend.utilities.FleeceWeightPointsComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class FleeceWeightPointsRepository {
    private static Logger logger = LoggerFactory.getLogger(FleeceWeightPointsRepository.class);
    private Map<String, FleeceWeightPoints> fleeceWeightPointsMap = new HashMap<>();

    public String add(final FleeceWeightPoints fleeceWeightPoints) {

        String fleeceWeightPointsKey = fleeceWeightPoints.getBreed() + "_" + fleeceWeightPoints.getAgeClass() + "_" + fleeceWeightPoints.getCleanFleeceWeight();
        if (getFleeceWeightPointsByKeySet(fleeceWeightPointsKey) != null) {
            fleeceWeightPointsMap.remove(fleeceWeightPointsKey);
            fleeceWeightPointsMap.put(fleeceWeightPointsKey, fleeceWeightPoints);
            logger.info("Updated fleeceWeightPoints '" + fleeceWeightPointsKey + "' to fleeceWeightPointsRepo");
        } else {
            fleeceWeightPointsMap.put(fleeceWeightPointsKey, fleeceWeightPoints);
            logger.info("Added fleeceWeightPoints '" + fleeceWeightPointsKey + "' to fleeceWeightPointsRepo");
        }
        return fleeceWeightPointsKey;
    }

    public String delete(final String fleeceWeightPointsKey) {

        FleeceWeightPoints fleeceWeightPointsToDelete = getFleeceWeightPointsByKeySet(fleeceWeightPointsKey);
        if (fleeceWeightPointsToDelete != null) {
            fleeceWeightPointsMap.remove(fleeceWeightPointsKey);
            logger.info("Deleted showEventAnimal '" + fleeceWeightPointsKey + "' from showEventAnimalRepo");
            return fleeceWeightPointsToDelete.getBreed() + "_" + fleeceWeightPointsToDelete.getAgeClass() + "_" + fleeceWeightPointsToDelete.getCleanFleeceWeight();
        } else {
            return null;
        }
    }

    public Set<String> getAllFleeceWeightPointsByKeySet() {
        return fleeceWeightPointsMap.keySet();
    }

    public Collection<FleeceWeightPoints> getAllFleeceWeightPoints() {
        return fleeceWeightPointsMap.values();
    }

    public FleeceWeightPoints getFleeceWeightPointsByKeySet(final String keySet) {
        return fleeceWeightPointsMap.get(keySet);
    }

}
