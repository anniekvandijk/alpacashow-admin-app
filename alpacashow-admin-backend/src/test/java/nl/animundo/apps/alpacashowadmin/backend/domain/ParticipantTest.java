package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


/**
 * Created by Anniek van Dijk on 10-6-2016.
 */
public class ParticipantTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void newParticipant() {

        String name = "New Participant";

        Participant participant = new Participant(name);

        assertEquals("New Participant", participant.getName());

    }


}
