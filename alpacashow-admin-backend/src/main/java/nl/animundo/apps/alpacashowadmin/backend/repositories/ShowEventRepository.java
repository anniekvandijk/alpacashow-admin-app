package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.Utilities.ShowEventComparator;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class ShowEventRepository  {
    private static Logger logger = LoggerFactory.getLogger(ShowEventRepository.class);
    private Map<String, ShowEvent> showEvents = new HashMap<>();

    public String add(final ShowEvent showEvent) throws IOException {

        String showEventKey = showEvent.getDate() + "_" + showEvent.getShowType();
        if (getShowEventByKeySet(showEventKey) == null) {
            showEvents.put(showEventKey, showEvent);
            logger.info("Added showEvent '" + showEventKey + "' to showEventRepo");
            return showEventKey;
        } else {
            throw new IllegalArgumentException("Showevent with same date and showtype already exists");
        }
    }

    public String delete(final String showEventKey) throws IOException {

        ShowEvent showEventToDelete = getShowEventByKeySet(showEventKey);
        if (showEventToDelete != null) {
            showEvents.remove(showEventKey);
            logger.info("Deleted showEvent '" + showEventKey + "' from showEventRepo");
            return showEventToDelete.getName();
        } else {
            return null;
        }
    }

    public void deleteAll () {
        showEvents.clear();
    }

    public Set<String> getAllShowEventsByKeySet() {
        return showEvents.keySet();
    }

    public SortedSet<ShowEvent> getAllShowEvents() {
        SortedSet<ShowEvent> showEventSet = new TreeSet<>(new ShowEventComparator());
        for (ShowEvent showEvent : showEvents.values()) {
            showEventSet.add(showEvent);
        }
        return showEventSet;
    }

    public ShowEvent getShowEventByKeySet(final String keySet) {
        return showEvents.get(keySet);
    }

}
