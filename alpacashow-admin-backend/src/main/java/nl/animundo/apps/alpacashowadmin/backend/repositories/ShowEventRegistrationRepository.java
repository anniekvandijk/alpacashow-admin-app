package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShowEventRegistrationRepository {
    private static Logger logger = LoggerFactory.getLogger(ShowEventRegistrationRepository.class);
    private Map<String, ShowEventRegistration> showEventRegistrations = new HashMap<>();


    public String add(final ShowEventRegistration showEventRegistration) {

        String showEventRegistrationKey = showEventRegistration.getShowEventKey() + "_" + showEventRegistration.getParticipantKey() + "_" + showEventRegistration.getAnimalKey();
        if (getShowEventRegistrationByKeySet(showEventRegistrationKey) == null) {
            showEventRegistrations.put(showEventRegistrationKey, showEventRegistration);
            logger.info("Added showEventRegistratiom '" + showEventRegistrationKey + "' to showEventRegistrationRepo");
            return showEventRegistrationKey;
        } else {
            throw new IllegalArgumentException("Showevent registration with same keys already exists");
        }
    }

    public String delete(final String showEventRegistrationKey) {

        ShowEventRegistration showEventRegistrationToDelete = getShowEventRegistrationByKeySet(showEventRegistrationKey);
        if (showEventRegistrationToDelete != null) {
            showEventRegistrations.remove(showEventRegistrationKey);
            logger.info("Deleted showEvent '" + showEventRegistrationKey + "' from showEventRepo");
            return showEventRegistrationToDelete.getShowEventKey();
        } else {
            return null;
        }
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