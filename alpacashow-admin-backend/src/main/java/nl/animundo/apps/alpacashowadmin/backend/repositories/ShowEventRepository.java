package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anniek van Dijk on 1-7-2016.
 */
public class ShowEventRepository {
    private static Logger logger = LoggerFactory.getLogger(ShowEventRepository.class);

    private Map<String, ShowEvent> showEventRepo = new HashMap<>();

    public void add(ShowEvent showEvent) {
        String showEventKey = showEvent.getName() + "_" + showEvent.getDate();
        showEventRepo.put(showEventKey, showEvent);
        logger.info("Added showEvent '" + showEventKey + "' to showEventRepo");

    }

    public String search(ShowEventSearch searchOption, String searchFor) {

        for (Map.Entry<String, ShowEvent> show : showEventRepo.entrySet()) {

            String value = "";

            switch (searchOption) {
                case KEY:
                    value = show.getKey();
                    break;
                case NAME:
                    value = show.getValue().getName();
                    break;
                case JUDGE:
                    value = show.getValue().getJudge();
                    break;
                case LOCATION:
                    value = show.getValue().getLocation();
                    break;
                case DATE:
                    value = String.valueOf(show.getValue().getDate());
                    break;
                case CLOSEDATE:
                    value = String.valueOf(show.getValue().getCloseDate());
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
                return value;
            } else return "value '" + value + "' not found with search for '" + searchFor + "'";
        }
        return null;
    }
}
