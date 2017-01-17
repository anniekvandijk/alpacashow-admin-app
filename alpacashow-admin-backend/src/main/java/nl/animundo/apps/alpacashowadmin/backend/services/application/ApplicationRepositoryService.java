package nl.animundo.apps.alpacashowadmin.backend.services.application;

import nl.animundo.apps.alpacashowadmin.backend.domain.*;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import nl.animundo.apps.alpacashowadmin.backend.repositories.*;
import nl.animundo.apps.alpacashowadmin.backend.repositories.csv.*;
import nl.animundo.apps.alpacashowadmin.backend.services.AgeClassService;
import nl.animundo.apps.alpacashowadmin.backend.services.ShowClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ApplicationRepositoryService {

    private static Logger logger = LoggerFactory.getLogger(ApplicationRepositoryService.class);
    private static ApplicationFileDirService fileDirService = new ApplicationFileDirService();
    private static String fileStorage = "csv";
    private ShowEventRepository showEventRepository;
    private ParticipantRepository participantRepository;
    private AnimalRepository animalRepository;
    private ShowEventParticipantRepository showEventParticipantRepository;
    private ShowEventRegistrationRepository showEventRegistrationRepository;

    public ApplicationRepositoryService() {
        showEventRepository = new ShowEventRepository();
        participantRepository = new ParticipantRepository();
        animalRepository = new AnimalRepository();
        showEventParticipantRepository = new ShowEventParticipantRepository();
        showEventRegistrationRepository = new ShowEventRegistrationRepository();
    }

    public ShowEventRepository loadShowEventRepository() throws IOException {

        String csvShowEventsResource =  fileDirService.getFilePath(fileStorage + "/SHOWEVENTS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvShowEventsResource));
        showEventRepository = CsvShowEventRepository.importData(csvReader);
        csvReader.close();
        loadCrossRepoForShowEvent();
        logger.info("Imported csvShowEventRepository");
        return showEventRepository;
    }

    public ParticipantRepository loadParticipantRepository() throws IOException {

        String csvParticipantsResource =  fileDirService.getFilePath(fileStorage + "/PARTICIPANTS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvParticipantsResource));
        participantRepository = CsvParticipantRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvParticipantRepository");
        return participantRepository;
    }

    public AnimalRepository loadAnimalRepository() throws IOException {

        String csvAnimalsResource =  fileDirService.getFilePath(fileStorage + "/ANIMALS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvAnimalsResource));
        animalRepository = CsvAnimalRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvAnimalRepository");
        return animalRepository;
    }

    public ShowEventParticipantRepository loadShowEventParticipantRepository() throws IOException {

        String csvShowEventParticipantResource =  fileDirService.getFilePath(fileStorage + "/SHOWEVENTS_PARTICIPANTS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvShowEventParticipantResource));
        showEventParticipantRepository = CsvShowEventParticipantRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvShowEventParticipantRepository");
        return showEventParticipantRepository;
    }

    public ShowEventRegistrationRepository loadShowEventRegistrationRepository() throws IOException {

        String csvShowEventRegistrationResource =  fileDirService.getFilePath(fileStorage + "/SHOWEVENTS_REGISTRATIONS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvShowEventRegistrationResource));
        showEventRegistrationRepository = CsvShowEventRegistrationRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvShowEventRegistrationRepository");
        return showEventRegistrationRepository;
    }

    public void saveShowEventRepository() throws IOException {

        String csvShowEventsResource = fileDirService.getFilePath(fileStorage + "/SHOWEVENTS.csv");
        FileWriter writer = new FileWriter(csvShowEventsResource);
        CsvShowEventRepository.exportData(writer, showEventRepository);
        saveCrossRepoForShowEvent(showEventRepository);
        writer.flush();
        writer.close();
        logger.info("Exported csvShowEventRepository");
    }

    public void saveParticipantRepository() throws IOException {

        String csvParticipantsResource = fileDirService.getFilePath(fileStorage + "/PARTICIPANTS.csv");
        FileWriter writer = new FileWriter(csvParticipantsResource);
        CsvParticipantRepository.exportData(writer, participantRepository);
        writer.flush();
        writer.close();
        logger.info("Exported csvParticipantRepository");
    }

    public void saveAnimalRepository() throws IOException {

        String csvAnimalsResource = fileDirService.getFilePath(fileStorage + "/ANIMALS.csv");
        FileWriter writer = new FileWriter(csvAnimalsResource);
        CsvAnimalRepository.exportData(writer, animalRepository);
        writer.flush();
        writer.close();
        logger.info("Exported csvAnimalRepository");
    }

    public void saveShowEventParticipantRepository() throws IOException {

        String csvShowEventParticipantResource = fileDirService.getFilePath(fileStorage + "/SHOWEVENTS_PARTICIPANTS.csv");
        FileWriter writer = new FileWriter(csvShowEventParticipantResource);
        CsvShowEventParticipantRepository.exportData(writer, showEventParticipantRepository);
        writer.flush();
        writer.close();
        logger.info("Exported csvShowEventParticipantRepository");
    }

    public void saveShowEventRegistrationRepository() throws IOException {

        String csvShowEventRegistrationResource = fileDirService.getFilePath(fileStorage + "/SHOWEVENTS_REGISTRATIONS.csv");
        FileWriter writer = new FileWriter(csvShowEventRegistrationResource);
        CsvShowEventRegistrationRepository.exportData(writer, showEventRegistrationRepository);
        writer.flush();
        writer.close();
        logger.info("Exported csvShowEventRegistrationRepository");
    }

    private void saveCrossRepoForShowEvent (ShowEventRepository showEventRepository) throws IOException {

        for (String showEventKey : showEventRepository.getAllShowEventsByKeySet()) {
            ShowEvent showEvent = showEventRepository.getShowEventByKeySet(showEventKey);
            for (Participant participant : showEvent.getParticipants()) {
                String participantKey = participantRepository.add(participant);
                ShowEventParticipant part = new ShowEventParticipant(showEventKey, participantKey);
                showEventParticipantRepository.add(part);
                for (Animal animal : participant.getAnimals()) {
                    String animalKey = animalRepository.add(animal);

                    AgeClass ageClass = AgeClassService.ageClass(showEvent, animal);
                    int showClass = ShowClassService.getShowClassCode(animal.getBreed(), ageClass, animal.getSex(), animal.getColor());
                    ShowEventRegistration registration = new ShowEventRegistration(showEventKey, participantKey, animalKey, ageClass, showClass, animal.getSheerDate(), animal.getBeforeSheerDate());

                    showEventRegistrationRepository.add(registration);
                }
            }
        }
        saveShowEventParticipantRepository();
        saveShowEventRegistrationRepository();
    }

    private void loadCrossRepoForShowEvent () throws IOException {

        loadShowEventParticipantRepository();
        loadParticipantRepository();

        for (String showEventKey : showEventRepository.getAllShowEventsByKeySet()) {
            ShowEvent showEvent = showEventRepository.getShowEventByKeySet(showEventKey);
            Set<Participant> participants = new HashSet<>();
            for (ShowEventParticipant showEventParticipant : showEventParticipantRepository.getAllShowEventParticipants()) {
                if (showEventKey.equals(showEventParticipant.getShowEventKey())) {
                    Participant participant = participantRepository.getParticipantByKeySet(showEventParticipant.getParticipantKey());
                    participants.add(participant);
                }
            }
            showEvent.setParticipants(participants);
        }
    }
}
