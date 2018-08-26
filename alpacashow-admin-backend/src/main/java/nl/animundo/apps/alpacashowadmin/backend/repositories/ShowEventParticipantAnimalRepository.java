package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.context.RepositoryContext;
import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventParticipantAnimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ShowEventParticipantAnimalRepository {
    private static Logger logger = LoggerFactory.getLogger(ShowEventParticipantAnimalRepository.class);
    private Set<ShowEventParticipantAnimal> showEventParticipantAnimals = new HashSet<>();
    private RepositoryContext context;

    public ShowEventParticipantAnimalRepository (RepositoryContext context)
    {
        this.context = context;
    }

    public ShowEventParticipantAnimal add(final ShowEventParticipantAnimal showEventParticipantAnimal) {

        showEventParticipantAnimals.add(showEventParticipantAnimal);
        logger.info("Added '" + showEventParticipantAnimal.getShowEventId() + "' to repo");
        return showEventParticipantAnimal;
    }

    public Collection<ShowEventParticipantAnimal> getAll() {
        return showEventParticipantAnimals;
    }

    public Set<Participant> getAllParticipantsForShowEvent(String showEventId)
    {
        Set<Participant> participants = new HashSet<>();
        for (ShowEventParticipantAnimal crossRepo : showEventParticipantAnimals)
        {
            if (showEventId.equals(crossRepo.getShowEventId()))
            {
                String participantId = crossRepo.getParticipantId();
                Participant participant = context.participantRepo.getById(participantId);
                participants.add(participant);
            }
        }
        return participants;
    }

    public Set<Animal> getAllAnimalsForShowEvent(String showEventId)
    {
        Set<Animal> animals = new HashSet<>();
        for (ShowEventParticipantAnimal crossRepo : showEventParticipantAnimals) {
            if (showEventId.equals(crossRepo.getShowEventId())) {
                String animalId = crossRepo.getAnimalId();
                Animal animal = context.animalRepo.getById(animalId);
                animals.add(animal);
            }
        }
        return animals;
    }

    public Set<Animal> getAllAnimalsForShowEventParticipant(String showEventId, String participantId)
    {
        Set<Animal> animals = new HashSet<>();
        for (ShowEventParticipantAnimal crossRepo : showEventParticipantAnimals) {
            if (showEventId.equals(crossRepo.getShowEventId()) && participantId.equals(crossRepo.getParticipantId())) {
                String animalId = crossRepo.getAnimalId();
                Animal animal = context.animalRepo.getById(animalId);
                animals.add(animal);
            }
        }
        return animals;
    }

    public void deleteAll () {
        showEventParticipantAnimals.clear();
        logger.info("Deleted all records from Repo");
    }

    public void deleteParticipantFromShowEvent(String showEventId, String participantId)
    {
        // implement me
       // showEventParticipantAnimals.removeIf(showEventParticipantAnimal -> );
    }

    public void deleteAnimalFromShowEvent(String showEventId, String animalId)
    {
        // implement me
    }
}
