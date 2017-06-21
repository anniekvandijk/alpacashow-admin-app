package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

import static java.util.Comparator.comparing;

public class ParticipantRepository {
    private static Logger logger = LoggerFactory.getLogger(ParticipantRepository.class);
    private Map<String, Participant> participants = new HashMap<>();

    public String add(final Participant participant) {

        String id = UUID.randomUUID().toString();
        participant.setId(id);
            participants.put(id, participant);
            logger.info("Updated participant '" + id + "' to participantRepo");
        return id;
    }

    public String delete(final String id) {

        Participant participantToDelete = getParticipantById(id);
        if (participantToDelete != null) {
            participants.remove(id);
            logger.info("Deleted participant '" + id + "' from participantRepo");
            return participantToDelete.getName();
        } else {
            return null;
        }
    }

    public void deleteAll () {
            participants.clear();
    }

    public Set<String> getAllParticipantsById() {
        return participants.keySet();
    }

    public Collection<Participant> getAllParticipants() {
        return participants.values();
    }

    public List<Participant> getAllParticipantsSorted() {

        List<Participant> participantList  = new ArrayList<>(participants.values());
        participantList.sort(comparing(Participant::getName));
        participantList.stream();
        return participantList;
    }

    public Participant getParticipantById(final String id) {
        return participants.get(id);
    }

}
