package nl.animundo.apps.alpacashowadmin.backend.context;

import nl.animundo.apps.alpacashowadmin.backend.repositories.*;

public class RepositoryContext {

    public RepositoryContext ()
    {
        showEventRepository = new ShowEventRepository();
        participantRepository = new ParticipantRepository();
        animalRepository = new AnimalRepository();
        showEventParticipantRepository = new ShowEventParticipantRepository();
        showEventAnimalDetailRepository = new ShowEventAnimalDetailRepository();
        fleeceWeightPointsRepository = new FleeceWeightPointsRepository();
    }

    public ShowEventRepository showEventRepository;
    public ParticipantRepository participantRepository;
    public AnimalRepository animalRepository;
    public ShowEventParticipantRepository showEventParticipantRepository;
    public ShowEventAnimalDetailRepository showEventAnimalDetailRepository;
    public FleeceWeightPointsRepository fleeceWeightPointsRepository;

}