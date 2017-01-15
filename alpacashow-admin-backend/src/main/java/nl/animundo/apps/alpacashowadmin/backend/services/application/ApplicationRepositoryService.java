package nl.animundo.apps.alpacashowadmin.backend.services.application;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventRegistration;
import nl.animundo.apps.alpacashowadmin.backend.repositories.AnimalRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ParticipantRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRegistrationRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.csv.CsvAnimalRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.csv.CsvParticipantRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.csv.CsvShowEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.Properties;
import static com.sun.xml.bind.v2.util.ClassLoaderRetriever.getClassLoader;


public class ApplicationRepositoryService {

    private static Logger logger = LoggerFactory.getLogger(ApplicationRepositoryService.class);
    private static ApplicationFileDirService fileDirService = new ApplicationFileDirService();
    private static String fileStorage = "csv";
    private static ShowEventRepository showEventRepo = new ShowEventRepository();
    private static ParticipantRepository participantRepo = new ParticipantRepository();
    private static AnimalRepository animalRepo = new AnimalRepository();

    private ApplicationRepositoryService() throws InstantiationException {
        throw new InstantiationException("Instances of this type are forbidden!");
    }

    public static ShowEventRepository loadShowEventRepository() throws IOException {

        if ("csv".equalsIgnoreCase(fileStorage)) {
            String csvShowEventsResource =  fileDirService.getFilePath(fileStorage + "/SHOWEVENTS.csv");
            FileReader csvReader = new FileReader(String.valueOf(csvShowEventsResource));
            showEventRepo = CsvShowEventRepository.importData(csvReader);
            csvReader.close();
            logger.info("Imported csvShowEventRepository");
        }
        return showEventRepo;
    }

    public static ParticipantRepository loadParticipantRepository() throws IOException {

        if ("csv".equalsIgnoreCase(fileStorage)) {
            String csvParticipantsResource =  fileDirService.getFilePath(fileStorage + "/PARTICIPANTS.csv");
            FileReader csvReader = new FileReader(String.valueOf(csvParticipantsResource));
            participantRepo = CsvParticipantRepository.importData(csvReader);
            csvReader.close();
            logger.info("Imported csvParticipantRepository");
        }
        return participantRepo;
    }

    public static AnimalRepository loadAnimalRepository() throws IOException {

        if ("csv".equalsIgnoreCase(fileStorage)) {
            String csvAnimalsResource =  fileDirService.getFilePath(fileStorage + "/ANIMALS.csv");
            FileReader csvReader = new FileReader(String.valueOf(csvAnimalsResource));
            animalRepo = CsvAnimalRepository.importData(csvReader);
            csvReader.close();
            logger.info("Imported csvAnimalRepository");
        }
        return animalRepo;
    }

    public static void saveShowEventRepository(ShowEventRepository repo) throws IOException {

        if ("csv".equalsIgnoreCase(fileStorage)) {
            String csvShowEventsResource = fileDirService.getFilePath(fileStorage + "/SHOWEVENTS.csv");
            FileWriter writer = new FileWriter(csvShowEventsResource);
            CsvShowEventRepository.exportData(writer, repo);
            writer.flush();
            writer.close();
            logger.info("Exported csvShowEventRepository");
        }
    }

    public static void saveParticipantRepository(ParticipantRepository repo) throws IOException {

        if ("csv".equalsIgnoreCase(fileStorage)) {
            String csvParticipantsResource = fileDirService.getFilePath(fileStorage + "/PARTICIPANTS.csv");
            FileWriter writer = new FileWriter(csvParticipantsResource);
            CsvParticipantRepository.exportData(writer, repo);
            writer.flush();
            writer.close();
            logger.info("Exported csvParticipantRepository");
        }
    }

    public static void saveAnimalRepository(AnimalRepository repo) throws IOException {

        if ("csv".equalsIgnoreCase(fileStorage)) {
            String csvAnimalsResource = fileDirService.getFilePath(fileStorage + "/ANIMALS.csv");
            FileWriter writer = new FileWriter(csvAnimalsResource);
            CsvAnimalRepository.exportData(writer, repo);
            writer.flush();
            writer.close();
            logger.info("Exported csvAnimalRepository");
        }
    }
}
