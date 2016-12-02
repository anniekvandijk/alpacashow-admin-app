package nl.animundo.apps.alpacashowadmin.backend.services.application;

import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.csv.CsvShowEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.Properties;
import static com.sun.xml.bind.v2.util.ClassLoaderRetriever.getClassLoader;


public class ApplicationRepositoryService {

    private static Logger logger = LoggerFactory.getLogger(ApplicationRepositoryService.class);
    private static Properties prop = new Properties();
    private static ShowEventRepository showEventRepo = new ShowEventRepository();

    private ApplicationRepositoryService() throws InstantiationException {
        throw new InstantiationException("Instances of this type are forbidden!");
    }

    public static ShowEventRepository loadShowEventRepository() throws IOException {

        String fileStorage = getFileStorage();

        if ("csv".equalsIgnoreCase(fileStorage)) {
            String csvShowEventsResource =  getCsvShowEventResourcePath(fileStorage);
            FileReader csvReader = new FileReader(String.valueOf(csvShowEventsResource));
            showEventRepo = CsvShowEventRepository.importData(csvReader);
            csvReader.close();
            logger.info("Imported csvShowEventRepository");
        } else {
            throw new IllegalArgumentException("Not known filestorage property: " + fileStorage);
        }
        return showEventRepo;
    }

    public static void saveShowEventRepository(ShowEventRepository repo) throws IOException {

        String fileStorage = getFileStorage();

        if ("csv".equalsIgnoreCase(fileStorage)) {
            String csvShowEventsResource = getCsvShowEventResourcePath(fileStorage);
            FileWriter writer = new FileWriter(csvShowEventsResource);
            CsvShowEventRepository.exportData(writer, repo);
            writer.flush();
            writer.close();
            logger.info("Exported csvShowEventRepository");
        } else {
            throw new IllegalArgumentException("Not known filestorage property: " + fileStorage);
        }
    }

    private static String getFileStorage() throws IOException {
        prop = ApplicationPropertiesService.getApplicationProperties();
        return prop.getProperty("filestorage");
    }

    private static String getCsvShowEventResourcePath(String fileStorage) throws IOException {

        String csvPath = ApplicationRepositoryService.class.getClassLoader().getResource(fileStorage + "/SHOWEVENTS.csv").getPath();
        if (csvPath == null) {
            throw new IOException ("File '" + csvPath + "' not found!");
        }
        return csvPath;
    }
}
