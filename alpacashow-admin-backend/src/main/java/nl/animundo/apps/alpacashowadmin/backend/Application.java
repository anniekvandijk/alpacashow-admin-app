package nl.animundo.apps.alpacashowadmin.backend;

import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.csv.CsvShowEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    private static String WORK_DIR = System.getProperty("user.dir") + "/alpacashow-admin-backend/";

    private Application(final Properties prop) throws IOException {
        String fileStorage = prop.getProperty("filestorage");

        if (fileStorage.equalsIgnoreCase("csv")) {
            String csvShowEventFileDir = prop.getProperty("csv-showevent-filedir");
            FileReader csvReader = new FileReader(WORK_DIR + csvShowEventFileDir);
            ShowEventRepository showEventRepo = CsvShowEventRepository.importData(csvReader);
        } else {
            throw new IllegalArgumentException("Not known filestorage property: " + fileStorage);
        }
    }

    public static void main(String[]args) throws IOException {

        logger.info("Application is running");

        Properties prop = new Properties();

        String environment = "tst";

        if (environment.equalsIgnoreCase("prd")) {
            prop.load(new FileReader(new File(WORK_DIR +"prd.application.properties")));
            logger.info("Properties production set");
        } else {
            prop.load(new FileReader(new File(WORK_DIR +"dev.application.properties")));
            logger.info("Properties development set");
        }

        Application app = new Application(prop);

    }
}
