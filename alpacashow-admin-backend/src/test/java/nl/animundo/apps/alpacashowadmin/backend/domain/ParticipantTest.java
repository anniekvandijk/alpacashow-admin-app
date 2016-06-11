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

    /* TODO
    Check unique participant
     */

    @Test
    public void newParticipantWithTrim() {

        String name = " New Participant";

        Participant participant = new Participant(name);

        assertEquals("New Participant", participant.getName());

    }

    @Test
    public void participantNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field participant can not be empty");

        String name = null;

        new Participant(name);
    }

}
