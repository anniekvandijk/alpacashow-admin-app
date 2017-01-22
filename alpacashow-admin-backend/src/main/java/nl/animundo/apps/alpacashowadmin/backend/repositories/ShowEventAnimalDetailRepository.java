package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventAnimalDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

public class ShowEventAnimalDetailRepository {
    private static Logger logger = LoggerFactory.getLogger(ShowEventAnimalDetailRepository.class);
    private Map<String, ShowEventAnimalDetail> showEventAnimalDetails = new HashMap<>();

    public String add(final ShowEventAnimalDetail showEventAnimalDetail) {

        String showEventAnimalDetailKey = showEventAnimalDetail.getShowEventKey() + "_" + showEventAnimalDetail.getParticipantKey() + "_" + showEventAnimalDetail.getAnimalKey();
        if (getShowEventAnimalDetailByKeySet(showEventAnimalDetailKey) != null) {
            showEventAnimalDetails.remove(showEventAnimalDetailKey);
            showEventAnimalDetails.put(showEventAnimalDetailKey, showEventAnimalDetail);
            logger.info("Updated showEventAnimalDetail '" + showEventAnimalDetailKey + "' to showEventAnimalDetailRepo");
        } else {
            showEventAnimalDetails.put(showEventAnimalDetailKey, showEventAnimalDetail);
            logger.info("Added showEventAnimalDetail '" + showEventAnimalDetailKey + "' to showEventAnimalDetailRepo");
        }
        return showEventAnimalDetailKey;
    }

    public String delete(final String showEventAnimalDetailKey) {

        ShowEventAnimalDetail showEventAnimalDetailToDelete = getShowEventAnimalDetailByKeySet(showEventAnimalDetailKey);
        if (showEventAnimalDetailToDelete != null) {
            showEventAnimalDetails.remove(showEventAnimalDetailKey);
            logger.info("Deleted showEventAnimal '" + showEventAnimalDetailKey + "' from showEventAnimalRepo");
            return showEventAnimalDetailToDelete.getAnimalKey();
        } else {
            return null;
        }
    }

    public void deleteAll () {
            showEventAnimalDetails.clear();
    }

    public Set<String> getAllShowEventAnimalDetailsByKeySet() {
        return showEventAnimalDetails.keySet();
    }

    public Collection<ShowEventAnimalDetail> getAllShowEventAnimalDetails() {

        return showEventAnimalDetails.values();
    }

    public ShowEventAnimalDetail getShowEventAnimalDetailByKeySet(final String keySet) {
        return showEventAnimalDetails.get(keySet);
    }

}
