package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShowEventParticipant {
    private static Logger logger = LoggerFactory.getLogger(ShowEventParticipant.class);

    private String showEventKey;
    private String participantKey;

    public ShowEventParticipant(final String showEventKey, final String participantKey)
    {
        if (showEventKey == null || showEventKey.isEmpty()) {
            throw new IllegalArgumentException("ShowEventKey can not be empty");
        }
        if (participantKey == null || participantKey.isEmpty()) {
            throw new IllegalArgumentException("ParticipantKey can not be empty");
        }
        this.showEventKey = showEventKey;
        this.participantKey = participantKey;
    }

    public String getShowEventKey() {
        return showEventKey;
    }

    public String getParticipantKey() {
        return participantKey;
    }
}
