package nl.animundo.apps.alpacashowadmin.backend.context;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventParticipantAnimal;
import nl.animundo.apps.alpacashowadmin.backend.repositories.*;

public class RepositoryContext {

    public Repository<ShowEvent> showEventRepo;
    public Repository<Participant> participantRepo;
    public Repository<Animal> animalRepo;
    public ShowEventParticipantAnimalRepository showEventParticipantAnimalRepo;
    public ShowEventAnimalDetailRepository showEventAnimalDetailRepository;
    public FleeceWeightPointsRepository fleeceWeightPointsRepository;

}