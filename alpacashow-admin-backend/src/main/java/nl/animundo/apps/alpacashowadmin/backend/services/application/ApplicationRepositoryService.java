package nl.animundo.apps.alpacashowadmin.backend.services.application;

import nl.animundo.apps.alpacashowadmin.backend.Application;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.csv.CsvShowEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Anniek van Dijk on 7-8-2016.
 */
public class ApplicationRepositoryService {

    private static Logger logger = LoggerFactory.getLogger(Application.class);
    private static String WORK_DIR = System.getProperty("user.dir");
    private static Properties prop = new Properties();
    private static ShowEventRepository showEventRepo = new ShowEventRepository();

    private ApplicationRepositoryService() throws InstantiationException {
        throw new InstantiationException("Instances of this type are forbidden!");
    }

    public static ShowEventRepository getShowEventRepository(String environment) throws IOException {

        prop = ApplicationPropertiesService.getApplicationProperties(environment);
        String fileStorage = prop.getProperty("filestorage");

        if (fileStorage.equalsIgnoreCase("csv")) {
            String csvShowEventFileDir = prop.getProperty("csv-showevent-filedir");
            FileReader csvReader = new FileReader(WORK_DIR + csvShowEventFileDir);
            showEventRepo = CsvShowEventRepository.importData(csvReader);
            logger.info("Imported csvShowEventRepository");
        } else {
            throw new IllegalArgumentException("Not known filestorage property: " + fileStorage);
        }
        return showEventRepo;
    }
}
