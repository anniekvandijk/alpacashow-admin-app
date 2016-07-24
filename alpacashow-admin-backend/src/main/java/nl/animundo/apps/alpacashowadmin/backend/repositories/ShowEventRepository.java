package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventSearch;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Anniek van Dijk on 1-7-2016.
 */
public class ShowEventRepository {
    private static Logger logger = LoggerFactory.getLogger(ShowEventRepository.class);
    private Map<String, ShowEvent> showEvents = new HashMap<>();


    public void add(final ShowEvent showEvent) {
        // TODO no double keys

        String showEventKey = showEvent.getName() + "_" + showEvent.getDate();
        showEvents.put(showEventKey, showEvent);
        logger.info("Added showEvent '" + showEventKey + "' to showEventRepo");

    }

    public ShowEvent search(final ShowEventSearch searchOption, final String searchFor) {
        for (Map.Entry<String, ShowEvent> showEventEntry : showEvents.entrySet()) {
            String value = "";
            switch (searchOption) {
                case NAME:
                    value = showEventEntry.getValue().getName();
                    break;
                case JUDGE:
                    value = showEventEntry.getValue().getJudge();
                    break;
                case LOCATION:
                    value = showEventEntry.getValue().getLocation();
                    break;
                case DATE:
                    value = String.valueOf(showEventEntry.getValue().getDate()); //TODO dd-MM-yyyy dateformatter
                    break;
                case CLOSEDATE:
                    value = String.valueOf(showEventEntry.getValue().getCloseDate());
                    break;
                case SHOWTYPE:
                    break;
                case PARTICIPANTS:
                    break;
                default:
                    throw new IllegalArgumentException("value not found");
            }

            if (searchFor.equalsIgnoreCase(value)) {
                logger.info("value: '" + value + "' is found");
                return showEventEntry.getValue();

            }
        }

        return null;
    }

    public int size() {
        return showEvents.size();
    }

    public Set<String> getShowEvents() {
        return showEvents.keySet();
    }

    public ShowEvent getShowEventsByKeySet(final String keySet) {
        return showEvents.get(keySet);
    }

}
