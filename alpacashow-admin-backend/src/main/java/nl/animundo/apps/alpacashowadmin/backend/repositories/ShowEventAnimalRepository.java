package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventAnimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

public class ShowEventAnimalRepository {
    private static Logger logger = LoggerFactory.getLogger(ShowEventAnimalRepository.class);
    private Map<String, ShowEventAnimal> showEventAnimals = new HashMap<>();

    public String add(final ShowEventAnimal showEventAnimal) {

        String showEventAnimalKey = showEventAnimal.getShowEventKey() + "_" + showEventAnimal.getParticipantKey() + "_" + showEventAnimal.getAnimalKey();
        if (getShowEventAnimalByKeySet(showEventAnimalKey) != null) {
            showEventAnimals.remove(showEventAnimalKey);
            showEventAnimals.put(showEventAnimalKey, showEventAnimal);
            logger.info("Updated showEventAnimal '" + showEventAnimalKey + "' to showEventAnimalRepo");
        } else {
            showEventAnimals.put(showEventAnimalKey, showEventAnimal);
            logger.info("Added showEventAnimal '" + showEventAnimalKey + "' to showEventAnimalRepo");
        }
        return showEventAnimalKey;
    }

    public String delete(final String showEventAnimalKey) {

        ShowEventAnimal showEventAnimalToDelete = getShowEventAnimalByKeySet(showEventAnimalKey);
        if (showEventAnimalToDelete != null) {
            showEventAnimals.remove(showEventAnimalKey);
            logger.info("Deleted showEventAnimal '" + showEventAnimalKey + "' from showEventAnimalRepo");
            return showEventAnimalToDelete.getShowEventKey();
        } else {
            return null;
        }
    }

    public void deleteAll () {
        if (!showEventAnimals.isEmpty()) {
            showEventAnimals.clear();
        }
    }

    public Set<String> getAllShowEventAnimalsByKeySet() {
        return showEventAnimals.keySet();
    }

    public Collection<ShowEventAnimal> getAllShowEventAnimals() {

        return showEventAnimals.values();
    }

    public ShowEventAnimal getShowEventAnimalByKeySet(final String keySet) {
        return showEventAnimals.get(keySet);
    }

}
