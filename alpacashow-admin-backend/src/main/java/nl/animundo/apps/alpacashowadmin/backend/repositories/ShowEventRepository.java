package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.*;
import static java.util.Comparator.comparing;

public class ShowEventRepository  {
    private static Logger logger = LoggerFactory.getLogger(ShowEventRepository.class);
    private Map<String, ShowEvent> showEvents = new HashMap<>();

    public ShowEvent add(final String id, final ShowEvent showEvent) throws IOException {

        showEvents.put(id, showEvent);
        logger.info("Added showEvent '" + id + "' to showEventRepo");
        return showEvent;
    }

    public ShowEvent update(final String id, final ShowEvent showEvent) throws IOException {

        delete(id);
        add(id, showEvent);
        logger.info("Updated showevent '" + id + "' from participantRepo");
        return showEvent;
    }

    public String delete(final String id) throws IOException {

        ShowEvent showEventToDelete = getShowEventById(id);
        if (showEventToDelete != null) {
            showEvents.remove(id);
            logger.info("Deleted showEvent '" + id + "' from showEventRepo");
            return showEventToDelete.getId();
        } else {
            return null;
        }
    }

    public void deleteAll () {
            showEvents.clear();
    }

    public Set<String> getAllShowEventsById() {
        return showEvents.keySet();
    }

    public Collection<ShowEvent> getAllShowEvents() {
        return showEvents.values();
    }

    public List<ShowEvent> getAllShowEventsSorted() {

        List<ShowEvent> showEventList  = new ArrayList<>(showEvents.values());
        showEventList.sort(comparing(ShowEvent::getDate));
        showEventList.stream();
        return showEventList;
    }

    public ShowEvent getShowEventById(final String id) {
        return showEvents.get(id);
    }

}
