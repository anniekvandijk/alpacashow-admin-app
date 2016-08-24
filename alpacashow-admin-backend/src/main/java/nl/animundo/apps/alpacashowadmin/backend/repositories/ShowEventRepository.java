package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by Anniek van Dijk on 1-7-2016.
 */
public class ShowEventRepository {
    private static Logger logger = LoggerFactory.getLogger(ShowEventRepository.class);
    private Map<String, ShowEvent> showEvents = new HashMap<>();


    public void add(final ShowEvent showEvent) {
        // TODO no double keys

        String showEventKey = showEvent.getID();
        showEvents.put(showEventKey, showEvent);
        logger.info("Added showEvent '" + showEventKey + "' to showEventRepo");

    }

    public void delete(final String showEventKey) {

        ShowEvent showEventToDelete = getShowEventsByKeySet(showEventKey);
        showEvents.remove(showEventToDelete.getID());
        logger.info("Deleted showEvent '" + showEventKey + "' from showEventRepo");

    }

    public ShowEvent searchForKey(final String searchForKey) {

        ShowEvent showEventToSearchFor = getShowEventsByKeySet(searchForKey);
        if (showEventToSearchFor != null) {
            return showEventToSearchFor;
        } else {
            return null;
        }
    }

    public ShowEvent searchForName(final String searchForName) {

        ShowEvent showEventToSearchFor = getShowEventsByName(searchForName);
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

    public ShowEvent getShowEventsByName(final String name) {
        String eventName = null;
        for (ShowEvent event : showEvents.values()) {
            eventName = event.getName();
            if (name.equalsIgnoreCase(eventName)) {
                return event;
            } else {
                return null;
            }
        }
        return null;
    }
}
