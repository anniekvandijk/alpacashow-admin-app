package nl.animundo.apps.alpacashowadmin.backend.services.application;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventRegistration;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.repositories.AnimalRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ParticipantRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRegistrationRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.csv.CsvAnimalRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.csv.CsvParticipantRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.csv.CsvShowEventRegistrationRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.csv.CsvShowEventRepository;
import nl.animundo.apps.alpacashowadmin.backend.services.AgeClassService;
import nl.animundo.apps.alpacashowadmin.backend.services.ShowClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Set;

import static com.sun.xml.bind.v2.util.ClassLoaderRetriever.getClassLoader;


public class ApplicationRepositoryService {

    private static Logger logger = LoggerFactory.getLogger(ApplicationRepositoryService.class);
    private static ApplicationFileDirService fileDirService = new ApplicationFileDirService();
    private static String fileStorage = "csv";
    private ShowEventRepository showEventRepository;
    private ParticipantRepository participantRepository;
    private AnimalRepository animalRepository;
    private ShowEventRegistrationRepository showEventRegistrationRepository;

    public ApplicationRepositoryService() {
        showEventRepository = new ShowEventRepository();
        participantRepository = new ParticipantRepository();
        animalRepository = new AnimalRepository();
        showEventRegistrationRepository = new ShowEventRegistrationRepository();
    }

    public ShowEventRepository loadShowEventRepository() throws IOException {

        if ("csv".equalsIgnoreCase(fileStorage)) {
            String csvShowEventsResource =  fileDirService.getFilePath(fileStorage + "/SHOWEVENTS.csv");
            FileReader csvReader = new FileReader(String.valueOf(csvShowEventsResource));
            showEventRepository = CsvShowEventRepository.importData(csvReader);
            csvReader.close();
            logger.info("Imported csvShowEventRepository");
        }
        return showEventRepository;
    }

    public ParticipantRepository loadParticipantRepository() throws IOException {

        if ("csv".equalsIgnoreCase(fileStorage)) {
            String csvParticipantsResource =  fileDirService.getFilePath(fileStorage + "/PARTICIPANTS.csv");
            FileReader csvReader = new FileReader(String.valueOf(csvParticipantsResource));
            participantRepository = CsvParticipantRepository.importData(csvReader);
            csvReader.close();
            logger.info("Imported csvParticipantRepository");
        }
        return participantRepository;
    }

    public AnimalRepository loadAnimalRepository() throws IOException {

        if ("csv".equalsIgnoreCase(fileStorage)) {
            String csvAnimalsResource =  fileDirService.getFilePath(fileStorage + "/ANIMALS.csv");
            FileReader csvReader = new FileReader(String.valueOf(csvAnimalsResource));
            animalRepository = CsvAnimalRepository.importData(csvReader);
            csvReader.close();
            logger.info("Imported csvAnimalRepository");
        }
        return animalRepository;
    }

    public ShowEventRegistrationRepository loadShowEventRegistrationRepository() throws IOException {

        if ("csv".equalsIgnoreCase(fileStorage)) {
            String csvShowEventRegistrationResource =  fileDirService.getFilePath(fileStorage + "/SHOWEVENTS_REGISTRATIONS.csv");
            FileReader csvReader = new FileReader(String.valueOf(csvShowEventRegistrationResource));
            showEventRegistrationRepository = CsvShowEventRegistrationRepository.importData(csvReader);
            csvReader.close();
            logger.info("Imported csvShowEventRegistrationRepository");
        }
        return showEventRegistrationRepository;
    }

    public void saveShowEventRepository() throws IOException {

        if ("csv".equalsIgnoreCase(fileStorage)) {
            String csvShowEventsResource = fileDirService.getFilePath(fileStorage + "/SHOWEVENTS.csv");
            FileWriter writer = new FileWriter(csvShowEventsResource);
            CsvShowEventRepository.exportData(writer, showEventRepository);
            writer.flush();
            writer.close();
            logger.info("Exported csvShowEventRepository");
        }
    }

    public void saveParticipantRepository() throws IOException {

        if ("csv".equalsIgnoreCase(fileStorage)) {
            String csvParticipantsResource = fileDirService.getFilePath(fileStorage + "/PARTICIPANTS.csv");
            FileWriter writer = new FileWriter(csvParticipantsResource);
            CsvParticipantRepository.exportData(writer, participantRepository);
            writer.flush();
            writer.close();
            logger.info("Exported csvParticipantRepository");
        }
    }

    public void saveAnimalRepository() throws IOException {

        if ("csv".equalsIgnoreCase(fileStorage)) {
            String csvAnimalsResource = fileDirService.getFilePath(fileStorage + "/ANIMALS.csv");
            FileWriter writer = new FileWriter(csvAnimalsResource);
            CsvAnimalRepository.exportData(writer, animalRepository);
            writer.flush();
            writer.close();
            logger.info("Exported csvAnimalRepository");
        }
    }

    public void saveShowEventRegistrationRepository() throws IOException {

        if ("csv".equalsIgnoreCase(fileStorage)) {
            String csvShowEventRegistrationResource = fileDirService.getFilePath(fileStorage + "/SHOWEVENTS_REGISTRATIONS.csv");
            FileWriter writer = new FileWriter(csvShowEventRegistrationResource);
            CsvShowEventRegistrationRepository.exportData(writer, showEventRegistrationRepository);
            writer.flush();
            writer.close();
            logger.info("Exported csvShowEventRegistrationRepository");
        }
    }
}
