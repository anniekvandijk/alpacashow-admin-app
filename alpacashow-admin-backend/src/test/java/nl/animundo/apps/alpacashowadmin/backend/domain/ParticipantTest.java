package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Anniek van Dijk on 10-6-2016.
 */
public class ParticipantTest {

    @Test
    public void newParticipant() {

        String name = "New Participant";

        Participant participant = new Participant(name);

        assertEquals("New Participant", participant.getName());

    }
}
