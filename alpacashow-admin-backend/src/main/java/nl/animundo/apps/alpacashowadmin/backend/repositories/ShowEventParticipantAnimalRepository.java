package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventParticipant;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventParticipantAnimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShowEventParticipantAnimalRepository {
    private static Logger logger = LoggerFactory.getLogger(ShowEventParticipantAnimalRepository.class);
    private Map<String, ShowEventParticipantAnimal> showEventParticipantAnimals = new HashMap<>();

    public String add(final ShowEventParticipantAnimal showEventParticipantAnimal) throws IOException {

        String showEventParticipantAnimalKey = showEventParticipantAnimal.getShowEventKey() + "_" + showEventParticipantAnimal.getParticipantKey() + "_" + showEventParticipantAnimal.getAnimalKey();
        if (getShowEventParticipantAnimalByKeySet(showEventParticipantAnimalKey) == null) {
            showEventParticipantAnimals.put(showEventParticipantAnimalKey, showEventParticipantAnimal);
            logger.info("Added showEventParticipantAnimal '" + showEventParticipantAnimalKey + "' to showEventParticipantAnimalRepo");
        }
        return showEventParticipantAnimalKey;
    }

    public String delete(final String showEventParticipantAnimalKey) throws IOException {

        ShowEventParticipantAnimal showEventParticipantAnimalToDelete = getShowEventParticipantAnimalByKeySet(showEventParticipantAnimalKey);
        if (showEventParticipantAnimalToDelete != null) {
            showEventParticipantAnimals.remove(showEventParticipantAnimalToDelete);
            logger.info("Deleted showEventParticipantAnimal '" + showEventParticipantAnimalToDelete + "' from showEventParticipantAnimalRepo");
            return showEventParticipantAnimalKey;
        } else {
            return null;
        }
    }

    public void deleteAll () {
            showEventParticipantAnimals.clear();
    }

    public Set<String> getAllShowEventParticipantAnimalsByKeySet() {
        return showEventParticipantAnimals.keySet();
    }

    public Collection<ShowEventParticipantAnimal> getAllShowEventParticipantAnimals() {

        return showEventParticipantAnimals.values();
    }

    public ShowEventParticipantAnimal getShowEventParticipantAnimalByKeySet(final String keySet) {
        return showEventParticipantAnimals.get(keySet);
    }
}
