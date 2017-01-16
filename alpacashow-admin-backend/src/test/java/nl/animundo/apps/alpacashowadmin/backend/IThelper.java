package nl.animundo.apps.alpacashowadmin.backend;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventRegistration;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.*;
import nl.animundo.apps.alpacashowadmin.backend.repositories.AnimalRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ParticipantRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRegistrationRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import nl.animundo.apps.alpacashowadmin.backend.services.AgeClassService;
import nl.animundo.apps.alpacashowadmin.backend.services.ShowClassService;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class IThelper {

    private ApplicationRepositoryService service = new ApplicationRepositoryService();
    private ShowEventRepository showEventRepository;
    private ParticipantRepository participantRepository;
    private AnimalRepository animalRepository;
    private ShowEventRegistrationRepository showEventRegistrationRepository;

    public void AddCompleteShowEvent () throws IOException {

        showEventRepository = service.loadShowEventRepository();
        participantRepository = service.loadParticipantRepository();
        animalRepository = service.loadAnimalRepository();
        showEventRegistrationRepository = service.loadShowEventRegistrationRepository();
        showEventRepository.deleteAll();
        participantRepository.deleteAll();
        animalRepository.deleteAll();
        showEventRegistrationRepository.deleteAll();

        String name1 = "Breda 2017";
        LocalDate date1 = LocalDate.of(2017, 4, 1);
        LocalDate closeDate1 = LocalDate.of(2017, 3, 1);
        String location1 = "Breda";
        String judge1 = " Shirley Bettinson";
        ShowType showType1 = ShowType.MALE_PROGENY_SHOW;

        Set<Participant> participants1 = new HashSet<>();
        participants1.add(new Participant("Deelnemer 1", "Alpacafarm 1", "farmnaam@iets.nl", "050-1234567", "thuis 3a", "1111 BB", "Surhuisterveen", "Nederland"));
        participants1.add(new Participant("Deelnemer 2", "Alpacafarmpje 2", "farmnaam@iets.eu", "038-1234567", "thuis 100", "9876 ZZ", "Grun", "Nederland"));


        ShowEvent showEvent1 = new ShowEvent(name1, date1, closeDate1, location1, judge1, showType1, participants1);

        String name2 = "Test showEvent met registraties";
        LocalDate date2 = LocalDate.of(2017, 6, 15);
        LocalDate closeDate2 = LocalDate.of(2017, 4, 15);
        String location2 = "Surhuisterveen";
        String judge2 = " Test Judge ";
        ShowType showType2 = ShowType.HALTERSHOW;

        Set<Animal> animals1 = new HashSet<>();
        animals1.add(new Animal("Alpaca1", BreedClass.HUACAYA, SexClass.FEMALE, ColorClass.BLACK, LocalDate.of(2015, 4, 12), "8765", null, "Vader", "Moeder", LocalDate.of(2016, 5, 1)));
        animals1.add(new Animal("Alpaca2", BreedClass.SURI, SexClass.MALE, ColorClass.FANCY, LocalDate.of(2014, 4, 29), "4321", "BAF12345", "Vader2", "Moeder2", LocalDate.of(2016, 4, 1), LocalDate.of(2015, 5, 1)));

        Set<Animal> animals2 = new HashSet<>();
        animals2.add(new Animal("Alpaca3", BreedClass.HUACAYA, SexClass.FEMALE, ColorClass.BLACK, LocalDate.of(2015, 4, 12), "4444", null, "Vader", "Moeder", LocalDate.of(2016, 5, 1)));
        animals2.add(new Animal("Alpaca4", BreedClass.SURI, SexClass.MALE, ColorClass.FANCY, LocalDate.of(2016, 7, 5), "5555", "BAF12346", "Vader2", "Moeder2"));


        Set<Participant> participants2 = new HashSet<>();
        participants2.add(new Participant("Test participant 1", "Testfarm 1", "", "", "", "", "", "", animals1));
        participants2.add(new Participant("Test participant 2", "Testfarm 2", "", "", "", "", "", "", animals2));

        ShowEvent showEvent2 = new ShowEvent(name2, date2, closeDate2, location2, judge2, showType2, participants2);

        showEventRepository.delete("2017-04-01_MALE_PROGENY_SHOW");
        showEventRepository.delete("2017-06-15_HALTERSHOW");

        showEventRepository.add(showEvent1);
        showEventRepository.add(showEvent2);

        for (String showEventKey : showEventRepository.getAllShowEventsByKeySet()) {

            ShowEvent showEvent = showEventRepository.getShowEventByKeySet(showEventKey);

            for (Participant participant : showEvent.getParticipants()) {
                String participantKey = participantRepository.add(participant);
                for (Animal animal : participant.getAnimals()) {
                    String animalKey = animalRepository.add(animal);

                    LocalDate sheerOrBirthDate;
                    if (showEvent.getShowType().toString().equals("FLEECESHOW")) {
                        sheerOrBirthDate = animal.getSheerDate();
                    } else {
                        sheerOrBirthDate = animal.getDateOfBirth();
                    }
                    AgeClass ageClass = AgeClassService.getAgeClass(showEvent.getDate(), sheerOrBirthDate);
                    int showClass = ShowClassService.getShowClassCode(animal.getBreed(), animal.getSex(), animal.getColor(), showEvent.getDate(), sheerOrBirthDate);

                    ShowEventRegistration registration = new ShowEventRegistration(showEventKey, participantKey, animalKey, ageClass, showClass, animal.getSheerDate(), animal.getBeforeSheerDate());
                    showEventRegistrationRepository.add(registration);
                }
            }
        }

        service.saveShowEventRepository();
        service.saveParticipantRepository();
        service.saveAnimalRepository();
        service.saveShowEventRegistrationRepository();
    }

    public void DeleteCompleteShowEvent () throws IOException {

        showEventRepository = service.loadShowEventRepository();
        participantRepository = service.loadParticipantRepository();
        animalRepository = service.loadAnimalRepository();
        showEventRegistrationRepository = service.loadShowEventRegistrationRepository();

        showEventRepository.deleteAll();
        participantRepository.deleteAll();
        animalRepository.deleteAll();
        showEventRegistrationRepository.deleteAll();

        service.saveShowEventRepository();
        service.saveParticipantRepository();
        service.saveAnimalRepository();
        service.saveShowEventRegistrationRepository();
    }
}
