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

        String name = "Test showEvent met registraties";
        LocalDate date = LocalDate.of(2017, 6, 15);
        LocalDate closeDate = LocalDate.of(2017, 4, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        ShowType showType = ShowType.HALTERSHOW;

        Set<Animal> animals1 = new HashSet<>();
        animals1.add(new Animal("Alpaca1", BreedClass.HUACAYA, SexClass.FEMALE, ColorClass.BLACK, LocalDate.now().minusYears(1), "8765", null, "Vader", "Moeder", LocalDate.now().minusMonths(2)));
        animals1.add(new Animal("Alpaca2", BreedClass.SURI, SexClass.MALE, ColorClass.FANCY, LocalDate.now().minusYears(2), "4321", "BAF12345", "Vader2", "Moeder2"));

        Set<Animal> animals2 = new HashSet<>();
        animals2.add(new Animal("Alpaca3", BreedClass.HUACAYA, SexClass.FEMALE, ColorClass.BLACK, LocalDate.now().minusYears(1), "4444", null, "Vader", "Moeder", LocalDate.now().minusMonths(2)));
        animals2.add(new Animal("Alpaca4", BreedClass.SURI, SexClass.MALE, ColorClass.FANCY, LocalDate.now().minusYears(2), "5555", "BAF12345", "Vader2", "Moeder2"));


        Set<Participant> participants = new HashSet<>();
        participants.add(new Participant("Test participant 1", "Testfarm 1", "", "", "", "", "", "", animals1));
        participants.add(new Participant("Test participant 2", "Testfarm 2", "", "", "", "", "", "", animals2));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType, participants);

        showEventRepository.delete("2017-06-15_HALTERSHOW");
        String showEventKey = showEventRepository.add(showEvent);
        for (Participant participant : showEvent.getParticipants())
        {
            String participantKey = participantRepository.add(participant);
            for (Animal animal : participant.getAnimals()) {
                String animalKey = animalRepository.add(animal);

                LocalDate sheerOrBirthDate;
                if (showEvent.getShowType().toString().equals("FLEECESHOW")) {
                    sheerOrBirthDate = animal.getSheerDate();
                }
                else {
                    sheerOrBirthDate = animal.getDateOfBirth();
                }
                AgeClass ageClass = AgeClassService.getAgeClass(showEvent.getDate(), sheerOrBirthDate);
                int showClass = ShowClassService.getShowClassCode(animal.getBreed(), animal.getSex(), animal.getColor(), showEvent.getDate(), sheerOrBirthDate);

                ShowEventRegistration registration = new ShowEventRegistration(showEventKey,participantKey,animalKey, ageClass,showClass,animal.getSheerDate(),animal.getBeforeSheerDate());
                showEventRegistrationRepository.add(registration);
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
