package nl.animundo.apps.alpacashowadmin.backend;

import nl.animundo.apps.alpacashowadmin.backend.context.RepositoryContext;
import nl.animundo.apps.alpacashowadmin.backend.domain.*;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.*;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventAnimalSheeringDetail;
import nl.animundo.apps.alpacashowadmin.backend.repositories.*;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class IThelper {

    private ApplicationRepositoryService service;
    private RepositoryContext context;

    public IThelper (RepositoryContext context, ApplicationRepositoryService service)
    {
        this.context = context;
        this.service = service;
    }

    public void AddCompleteShowEvent () throws IOException {

        context.showEventRepo = service.loadShowEventRepository();
        context.participantRepo = service.loadParticipantRepository();
        context.animalRepo = service.loadAnimalRepository();
        context.showEventRepo.deleteAll();
        context.participantRepo.deleteAll();
        context.animalRepo.deleteAll();

        String id = "2a88e547-d63b-4ec0-8344-7be454701b25";
        String name1 = "ShowEvent met deelnemers";
        LocalDate date1 = LocalDate.of(2017, 4, 1);
        LocalDate closeDate1 = LocalDate.of(2017, 3, 1);
        String location1 = "Breda";
        String judge1 = " Shirley Bettinson";
        ShowType showType1 = ShowType.MALE_PROGENY_SHOW;

        Set<Participant> participants1 = new LinkedHashSet<Participant>();
        participants1.add(new Participant("947e95f8-3506-42b4-818c-cfff3435aa14","Deelnemer 1", "Alpacafarm 1", "farmnaam@iets.nl", "050-1234567", "thuis 3a", "1111 BB", "Surhuisterveen", "Nederland"));
        participants1.add(new Participant("947e95f8-3506-42b4-818c-cfff3435aa15", "Deelnemer 2", "Alpacafarmpje 2", "farmnaam@iets.eu", "038-1234567", "thuis 100", "9876 ZZ", "Grun", "Nederland"));


        ShowEvent showEvent1 = new ShowEvent(id, name1, date1, closeDate1, location1, judge1, showType1, participants1);

        String id2 = "2a88e547-d63b-4ec0-8344-7be454701b26";
        String name2 = "Fleeceshow ShowEvent met deelnemers en dieren";
        LocalDate date2 = LocalDate.of(2017, 6, 15);
        LocalDate closeDate2 = LocalDate.of(2017, 4, 15);
        String location2 = "Surhuisterveen";
        String judge2 = " Test Judge ";
        ShowType showType2 = ShowType.FLEECESHOW;

        Set<Animal> animals1 = new LinkedHashSet<Animal>();

        ShowEventAnimalSheeringDetail showEventAnimalSheeringDetail1 = new ShowEventAnimalSheeringDetail(LocalDate.of(2016, 5, 1), null);
        ShowEventAnimalSheeringDetail showEventAnimalSheeringDetail2 = new ShowEventAnimalSheeringDetail(LocalDate.of(2016, 4, 1), LocalDate.of(2015, 5, 1));
        animals1.add(new Animal("869c1d60-d0f0-4f6a-b4d0-4326a7165b1c", "Alpaca1", BreedClass.HUACAYA, SexClass.FEMALE, ColorClass.BLACK, LocalDate.of(2015, 4, 12), "8765", null, "Vader", "Moeder", showEventAnimalSheeringDetail1));
        animals1.add(new Animal("869c1d60-d0f0-4f6a-b4d0-4326a7165b11", "Alpaca2", BreedClass.SURI, SexClass.MALE, ColorClass.FANCY, LocalDate.of(2014, 4, 29), "4321", "BAF12345", "Vader2", "Moeder2", showEventAnimalSheeringDetail2));

        Set<Animal> animals2 = new LinkedHashSet<Animal>();
        ShowEventAnimalSheeringDetail showEventAnimalSheeringDetail3 = new ShowEventAnimalSheeringDetail(LocalDate.of(2016, 5, 1), null);
        ShowEventAnimalSheeringDetail showEventAnimalSheeringDetail4 = new ShowEventAnimalSheeringDetail(LocalDate.of(2016, 5, 1), null);
        animals2.add(new Animal("869c1d60-d0f0-4f6a-b4d0-4326a7165b12", "Alpaca3", BreedClass.HUACAYA, SexClass.FEMALE, ColorClass.BLACK, LocalDate.of(2015, 4, 13), "4444", null, "Vader", "Moeder", showEventAnimalSheeringDetail3));
        animals2.add(new Animal("869c1d60-d0f0-4f6a-b4d0-4326a7165b13", "Alpaca4", BreedClass.SURI, SexClass.MALE, ColorClass.FANCY, LocalDate.of(2015, 4, 6), "5555", "BAF12346", "Vader2", "Moeder2", showEventAnimalSheeringDetail4));


        Set<Participant> participants2 = new LinkedHashSet<Participant>();
        participants2.add(new Participant("947e95f8-3506-42b4-818c-cfff3435aa16", "Test participant 1", "Testfarm 1", "", "", "", "", "", "", animals1));
        participants2.add(new Participant("947e95f8-3506-42b4-818c-cfff3435aa17", "Test participant 2", "Testfarm 2", "", "", "", "", "", "", animals2));

        ShowEvent showEvent2 = new ShowEvent(id2, name2, date2, closeDate2, location2, judge2, showType2, participants2);

        String id3 = "2a88e547-d63b-4ec0-8344-7be454701b27";
        String name3 = "ShowEvent zonder deelnemers";
        LocalDate date3 = LocalDate.of(2017, 3, 15);
        LocalDate closeDate3 = LocalDate.of(2017, 1, 1);
        String location3 = "Breda";
        String judge3 = " Shirley Bettinson";
        ShowType showType3 = ShowType.FEMALE_PROGENY_SHOW;

        ShowEvent showEvent3 = new ShowEvent(id3, name3, date3, closeDate3, location3, judge3, showType3);

        String id4 = "2a88e547-d63b-4ec0-8344-7be454701b28";
        String name4 = "Haltershow ShowEvent met deelnemers en dieren";
        LocalDate date4 = LocalDate.of(2017, 8, 15);
        LocalDate closeDate4 = LocalDate.of(2017, 7, 15);
        String location4 = "Surhuisterveen";
        String judge4 = " Test Judge ";
        ShowType showType4 = ShowType.HALTERSHOW;

        Set<Animal> animals3 = new LinkedHashSet<Animal>();
        ShowEventAnimalSheeringDetail showEventAnimalSheeringDetail5 = new ShowEventAnimalSheeringDetail(LocalDate.of(2015, 4, 1), LocalDate.of(2014, 5, 1));
        animals3.add(new Animal("869c1d60-d0f0-4f6a-b4d0-4326a7165b12", "Alpaca1", BreedClass.HUACAYA, SexClass.FEMALE, ColorClass.BLACK, LocalDate.of(2015, 4, 12), "8765", null, "Vader", "Moeder"));
        animals3.add(new Animal("869c1d60-d0f0-4f6a-b4d0-4326a7165b15", "Alpaca5", BreedClass.SURI, SexClass.MALE, ColorClass.FANCY, LocalDate.of(2014, 4, 29), "7659", "BAF1254", "Vader2", "Moeder2", showEventAnimalSheeringDetail5));

        Set<Participant> participants3 = new LinkedHashSet<Participant>();
        participants3.add(new Participant("947e95f8-3506-42b4-818c-cfff3435aa16", "Test participant 1", "Testfarm 1", "", "", "", "", "", "", animals3));
        participants3.add(new Participant("947e95f8-3506-42b4-818c-cfff3435aa19","Test participant 3", "Testfarm 3", "", "", "", "", "", ""));

        ShowEvent showEvent4 = new ShowEvent(id4, name4, date4, closeDate4, location4, judge4, showType4, participants3);

        Set<ShowEvent> set = new LinkedHashSet<ShowEvent>();
        set.add(showEvent1);
        set.add(showEvent2);
        set.add(showEvent3);
        set.add(showEvent4);

        for (ShowEvent showEvent : set) {
            context.showEventRepo.add(showEvent.getId(), showEvent);
        }
    }
}
