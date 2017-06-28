package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventParticipantAnimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ShowEventParticipantAnimalRepository {
    private static Logger logger = LoggerFactory.getLogger(ShowEventParticipantAnimalRepository.class);
    private List<ShowEventParticipantAnimal> showEventParticipantAnimals;

    public ShowEventParticipantAnimal add(final ShowEventParticipantAnimal showEventParticipantAnimal) {

        showEventParticipantAnimals.add(showEventParticipantAnimal);
        logger.info("Added '" + showEventParticipantAnimal.getShowEventId() + "' to repo");
        return showEventParticipantAnimal;
    }



    public void deleteAll () {
            showEventParticipantAnimals.clear();
        logger.info("Deleted all records from Repo");
    }

    public Collection<ShowEventParticipantAnimal> getAll() {
        return showEventParticipantAnimals;
    }
}
