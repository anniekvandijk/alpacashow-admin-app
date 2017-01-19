package nl.animundo.apps.alpacashowadmin.backend.services.application;

import nl.animundo.apps.alpacashowadmin.backend.utilities.AnimalComparator;
import nl.animundo.apps.alpacashowadmin.backend.utilities.ParticipantComparator;
import nl.animundo.apps.alpacashowadmin.backend.domain.*;
import nl.animundo.apps.alpacashowadmin.backend.repositories.*;
import nl.animundo.apps.alpacashowadmin.backend.repositories.csv.*;
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
    private ShowEventAnimalRepository showEventAnimalRepository;

    public ShowEventRepository loadShowEventRepository() throws IOException {

        String csvShowEventsResource = fileDirService.getFilePath(fileStorage + "/showregistration/SHOWEVENTS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvShowEventsResource));
        showEventRepository = CsvShowEventRepository.importData(csvReader);
        csvReader.close();
        loadCrossRepoForShowEvent();
        logger.info("Imported csvShowEventRepository");
        return showEventRepository;
    }

    public ParticipantRepository loadParticipantRepository() throws IOException {

        String csvParticipantsResource = fileDirService.getFilePath(fileStorage + "/showregistration/PARTICIPANTS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvParticipantsResource));
        participantRepository = CsvParticipantRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvParticipantRepository");
        return participantRepository;
    }

    public AnimalRepository loadAnimalRepository() throws IOException {

        String csvAnimalsResource = fileDirService.getFilePath(fileStorage + "/showregistration/ANIMALS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvAnimalsResource));
        animalRepository = CsvAnimalRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvAnimalRepository");
        return animalRepository;
    }

    public ShowEventParticipantRepository loadShowEventParticipantRepository() throws IOException {

        String csvShowEventParticipantResource = fileDirService.getFilePath(fileStorage + "/showregistration/SHOWEVENTS_PARTICIPANTS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvShowEventParticipantResource));
        showEventParticipantRepository = CsvShowEventParticipantRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvShowEventParticipantRepository");
        return showEventParticipantRepository;
    }

    public ShowEventAnimalRepository loadShowEventAnimalRepository() throws IOException {

        String csvShowEventAnimalResource = fileDirService.getFilePath(fileStorage + "/showregistration/SHOWEVENTS_ANIMALS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvShowEventAnimalResource));
        showEventAnimalRepository = CsvShowEventAnimalRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvShowEventAnimalRepository");
        return showEventAnimalRepository;
    }

    public void saveShowEventRepository() throws IOException {

        String csvShowEventsResource = fileDirService.getFilePath(fileStorage + "/showregistration/SHOWEVENTS.csv");
        FileWriter writer = new FileWriter(csvShowEventsResource);
        CsvShowEventRepository.exportData(writer, showEventRepository);
        saveCrossRepoForShowEvent(showEventRepository);
        writer.flush();
        writer.close();
        logger.info("Exported csvShowEventRepository");
    }

    public void saveParticipantRepository() throws IOException {

        String csvParticipantsResource = fileDirService.getFilePath(fileStorage + "/showregistration/PARTICIPANTS.csv");
        FileWriter writer = new FileWriter(csvParticipantsResource);
        CsvParticipantRepository.exportData(writer, participantRepository);
        writer.flush();
        writer.close();
        logger.info("Exported csvParticipantRepository");
    }

    public void saveAnimalRepository() throws IOException {

        String csvAnimalsResource = fileDirService.getFilePath(fileStorage + "/showregistration/ANIMALS.csv");
        FileWriter writer = new FileWriter(csvAnimalsResource);
        CsvAnimalRepository.exportData(writer, animalRepository);
        writer.flush();
        writer.close();
        logger.info("Exported csvAnimalRepository");
    }

    public void saveShowEventParticipantRepository() throws IOException {

        String csvShowEventParticipantResource = fileDirService.getFilePath(fileStorage + "/showregistration/SHOWEVENTS_PARTICIPANTS.csv");
        FileWriter writer = new FileWriter(csvShowEventParticipantResource);
        CsvShowEventParticipantRepository.exportData(writer, showEventParticipantRepository);
        writer.flush();
        writer.close();
        logger.info("Exported csvShowEventParticipantRepository");
    }

    public void saveShowEventAnimalRepository() throws IOException {

        String csvShowEventAnimalResource = fileDirService.getFilePath(fileStorage + "/showregistration/SHOWEVENTS_ANIMALS.csv");
        FileWriter writer = new FileWriter(csvShowEventAnimalResource);
        CsvShowEventAnimalRepository.exportData(writer, showEventAnimalRepository);
        writer.flush();
        writer.close();
        logger.info("Exported csvShowEventAnimalRepository");
    }

    private void saveCrossRepoForShowEvent(ShowEventRepository showEventRepository) throws IOException {

        for (String showEventKey : showEventRepository.getAllShowEventsByKeySet()) {
            ShowEvent showEvent = showEventRepository.getShowEventByKeySet(showEventKey);
            for (Participant participant : showEvent.getParticipants()) {
                String participantKey = participantRepository.add(participant);
                ShowEventParticipant part = new ShowEventParticipant(showEventKey, participantKey);
                showEventParticipantRepository.add(part);
                for (Animal animal : participant.getAnimals()) {
                    String animalKey = animalRepository.add(animal);
                    ShowEventAnimal showEventAnimal = new ShowEventAnimal(showEventKey, participantKey, animalKey,
                            animal.getAnimalShowDetail().getSheerDate(), animal.getAnimalShowDetail().getBeforeSheerDate());

                    showEventAnimalRepository.add(showEventAnimal);
                }
            }
        }
        saveShowEventParticipantRepository();
        saveShowEventAnimalRepository();
    }

    private void loadCrossRepoForShowEvent() throws IOException {

        loadParticipantRepository();
        loadShowEventParticipantRepository();
        loadAnimalRepository();
        loadShowEventAnimalRepository();


        Set <String> showEventsByKey = showEventRepository.getAllShowEventsByKeySet();
        Set <String> participantsByKey = participantRepository.getAllParticipantsByKeySet();
        Set <String> animalsByKey = animalRepository.getAllAnimalsByKeySet();
        Collection <ShowEventParticipant> showEventParticipants = showEventParticipantRepository.getAllShowEventParticipants();
        Collection <ShowEventAnimal> showEventAnimals = showEventAnimalRepository.getAllShowEventAnimals();

        // Loop ShowEvents and get details
        for (String showEventKey : showEventsByKey) {
            ShowEvent showEvent = showEventRepository.getShowEventByKeySet(showEventKey);

            SortedSet<Participant> participants = new TreeSet<>(new ParticipantComparator());

            // Loop participants and get participants for the show. Add participant details to show
            for (String participantKey : participantsByKey) {
                for (ShowEventParticipant showEventParticipant : showEventParticipants)
                {
                    String showKey = showEventParticipant.getShowEventKey();
                    String partKey = showEventParticipant.getParticipantKey();
                    if (showEventKey.equals(showKey) && participantKey.equals(partKey))
                    {

                        Participant participant = participantRepository.getParticipantByKeySet(participantKey);

                        SortedSet<Animal> animals = new TreeSet<>(new AnimalComparator());

                        // Loop animals and get animals for the participant. Add animal details to participant
                        for (String animalKey : animalsByKey) {
                            for (ShowEventAnimal showEventAnimal : showEventAnimals) {
                                String show = showEventAnimal.getShowEventKey();
                                String part = showEventAnimal.getParticipantKey();
                                String ani = showEventAnimal.getAnimalKey();

                                if (showEventKey.equals(show) && participantKey.equals(part) && animalKey.equals(ani)) {
                                    Animal animal = animalRepository.getAnimalByKeySet(animalKey);
                                    // If there is showDetail for the animal, add this to the animal
                                    LocalDate sheerDate = showEventAnimal.getSheerDate();
                                    LocalDate beforeSheerDate = showEventAnimal.getBeforeSheerDate();
                                    AnimalShowDetail animalShowDetail = new AnimalShowDetail(sheerDate, beforeSheerDate);

                                    animals.add(new Animal(animal.getName(), animal.getBreed(), animal.getSex(), animal.getColor(), animal.getDateOfBirth(),
                                            animal.getMicrochip(), animal.getRegistration(), animal.getSire(), animal.getDam(), animalShowDetail));
                                }
                            }
                        }
                        participants.add(new Participant(participant.getName(), participant.getFarmName(), participant.getEmail(), participant.getTelephone(),
                                    participant.getAddress(), participant.getZipCode(), participant.getCity(), participant.getCountry(), animals));
                    }
                }
            }
            showEvent.setParticipants(participants);
        }
    }
}

