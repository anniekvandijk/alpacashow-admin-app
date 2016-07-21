package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventSearch;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.csv.CsvShowEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by Anniek van Dijk on 20-7-2016.
 */
public class ShowEventService {
    private static Logger logger = LoggerFactory.getLogger(CsvShowEventRepository.class);

    private final static String fileLocation = System.getProperty("user.dir") + "/src/test/resources/";
    private final static String SHOWEVENTS_FILE = fileLocation + "csv/SHOWEVENTS.csv";
    private ShowEventRepository repo = new CsvShowEventRepository();


    public void add(ShowEvent showEvent) throws IOException {

        getShowsFromFile();
      //  if (showEvent.getName().equals(repo.search(ShowEventSearch.NAME, showEvent.getName())) && repo.search(ShowEventSearch.DATE, String.valueOf(showEvent.getDate())) == null) {

            if (showEvent.getName().equals(repo.search(ShowEventSearch.NAME, showEvent.getName()))) {
            // TODO add show to csv or replace csv?
        } else {
            throw new IllegalArgumentException("ShowEqq1q1q1qqqqqq1 vent with name '" + showEvent.getName() + "' and date '" + String.valueOf(showEvent.getDate()) + "' already excists");
        }

    }

    private ShowEventRepository getShowsFromFile() throws IOException {
        File showEventFile = new File(SHOWEVENTS_FILE);
        Reader reader = new FileReader(showEventFile) ;
        repo = CsvShowEventRepository.create(reader);
        logger.info("ShoeEvents in repo " + repo.size());
        return repo;
    }
}
