package nl.animundo.apps.alpacashowadmin.backend.services.application;

import nl.animundo.apps.alpacashowadmin.backend.context.RepositoryContext;
import nl.animundo.apps.alpacashowadmin.backend.domain.*;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventParticipantAnimal;
import nl.animundo.apps.alpacashowadmin.backend.repositories.*;
import nl.animundo.apps.alpacashowadmin.backend.repositories.csv.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ApplicationRepositoryService {

    private static Logger logger = LoggerFactory.getLogger(ApplicationRepositoryService.class);
    private static ApplicationFileDirService fileDirService = new ApplicationFileDirService();
    private RepositoryContext context;
    private String repoType = "csv";

    public ApplicationRepositoryService (RepositoryContext context) throws IOException {
        this.context = context;

        if(repoType.equals("csv"))
        {
            loadRepositories();
        }
    }

    public void loadRepositories() throws IOException {
        loadShowEventRepository();
        loadParticipantRepository();
        loadAnimalRepository();
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
        context.animalRepo = CsvAnimalRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvAnimalRepository");
        return context.animalRepo;
    }

    public ShowEventParticipantAnimalRepository loadShowEventParticipantAnimalRepository() throws IOException {

        String csvShowEventParticipantResource = fileDirService.getFilePath("csv/showregistration/SHOWEVENTS_PARTICIPANTS_ANIMALS.csv");
        FileReader csvReader = new FileReader(String.valueOf(csvShowEventParticipantResource));
        context.showEventParticipantAnimalRepo = CsvShowEventParticipantAnimalRepository.importData(csvReader);
        csvReader.close();
        logger.info("Imported csvShowEventParticipantAnimalRepository");
        return context.showEventParticipantAnimalRepo;
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

    public void saveShowEventParticipantAnimalRepository() throws IOException {

        String csvShowEventParticipantResource = fileDirService.getFilePath("csv/showregistration/SHOWEVENTS_PARTICIPANTS_ANIMALS.csv");
        FileWriter writer = new FileWriter(csvShowEventParticipantResource);
        CsvShowEventParticipantAnimalRepository.exportData(writer, context.showEventParticipantAnimalRepo);
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
//                ShowEventParticipantAnimal part = new ShowEventParticipantAnimal(showEventKey, participantKey);
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

        loadShowEventParticipantAnimalRepository();
        loadParticipantRepository();
        loadAnimalRepository();

        // Loop ShowEvents and get details
        for (String showEventId : context.showEventRepo.getAllById()) {
            ShowEvent showEvent = context.showEventRepo.getById(showEventId);
            ShowEvent showEventWithParticipants = AddParticipantsToShowEvent(showEvent);
            ShowEvent showEventWithParticipantsAndAnimals = AddAnimalsToShowEventParticipants (showEventWithParticipants);
        }
    }

    private ShowEvent AddParticipantsToShowEvent(ShowEvent showEvent) {

        Set<Participant> participants = new HashSet<>();

        for (ShowEventParticipantAnimal crossTable : context.showEventParticipantAnimalRepo.getAll()) {
            if (showEvent.getId().equals(crossTable.getShowEventId())) {
                // get participants for showEvent
                String participantId = crossTable.getParticipantId();
                Participant participant = context.participantRepo.getById(participantId);
                participants.add(participant);
            }
        }
        showEvent.setParticipants(participants);
        return showEvent;
    }

    private ShowEvent AddAnimalsToShowEventParticipants(ShowEvent showEvent)
    {
        Set<Participant> participants = showEvent.getParticipants();
        for (Participant part : participants) {

            Set<Animal> animals = new HashSet<>();
            for (ShowEventParticipantAnimal crossTable : context.showEventParticipantAnimalRepo.getAll())
            {

                if (showEvent.getId().equals(crossTable.getShowEventId()) && part.getId().equals(crossTable.getParticipantId()))
                {
                    String animalId = crossTable.getAnimalId();
                    Animal animal = context.animalRepo.getById(animalId);
                    animals.add(animal);
                }
            }
            part.setAnimals(animals);
        }
        showEvent.setParticipants(participants);
        return showEvent;
    }
}


