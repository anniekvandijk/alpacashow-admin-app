package nl.animundo.apps.alpacashowadmin.backend.utilities;

import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;

import java.util.Comparator;

public class ParticipantComparator implements Comparator<Participant> {

    @Override
    public int compare(Participant participant1, Participant participant2) {
        return participant1.getName().compareTo(participant2.getName());
    }
}
