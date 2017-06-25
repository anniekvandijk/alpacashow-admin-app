package nl.animundo.apps.alpacashowadmin.backend.services.application;

import nl.animundo.apps.alpacashowadmin.backend.context.RepositoryContext;
import nl.animundo.apps.alpacashowadmin.backend.domain.*;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventAnimalDetail;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventAnimalSheeringDetail;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventParticipant;
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
    private RepositoryContext context;

    public ApplicationRepositoryService (RepositoryContext context)
    {
        this.context = context;
    }

    public Repository <ShowEvent> loadShowEventRepository() throws IOException {

        String csvShowEventsResource = fileDirService.getFilePath("csv/showregistration/SHOWEVENTS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvShowEventsResource));
        context.showEventRepo = CsvShowEventRepository.importData(csvReader);
        csvReader.close();
        loadCrossRepoForShowEvent();
        logger.info("Imported csvShowEventRepository");
        return context.showEventRepo;
    }

    public Repository<Participant> loadParticipantRepository() throws IOException {

        String csvParticipantsResource = fileDirService.getFilePath("csv/showregistration/PARTICIPANTS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvParticipantsResource));
        context.participantRepo = CsvParticipantRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvParticipantRepository");
        return context.participantRepo;
    }

    public Repository <Animal> loadAnimalRepository() throws IOException {

        String csvAnimalsResource = fileDirService.getFilePath("csv/showregistration/ANIMALS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvAnimalsResource));
       // context.animalRepository = CsvAnimalRepository.importData(csvReader);
        context.animalRepo = CsvAnimalRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvAnimalRepository");
        return context.animalRepo;
    }

    public ShowEventParticipantRepository loadShowEventParticipantRepository() throws IOException {

        String csvShowEventParticipantResource = fileDirService.getFilePath("csv/showregistration/SHOWEVENTS_PARTICIPANTS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvShowEventParticipantResource));
        context.showEventParticipantRepository = CsvShowEventParticipantRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvShowEventParticipantRepository");
        return context.showEventParticipantRepository;
    }

    public ShowEventAnimalDetailRepository loadShowEventAnimalDetailRepository() throws IOException {

        String csvShowEventAnimalDetailResource = fileDirService.getFilePath("csv/showregistration/SHOWEVENTS_ANIMALDETAIL.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvShowEventAnimalDetailResource));
        context.showEventAnimalDetailRepository = CsvShowEventAnimalDetailRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvShowEventAnimalDetailRepository");
        return context.showEventAnimalDetailRepository;
    }

    public FleeceWeightPointsRepository loadFleeceWeightPointsRepository() throws IOException {

        String csvFleeceWeightPointsResource = fileDirService.getFilePath("csv/helpfiles/FLEECEWEIGHTPOINTS.csv");

        FileReader csvReader = new FileReader(String.valueOf(csvFleeceWeightPointsResource));
        context.fleeceWeightPointsRepository = CsvFleeceWeightPointsRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvFleeceWeightPointsRepository");
        return context.fleeceWeightPointsRepository;
    }

    public void saveShowEventRepository() throws IOException {

        String csvShowEventsResource = fileDirService.getFilePath("csv/showregistration/SHOWEVENTS.csv");
        FileWriter writer = new FileWriter(csvShowEventsResource);
        CsvShowEventRepository.exportData(writer, context.showEventRepo);
        saveCrossRepoForShowEvent(context.showEventRepo);
        writer.flush();
        writer.close();
        logger.info("Exported csvShowEventRepository");
    }

    public void saveParticipantRepository() throws IOException {

        String csvParticipantsResource = fileDirService.getFilePath("csv/showregistration/PARTICIPANTS.csv");
        FileWriter writer = new FileWriter(csvParticipantsResource);
        CsvParticipantRepository.exportData(writer, context.participantRepo);
        writer.flush();
        writer.close();
        logger.info("Exported csvParticipantRepository");
    }

    public void saveAnimalRepository() throws IOException {

        String csvAnimalsResource = fileDirService.getFilePath("csv/showregistration/ANIMALS.csv");
        FileWriter writer = new FileWriter(csvAnimalsResource);
        CsvAnimalRepository.exportData(writer, context.animalRepo);
        writer.flush();
        writer.close();
        logger.info("Exported csvAnimalRepository");
    }

    public void saveShowEventParticipantRepository() throws IOException {

        String csvShowEventParticipantResource = fileDirService.getFilePath("csv/showregistration/SHOWEVENTS_PARTICIPANTS.csv");
        FileWriter writer = new FileWriter(csvShowEventParticipantResource);
        CsvShowEventParticipantRepository.exportData(writer, context.showEventParticipantRepository);
        writer.flush();
        writer.close();
        logger.info("Exported csvShowEventParticipantRepository");
    }

    public void saveShowEventAnimalDetailRepository() throws IOException {

        String csvShowEventAnimalDetailResource = fileDirService.getFilePath("csv/showregistration/SHOWEVENTS_ANIMALDETAIL.csv");
        FileWriter writer = new FileWriter(csvShowEventAnimalDetailResource);
        CsvShowEventAnimalDetailRepository.exportData(writer, context.showEventAnimalDetailRepository);
        writer.flush();
        writer.close();
        logger.info("Exported csvShowEventAnimalDetailRepository");
    }

    private void saveCrossRepoForShowEvent(Repository <ShowEvent> showEventRepository) throws IOException {

//        for (String showEventKey : showEventRepository.getAllShowEventsById()) {
//            ShowEvent showEvent = showEventRepository.getShowEventById(showEventKey);
//            for (Participant participant : showEvent.getParticipants()) {
//                Participant participant = context.participantRepository.add(participant);
//                ShowEventParticipant part = new ShowEventParticipant(showEventKey, participantKey);
//                context.showEventParticipantRepository.add(part);
//                for (Animal animal : participant.getAnimals()) {
//                    String animalKey = context.animalRepository.add(animal);
//                    AgeClass ageclass = AgeClassService.ageClass(showEvent, animal);
//                    int showClass = ShowClassService.getShowClassCode(animal.getBreed(), ageclass, animal.getSex(), animal.getColor());
//                    ShowEventAnimalDetail showEventAnimal = new ShowEventAnimalDetail(showEventKey, participantKey, animalKey, animal.getShowEventAnimalSheeringDetail().getSheerDate(),
//                            animal.getShowEventAnimalSheeringDetail().getBeforeSheerDate(), ageclass, showClass);
//
//                    context.showEventAnimalDetailRepository.add(showEventAnimal);
//                }
//            }
//        }
//        saveShowEventParticipantRepository();
//        saveShowEventAnimalDetailRepository();
    }

    private void loadCrossRepoForShowEvent() throws IOException {

//        loadParticipantRepository();
//        loadShowEventParticipantRepository();
//        loadAnimalRepository();
//        loadShowEventAnimalDetailRepository();
//
//
//        Set <String> showEventsByKey = context.showEventRepository.getAllShowEventsById();
//        Set <String> participantsByKey = context.participantRepository.getAllParticipantsById();
//        Set <String> animalsById = context.animalRepository.getAllAnimalsById();
//        Collection <ShowEventParticipant> showEventParticipants = context.showEventParticipantRepository.getAllShowEventParticipants();
//        Collection <ShowEventAnimalDetail> showEventAnimalDetails = context.showEventAnimalDetailRepository.getAllShowEventAnimalDetails();
//
//        // Loop ShowEvents and get details
//        for (String id : showEventsByKey) {
//            ShowEvent showEvent = context.showEventRepository.getShowEventById(id);
//
//            Set<Participant> participants = new LinkedHashSet<Participant>();
//
//            // Loop participants and get participants for the show. Add participant details to show
//            for (String participantKey : participantsByKey) {
//                for (ShowEventParticipant showEventParticipant : showEventParticipants)
//                {
//                    String showKey = showEventParticipant.getShowEventKey();
//                    String partKey = showEventParticipant.getParticipantKey();
//                    if (id.equals(showKey) && participantKey.equals(partKey))
//                    {
//
//                        Participant participant = context.participantRepository.getParticipantById(participantKey);
//
//                        Set<Animal> animals = new LinkedHashSet<Animal>();
//
//                        // Loop animals and get animals for the participant. Add animal details to participant
//                        for (String animalId : animalsById) {
//                            for (ShowEventAnimalDetail showEventAnimalDetail : showEventAnimalDetails) {
//                                String show = showEventAnimalDetail.getShowEventKey();
//                                String part = showEventAnimalDetail.getParticipantKey();
//                                String ani = showEventAnimalDetail.getAnimalKey();
//
//                                if (id.equals(show) && participantKey.equals(part) && id.equals(ani)) {
//                                    Animal animal = context.animalRepository.getAnimalById(id);
//                                    LocalDate sheerDate = showEventAnimalDetail.getSheerDate();
//                                    LocalDate beforeSheerDate = showEventAnimalDetail.getBeforeSheerDate();
//                                    ShowEventAnimalSheeringDetail showEventAnimalSheeringDetail = new ShowEventAnimalSheeringDetail(sheerDate, beforeSheerDate);
//                                    animals.add(new Animal(animal.getId(),animal.getName(), animal.getBreed(), animal.getSex(), animal.getColor(), animal.getDateOfBirth(),
//                                            animal.getMicrochip(), animal.getRegistration(), animal.getSire(), animal.getDam(), showEventAnimalSheeringDetail));
//
//                                }
//                            }
//                        }
//                        participants.add(new Participant(participant.getId(),participant.getName(), participant.getFarmName(), participant.getEmail(), participant.getTelephone(),
//                                    participant.getAddress(), participant.getZipCode(), participant.getCity(), participant.getCountry(), animals));
//                    }
//                }
//            }
//            showEvent.setParticipants(participants);
//        }
    }
}

