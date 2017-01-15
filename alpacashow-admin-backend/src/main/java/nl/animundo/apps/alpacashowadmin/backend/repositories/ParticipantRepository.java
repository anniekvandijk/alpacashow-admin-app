package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ParticipantRepository {
    private static Logger logger = LoggerFactory.getLogger(ParticipantRepository.class);
    private Map<String, Participant> participants = new HashMap<>();


    public String add(final Participant participant) {

        String participantKey = participant.getName();
        if (getParticipantByKeySet(participantKey) != null) {
            participants.remove(participantKey);
            participants.put(participantKey, participant);
            logger.info("Updated participant '" + participantKey + "' to participantRepo");
        } else {
            participants.put(participantKey, participant);
            logger.info("Added participant '" + participantKey + "' to participantRepo");
        }
        return participantKey;
    }

    public String delete(final String participantKey) {

        Participant participantToDelete = getParticipantByKeySet(participantKey);
        if (participantToDelete != null) {
            participants.remove(participantToDelete.getName());
            logger.info("Deleted participant '" + participantKey + "' from participantRepo");
            return participantToDelete.getName();
        } else {
            return null;
        }
    }

    public Set<String> getAllParticipantsByKeySet() {
        return participants.keySet();
    }

    public Collection<Participant> getAllParticipants() {
        return participants.values();
    }

    public Participant getParticipantByKeySet(final String keySet) {
        return participants.get(keySet);
    }

}
