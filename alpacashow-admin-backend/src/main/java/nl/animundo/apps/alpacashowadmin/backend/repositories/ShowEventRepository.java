package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ShowEventRepository {
    private static Logger logger = LoggerFactory.getLogger(ShowEventRepository.class);
    private Map<String, ShowEvent> showEvents = new HashMap<>();


    public void add(final ShowEvent showEvent) {

        String showEventKey = showEvent.getDate() + "_" + showEvent.getShowType();
        if (getShowEventsByKeySet(showEventKey) == null) {
            showEvents.put(showEventKey, showEvent);
            logger.info("Added showEvent '" + showEventKey + "' to showEventRepo");
        } else {
            throw new IllegalArgumentException("Showevent with same date and showtype already exists");
        }
    }

    public String delete(final String showEventKey) {

        ShowEvent showEventToDelete = getShowEventsByKeySet(showEventKey);
        if (showEventToDelete != null) {
            showEvents.remove(showEventToDelete.getDate() + "_" + showEventToDelete.getShowType());
            logger.info("Deleted showEvent '" + showEventKey + "' from showEventRepo");
            return showEventToDelete.getName();
        } else {
            return null;
        }
    }

    public ShowEvent search(final String searchForKey) {

        ShowEvent showEventToSearchFor = getShowEventsByKeySet(searchForKey);
        if (showEventToSearchFor != null) {
            return showEventToSearchFor;
        } else {
            return null;
        }
    }

    public int size() {
        return showEvents.size();
    }

    public Set<String> getShowEvents() {
        return showEvents.keySet();
    }

    public Collection<ShowEvent> getAllShowEvents() {
        return showEvents.values();
    }


    public ShowEvent getShowEventsByKeySet(final String keySet) {
        return showEvents.get(keySet);
    }

}
