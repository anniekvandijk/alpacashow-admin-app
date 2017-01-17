package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
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

        List list = new ArrayList(showEventParticipants.values());
        if (list.isEmpty()) {
            return list;
        }
        else {
            Comparator comparator = Comparator.comparing(ShowEventParticipant::getShowEventKey);
            Collections.sort(list, comparator);
            return list;
        }
    }

    public ShowEventParticipant getShowEventParticipantByKeySet(final String keySet) {
        return showEventParticipants.get(keySet);
    }

    // Todo: Do I need to implement this?

//    public Collection<ShowEventParticipant> getShowEventParticipantsByShowEvent(final String showEventKey)
//    {
//        Collection<ShowEventParticipant> showEventPart = showEventParticipants.values();
//        List list = new ArrayList();
//        for (ShowEventParticipant part : showEventPart) {
//            if (part.getShowEventKey().equals(showEventKey))
//            {
//                list.add(part);
//            }
//        }
//        return list;
//    }

//    public String deleteAllShowEventParticipantByShowEvent(final String showEventKey) throws IOException {
//
//        Collection <ShowEventParticipant> showEventParticipantsToDelete = getShowEventParticipantsByShowEvent(showEventKey);
//        if (showEventParticipantsToDelete != null) {
//            for (ShowEventParticipant part : showEventParticipantsToDelete)
//            {
//                if (part.getShowEventKey().equals(showEventKey))
//                {
//                    showEventParticipants.remove(part);
//                    logger.info("Deleted showEventParticipants from '" + showEventKey + "' from showEventParticipantRepo");
//                }
//            }
//            return showEventKey;
//        } else {
//            return null;
//        }
//    }

}
