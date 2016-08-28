package nl.animundo.apps.alpacashowadmin.backend.services.application;

import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.csv.CsvShowEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Anniek van Dijk on 7-8-2016.
 */
public class ApplicationRepositoryService {

    private static Logger logger = LoggerFactory.getLogger(ApplicationRepositoryService.class);
    private static String workingDir = ApplicationUserDirService.getUserDir();
    private static Properties prop = new Properties();
    private static ShowEventRepository showEventRepo = new ShowEventRepository();

    private ApplicationRepositoryService() throws InstantiationException {
        throw new InstantiationException("Instances of this type are forbidden!");
    }

    public static ShowEventRepository loadShowEventRepository() throws IOException {

        String fileStorage = getFileStorage();

        if ("csv".equalsIgnoreCase(fileStorage)) {
            String csvShowEventFileDir = prop.getProperty("csv-showevent-filedir");
            FileReader csvReader = new FileReader(workingDir + csvShowEventFileDir);
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
            String csvShowEventFileDir = prop.getProperty("csv-showevent-filedir");
            File newExportFile = new File(workingDir + csvShowEventFileDir);
            FileWriter writer = new FileWriter(newExportFile);
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
}
