package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventParticipant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.*;

public class ShowEventParticipantRepository {
    private static Logger logger = LoggerFactory.getLogger(ShowEventParticipantRepository.class);
    private Map<String, ShowEventParticipant> showEventParticipants = new HashMap<>();

    public String add(final ShowEventParticipant showEventParticipant) throws IOException {

        String showEventParticipantKey = showEventParticipant.getShowEventKey() + "_" + showEventParticipant.getParticipantKey();
        if (getShowEventParticipantByKeySet(showEventParticipantKey) == null) {
            showEventParticipants.put(showEventParticipantKey, showEventParticipant);
            logger.info("Added showEventParticipant '" + showEventParticipantKey + "' to showEventParticipantRepo");
        }
        return showEventParticipantKey;
    }

    public String delete(final String showEventParticipantKey) throws IOException {

        ShowEventParticipant showEventParticipantToDelete = getShowEventParticipantByKeySet(showEventParticipantKey);
        if (showEventParticipantToDelete != null) {
            showEventParticipants.remove(showEventParticipantKey);
            logger.info("Deleted showEventParticipant '" + showEventParticipantKey + "' from showEventParticipantRepo");
            return showEventParticipantKey;
        } else {
            return null;
        }
    }

    public void deleteAll () {
            showEventParticipants.clear();
    }

    public Set<String> getAllShowEventParticipantsByKeySet() {
        return showEventParticipants.keySet();
    }

    public Collection<ShowEventParticipant> getAllShowEventParticipants() {

        return showEventParticipants.values();
    }

    public ShowEventParticipant getShowEventParticipantByKeySet(final String keySet) {
        return showEventParticipants.get(keySet);
    }
}
