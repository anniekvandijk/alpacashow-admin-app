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

    private String WORK_DIR;
    private ShowEventRepository showEventRepo;

    public Application(final Properties prop) throws IOException {
        FileReader reader = new FileReader(prop.getProperty("filestorage"));
      //  if (prop.equalsIgnoreCase("csv")) {
        WORK_DIR = System.getProperty("user.dir");
        FileReader csvReader = new FileReader(WORK_DIR + prop.getProperty("csv-showevent-filedir"));
            showEventRepo = CsvShowEventRepository.create(csvReader);
     //   }

    }

    public void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader(new File("application.properties")));

        Application app = new Application(prop);

        System.out.println("Application is running");

    }
}
