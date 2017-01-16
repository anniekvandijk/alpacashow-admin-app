package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventRegistration;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeSexClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.services.AgeClassService;
import nl.animundo.apps.alpacashowadmin.backend.services.ShowClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.*;

public class ShowEventRepository {
    private static Logger logger = LoggerFactory.getLogger(ShowEventRepository.class);
    private Map<String, ShowEvent> showEvents = new HashMap<>();
    private ShowEventRegistrationRepository showEventRegistrationRepository = new ShowEventRegistrationRepository();

    public String add(final ShowEvent showEvent) {

        String showEventKey = showEvent.getDate() + "_" + showEvent.getShowType();
        if (getShowEventByKeySet(showEventKey) == null) {
            showEvents.put(showEventKey, showEvent);
            logger.info("Added showEvent '" + showEventKey + "' to showEventRepo");
            showEventRegistrationRepository.AddRegistrationsIfComplete(showEvent, showEventKey);
            return showEventKey;
        } else {
            throw new IllegalArgumentException("Showevent with same date and showtype already exists");
        }
    }

    public String delete(final String showEventKey) {

        ShowEvent showEventToDelete = getShowEventByKeySet(showEventKey);
        if (showEventToDelete != null) {
            showEvents.remove(showEventKey);
            logger.info("Deleted showEvent '" + showEventKey + "' from showEventRepo");
            showEventRegistrationRepository.deleteAllRegistrationsForShowEvent(showEventKey);
            return showEventToDelete.getName();
        } else {
            return null;
        }
    }

    public Set<String> getAllShowEventsByKeySet() {
        return showEvents.keySet();
    }

    public Collection<ShowEvent> getAllShowEvents() {
        return showEvents.values();
    }


    public ShowEvent getShowEventByKeySet(final String keySet) {
        return showEvents.get(keySet);
    }

}
