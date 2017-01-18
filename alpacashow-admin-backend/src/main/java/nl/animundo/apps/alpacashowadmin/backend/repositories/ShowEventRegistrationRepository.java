package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventRegistration;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.services.AgeClassService;
import nl.animundo.apps.alpacashowadmin.backend.services.ShowClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.util.*;

public class ShowEventRegistrationRepository {
    private static Logger logger = LoggerFactory.getLogger(ShowEventRegistrationRepository.class);
    private Map<String, ShowEventRegistration> showEventRegistrations = new HashMap<>();

    public String add(final ShowEventRegistration showEventRegistration) {

        String showEventRegistrationKey = showEventRegistration.getShowEventKey() + "_" + showEventRegistration.getParticipantKey() + "_" + showEventRegistration.getAnimalKey();
        if (getShowEventRegistrationByKeySet(showEventRegistrationKey) != null) {
            showEventRegistrations.remove(showEventRegistrationKey);
            showEventRegistrations.put(showEventRegistrationKey, showEventRegistration);
            logger.info("Updated showEventRegistratiom '" + showEventRegistrationKey + "' to showEventRegistrationRepo");
        } else {
            showEventRegistrations.put(showEventRegistrationKey, showEventRegistration);
            logger.info("Added showEventRegistratiom '" + showEventRegistrationKey + "' to showEventRegistrationRepo");
        }
        return showEventRegistrationKey;
    }

    public String delete(final String showEventRegistrationKey) {

        ShowEventRegistration showEventRegistrationToDelete = getShowEventRegistrationByKeySet(showEventRegistrationKey);
        if (showEventRegistrationToDelete != null) {
            showEventRegistrations.remove(showEventRegistrationKey);
            logger.info("Deleted showEventRegistration '" + showEventRegistrationKey + "' from showEventRegistrationRepo");
            return showEventRegistrationToDelete.getShowEventKey();
        } else {
            return null;
        }
    }

    public void deleteAll () {
        showEventRegistrations.clear();
    }

    public Set<String> getAllShowEventRegistrationsByKeySet() {
        return showEventRegistrations.keySet();
    }

    public Collection<ShowEventRegistration> getAllShowEventRegistrations() {

        return showEventRegistrations.values();
    }

    public ShowEventRegistration getShowEventRegistrationByKeySet(final String keySet) {
        return showEventRegistrations.get(keySet);
    }

}
