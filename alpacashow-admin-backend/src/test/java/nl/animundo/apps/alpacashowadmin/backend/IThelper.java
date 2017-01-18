package nl.animundo.apps.alpacashowadmin.backend;

import nl.animundo.apps.alpacashowadmin.backend.Utilities.AnimalComparator;
import nl.animundo.apps.alpacashowadmin.backend.Utilities.ParticipantComparator;
import nl.animundo.apps.alpacashowadmin.backend.Utilities.ShowEventComparator;
import nl.animundo.apps.alpacashowadmin.backend.domain.*;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.*;
import nl.animundo.apps.alpacashowadmin.backend.repositories.*;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class IThelper {

    private ApplicationRepositoryService service = new ApplicationRepositoryService();
    private ShowEventRepository showEventRepository;
    private ParticipantRepository participantRepository;
    private AnimalRepository animalRepository;
    private ShowEventParticipantRepository showEventParticipantRepository;
    private ShowEventRegistrationRepository showEventRegistrationRepository;

    public void AddCompleteShowEvent () throws IOException {

        showEventRepository = service.loadShowEventRepository();
        participantRepository = service.loadParticipantRepository();
        animalRepository = service.loadAnimalRepository();
        showEventParticipantRepository = service.loadShowEventParticipantRepository();
        showEventRegistrationRepository = service.loadShowEventRegistrationRepository();
        showEventRepository.deleteAll();
        participantRepository.deleteAll();
        animalRepository.deleteAll();
        showEventParticipantRepository.deleteAll();
        showEventRegistrationRepository.deleteAll();

        String name1 = "ShowEvent met deelnemers";
        LocalDate date1 = LocalDate.of(2030, 4, 1);
        LocalDate closeDate1 = LocalDate.of(2030, 3, 1);
        String location1 = "Breda";
        String judge1 = " Shirley Bettinson";
        ShowType showType1 = ShowType.MALE_PROGENY_SHOW;

        SortedSet<Participant> participants1 = new TreeSet<>(new ParticipantComparator());
        participants1.add(new Participant("Deelnemer 1", "Alpacafarm 1", "farmnaam@iets.nl", "050-1234567", "thuis 3a", "1111 BB", "Surhuisterveen", "Nederland"));
        participants1.add(new Participant("Deelnemer 2", "Alpacafarmpje 2", "farmnaam@iets.eu", "038-1234567", "thuis 100", "9876 ZZ", "Grun", "Nederland"));


        ShowEvent showEvent1 = new ShowEvent(name1, date1, closeDate1, location1, judge1, showType1, participants1);

        String name2 = "Fleeceshow ShowEvent met deelnemers en dieren";
        LocalDate date2 = LocalDate.of(2030, 6, 15);
        LocalDate closeDate2 = LocalDate.of(2030, 4, 15);
        String location2 = "Surhuisterveen";
        String judge2 = " Test Judge ";
        ShowType showType2 = ShowType.FLEECESHOW;

        SortedSet<Animal> animals1 = new TreeSet<>(new AnimalComparator());

        AnimalShowDetail animalShowDetail1 = new AnimalShowDetail(LocalDate.of(2016, 5, 1), null);
        AnimalShowDetail animalShowDetail2 = new AnimalShowDetail(LocalDate.of(2016, 4, 1), LocalDate.of(2015, 5, 1));
        animals1.add(new Animal("Alpaca1", BreedClass.HUACAYA, SexClass.FEMALE, ColorClass.BLACK, LocalDate.of(2015, 4, 12), "8765", null, "Vader", "Moeder", animalShowDetail1));
        animals1.add(new Animal("Alpaca2", BreedClass.SURI, SexClass.MALE, ColorClass.FANCY, LocalDate.of(2014, 4, 29), "4321", "BAF12345", "Vader2", "Moeder2", animalShowDetail2));

        SortedSet<Animal> animals2 = new TreeSet<>(new AnimalComparator());
        AnimalShowDetail animalShowDetail3 = new AnimalShowDetail(LocalDate.of(2016, 5, 1), null);
        AnimalShowDetail animalShowDetail4 = new AnimalShowDetail(LocalDate.of(2016, 5, 1), null);
        animals2.add(new Animal("Alpaca3", BreedClass.HUACAYA, SexClass.FEMALE, ColorClass.BLACK, LocalDate.of(2015, 4, 13), "4444", null, "Vader", "Moeder", animalShowDetail3));
        animals2.add(new Animal("Alpaca4", BreedClass.SURI, SexClass.MALE, ColorClass.FANCY, LocalDate.of(2016, 7, 6), "5555", "BAF12346", "Vader2", "Moeder2", animalShowDetail4));


        SortedSet<Participant> participants2 = new TreeSet<>(new ParticipantComparator());
        participants2.add(new Participant("Test participant 1", "Testfarm 1", "", "", "", "", "", "", animals1));
        participants2.add(new Participant("Test participant 2", "Testfarm 2", "", "", "", "", "", "", animals2));

        ShowEvent showEvent2 = new ShowEvent(name2, date2, closeDate2, location2, judge2, showType2, participants2);

        String name3 = "ShowEvent zonder deelnemers";
        LocalDate date3 = LocalDate.of(2030, 3, 15);
        LocalDate closeDate3 = LocalDate.of(2030, 1, 1);
        String location3 = "Breda";
        String judge3 = " Shirley Bettinson";
        ShowType showType3 = ShowType.FEMALE_PROGENY_SHOW;

        ShowEvent showEvent3 = new ShowEvent(name3, date3, closeDate3, location3, judge3, showType3);

        String name4 = "Haltershow ShowEvent met deelnemers en dieren";
        LocalDate date4 = LocalDate.of(2030, 8, 15);
        LocalDate closeDate4 = LocalDate.of(2030, 7, 15);
        String location4 = "Surhuisterveen";
        String judge4 = " Test Judge ";
        ShowType showType4 = ShowType.HALTERSHOW;

        SortedSet<Animal> animals3 = new TreeSet<>(new AnimalComparator());
        AnimalShowDetail animalShowDetail5 = new AnimalShowDetail(LocalDate.of(2016, 4, 1), LocalDate.of(2015, 5, 1));
        animals3.add(new Animal("Alpaca1", BreedClass.HUACAYA, SexClass.FEMALE, ColorClass.BLACK, LocalDate.of(2015, 4, 12), "8765", null, "Vader", "Moeder"));
        animals3.add(new Animal("Alpaca2", BreedClass.SURI, SexClass.MALE, ColorClass.FANCY, LocalDate.of(2014, 4, 29), "4321", "BAF12345", "Vader2", "Moeder2", animalShowDetail5));

        SortedSet<Participant> participants3 = new TreeSet<>(new ParticipantComparator());
        participants3.add(new Participant("Test participant 1", "Testfarm 1", "", "", "", "", "", "", animals3));
        participants3.add(new Participant("Test participant 2", "Testfarm 2", "", "", "", "", "", ""));

        ShowEvent showEvent4 = new ShowEvent(name4, date4, closeDate4, location4, judge4, showType4, participants3);

        SortedSet<ShowEvent> set = new TreeSet<>(new ShowEventComparator());
        set.add(showEvent1);
        set.add(showEvent2);
        set.add(showEvent3);
        set.add(showEvent4);

        for (ShowEvent showEvent : set) {
            String showEventKey = showEventRepository.add(showEvent);
        }

        service.saveShowEventRepository();
        service.saveParticipantRepository();
        service.saveAnimalRepository();
    }
}
