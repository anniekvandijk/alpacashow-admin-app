package nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShowEventParticipantAnimal {
    private static Logger logger = LoggerFactory.getLogger(ShowEventParticipantAnimal.class);

    private String showEventKey;
    private String participantKey;
    private String animalKey;

    public ShowEventParticipantAnimal(final String showEventKey, final String participantKey, final String animalKey)
    {
        if (showEventKey == null || showEventKey.isEmpty()) {
            throw new IllegalArgumentException("ShowEventKey can not be empty");
        }
        if (participantKey == null || participantKey.isEmpty()) {
            throw new IllegalArgumentException("ParticipantKey can not be empty");
        }
        if (animalKey == null || animalKey.isEmpty()) {
            throw new IllegalArgumentException("AnimalKey can not be empty");
        }
        this.showEventKey = showEventKey;
        this.participantKey = participantKey;
        this.animalKey = animalKey;
    }

    public String getShowEventKey() {
        return showEventKey;
    }

    public String getParticipantKey() {
        return participantKey;
    }

    public String getAnimalKey() {
        return animalKey;
    }
}
