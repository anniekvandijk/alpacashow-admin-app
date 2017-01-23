package nl.animundo.apps.alpacashowadmin.backend.services.application;

import nl.animundo.apps.alpacashowadmin.backend.domain.*;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventAnimalDetail;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventAnimalSheeringDetail;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventParticipant;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventParticipantAnimal;
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
    private ShowEventRepository showEventRepository;
    private ParticipantRepository participantRepository;
    private AnimalRepository animalRepository;
    private ShowEventParticipantRepository showEventParticipantRepository;
    private ShowEventParticipantAnimalRepository showEventParticipantAnimalRepository;
    private ShowEventAnimalDetailRepository showEventAnimalDetailRepository;
    private FleeceWeightPointsRepository fleeceWeightPointsRepository;

    public ShowEventRepository loadShowEventRepository() throws IOException {

        String csvShowEventsResource = fileDirService.getFilePath("csv/showregistration/SHOWEVENTS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvShowEventsResource));
        showEventRepository = CsvShowEventRepository.importData(csvReader);
        csvReader.close();
        loadCrossRepoForShowEvent();
        logger.info("Imported csvShowEventRepository");
        return showEventRepository;
    }

    public ParticipantRepository loadParticipantRepository() throws IOException {

        String csvParticipantsResource = fileDirService.getFilePath("csv/showregistration/PARTICIPANTS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvParticipantsResource));
        participantRepository = CsvParticipantRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvParticipantRepository");
        return participantRepository;
    }

    public AnimalRepository loadAnimalRepository() throws IOException {

        String csvAnimalsResource = fileDirService.getFilePath("csv/showregistration/ANIMALS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvAnimalsResource));
        animalRepository = CsvAnimalRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvAnimalRepository");
        return animalRepository;
    }

    public ShowEventParticipantRepository loadShowEventParticipantRepository() throws IOException {

        String csvShowEventParticipantResource = fileDirService.getFilePath("csv/showregistration/SHOWEVENTS_PARTICIPANTS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvShowEventParticipantResource));
        showEventParticipantRepository = CsvShowEventParticipantRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvShowEventParticipantRepository");
        return showEventParticipantRepository;
    }

    public ShowEventParticipantAnimalRepository loadShowEventParticipantAnimalRepository() throws IOException {

        String csvShowEventParticipantAnimalResource = fileDirService.getFilePath("csv/showregistration/SHOWEVENTS_PARTICIPANTS_ANIMALS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvShowEventParticipantAnimalResource));
        showEventParticipantAnimalRepository = CsvShowEventParticipantAnimalRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvShowEventParticipantAnimalRepository");
        return showEventParticipantAnimalRepository;
    }

    public ShowEventAnimalDetailRepository loadShowEventAnimalDetailRepository() throws IOException {

        String csvShowEventAnimalDetailResource = fileDirService.getFilePath("csv/showregistration/SHOWEVENTS_ANIMALDETAIL.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvShowEventAnimalDetailResource));
        showEventAnimalDetailRepository = CsvShowEventAnimalDetailRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvShowEventAnimalDetailRepository");
        return showEventAnimalDetailRepository;
    }

    public FleeceWeightPointsRepository loadFleeceWeightPointsRepository() throws IOException {

        String csvFleeceWeightPointsResource = fileDirService.getFilePath("csv/helpfiles/FLEECEWEIGHTPOINTS.csv");

        FileReader csvReader = new FileReader(String.valueOf(csvFleeceWeightPointsResource));
        fleeceWeightPointsRepository = CsvFleeceWeightPointsRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvFleeceWeightPointsRepository");
        return fleeceWeightPointsRepository;
    }

    public void saveShowEventRepository() throws IOException {

        String csvShowEventsResource = fileDirService.getFilePath("csv/showregistration/SHOWEVENTS.csv");
        FileWriter writer = new FileWriter(csvShowEventsResource);
        CsvShowEventRepository.exportData(writer, showEventRepository);
        saveCrossRepoForShowEvent(showEventRepository);
        writer.flush();
        writer.close();
        logger.info("Exported csvShowEventRepository");
    }

    public void saveParticipantRepository() throws IOException {

        String csvParticipantsResource = fileDirService.getFilePath("csv/showregistration/PARTICIPANTS.csv");
        FileWriter writer = new FileWriter(csvParticipantsResource);
        CsvParticipantRepository.exportData(writer, participantRepository);
        writer.flush();
        writer.close();
        logger.info("Exported csvParticipantRepository");
    }

    public void saveAnimalRepository() throws IOException {

        String csvAnimalsResource = fileDirService.getFilePath("csv/showregistration/ANIMALS.csv");
        FileWriter writer = new FileWriter(csvAnimalsResource);
        CsvAnimalRepository.exportData(writer, animalRepository);
        writer.flush();
        writer.close();
        logger.info("Exported csvAnimalRepository");
    }

    public void saveShowEventParticipantRepository() throws IOException {

        String csvShowEventParticipantResource = fileDirService.getFilePath("csv/showregistration/SHOWEVENTS_PARTICIPANTS.csv");
        FileWriter writer = new FileWriter(csvShowEventParticipantResource);
        CsvShowEventParticipantRepository.exportData(writer, showEventParticipantRepository);
        writer.flush();
        writer.close();
        logger.info("Exported csvShowEventParticipantRepository");
    }

    public void saveShowEventParticipantAnimalRepository() throws IOException {

        String csvShowEventParticipantAnimalResource = fileDirService.getFilePath("csv/showregistration/SHOWEVENTS_PARTICIPANTS_ANIMALS.csv");
        FileWriter writer = new FileWriter(csvShowEventParticipantAnimalResource);
        CsvShowEventParticipantAnimalRepository.exportData(writer, showEventParticipantAnimalRepository);
        writer.flush();
        writer.close();
        logger.info("Exported csvShowEventParticipantAnimalRepository");
    }

    public void saveShowEventAnimalDetailRepository() throws IOException {

        String csvShowEventAnimalDetailResource = fileDirService.getFilePath("csv/showregistration/SHOWEVENTS_ANIMALDETAIL.csv");
        FileWriter writer = new FileWriter(csvShowEventAnimalDetailResource);
        CsvShowEventAnimalDetailRepository.exportData(writer, showEventAnimalDetailRepository);
        writer.flush();
        writer.close();
        logger.info("Exported csvShowEventAnimalDetailRepository");
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
                    ShowEventParticipantAnimal partAni = new ShowEventParticipantAnimal(showEventKey, participantKey, animalKey);
                    showEventParticipantAnimalRepository.add(partAni);
                    AgeClass ageclass = AgeClassService.ageClass(showEvent, animal);
                    int showClass = ShowClassService.getShowClassCode(animal.getBreed(), ageclass, animal.getSex(), animal.getColor());
                    ShowEventAnimalDetail showEventAnimal = new ShowEventAnimalDetail(showEventKey, participantKey, animalKey, animal.getShowEventAnimalSheeringDetail().getSheerDate(),
                            animal.getShowEventAnimalSheeringDetail().getBeforeSheerDate(), ageclass, showClass);

                    showEventAnimalDetailRepository.add(showEventAnimal);
                }
            }
        }
        saveShowEventParticipantRepository();
        saveShowEventParticipantAnimalRepository();
        saveShowEventAnimalDetailRepository();
    }

    private void loadCrossRepoForShowEvent() throws IOException {

        loadParticipantRepository();
        loadShowEventParticipantRepository();
        loadShowEventParticipantAnimalRepository();
        loadAnimalRepository();
        loadShowEventAnimalDetailRepository();


        Set <String> showEventsByKey = showEventRepository.getAllShowEventsByKeySet();
        Set <String> participantsByKey = participantRepository.getAllParticipantsByKeySet();
        Set <String> animalsByKey = animalRepository.getAllAnimalsByKeySet();
        Collection <ShowEventParticipant> showEventParticipants = showEventParticipantRepository.getAllShowEventParticipants();
        Collection <ShowEventParticipantAnimal> showEventParticipantAnimals = showEventParticipantAnimalRepository.getAllShowEventParticipantAnimals();
        Collection <ShowEventAnimalDetail> showEventAnimalDetails = showEventAnimalDetailRepository.getAllShowEventAnimalDetails();

        // Loop ShowEvents and get details
        for (String showEventKey : showEventsByKey) {
            ShowEvent showEvent = showEventRepository.getShowEventByKeySet(showEventKey);

            Set<Participant> participants = new LinkedHashSet<Participant>();

            // Loop participants and get participants for the show. Add participant details to show
            for (String participantKey : participantsByKey) {
                for (ShowEventParticipant showEventParticipant : showEventParticipants)
                {
                    String showKey = showEventParticipant.getShowEventKey();
                    String partKey = showEventParticipant.getParticipantKey();
                    if (showEventKey.equals(showKey) && participantKey.equals(partKey))
                    {

                        Participant participant = participantRepository.getParticipantByKeySet(participantKey);

                        Set<Animal> animals = new LinkedHashSet<Animal>();

                        // Loop animals and get animals for the participant. Add animal details to participant
                        for (String animalKey : animalsByKey) {
                            for (ShowEventParticipantAnimal showEventAnimal : showEventParticipantAnimals) {
                                String show = showEventAnimal.getShowEventKey();
                                String part = showEventAnimal.getParticipantKey();
                                String ani = showEventAnimal.getAnimalKey();

                                if (showEventKey.equals(show) && participantKey.equals(part) && animalKey.equals(ani)) {
                                    Animal animal = animalRepository.getAnimalByKeySet(animalKey);
                                    // If there is showDetail for the animal, add this to the animal
                                    for (ShowEventAnimalDetail showEventAnimalDetail : showEventAnimalDetails)
                                        if (animalKey.equals(showEventAnimalDetail.getAnimalKey()))
                                        {
                                            LocalDate sheerDate = showEventAnimalDetail.getSheerDate();
                                            LocalDate beforeSheerDate = showEventAnimalDetail.getBeforeSheerDate();
                                            AgeClass ageClass = showEventAnimalDetail.getAgeClass();
                                            int showClass = showEventAnimalDetail.getShowClass();
                                            ShowEventAnimalSheeringDetail showEventAnimalSheeringDetail = new ShowEventAnimalSheeringDetail(sheerDate, beforeSheerDate);
                                            showEventAnimalDetail = new ShowEventAnimalDetail(showEventKey, participantKey, animalKey, sheerDate, beforeSheerDate, ageClass, showClass);
                                            animals.add(new Animal(animal.getName(), animal.getBreed(), animal.getSex(), animal.getColor(), animal.getDateOfBirth(),
                                                    animal.getMicrochip(), animal.getRegistration(), animal.getSire(), animal.getDam(), showEventAnimalSheeringDetail));
                                        }
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

