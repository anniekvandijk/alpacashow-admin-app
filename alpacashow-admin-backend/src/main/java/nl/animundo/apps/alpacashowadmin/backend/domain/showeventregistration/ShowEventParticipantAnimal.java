package nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShowEventParticipantAnimal {
    private static Logger logger = LoggerFactory.getLogger(ShowEventParticipantAnimal.class);

    private String id;
    private String showEventid;
    private String participantid;
    private String animalId;

    public ShowEventParticipantAnimal(final String id, final String showEventid, final String participantId)
    {
        this(id, showEventid, participantId, null);
    }

    public ShowEventParticipantAnimal(final String id, final String showEventid, final String participantId, final String animalId)
    {
        final String idCln = StringUtils.trimToNull(id);
        final String showEventidCln = StringUtils.trimToNull(showEventid);
        final String participantIdCln = StringUtils.trimToNull(participantId);
        final String animalIdCln = StringUtils.trimToNull(animalId);
        //        if (idCln == null) {
//            throw new IllegalArgumentException("Field id can not be empty");
//        }
        if (showEventidCln == null) {
            throw new IllegalArgumentException("ShowEventId can not be empty");
        }
        if (participantIdCln == null) {
            throw new IllegalArgumentException("ParticipantId can not be empty");
        }
        this.id = idCln;
        this.showEventid = showEventidCln;
        this.participantid = participantIdCln;
        this.animalId = animalIdCln;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        final String idCln = StringUtils.trimToNull(id);
        if (idCln == null) {
            throw new IllegalArgumentException("Field id can not be empty");
        }
        this.id = idCln;
    }

    public String getShowEventId() {
        return showEventid;
    }

    public String getParticipantId() {
        return participantid;
    }

    public String getAnimalId() { return animalId; }

    public void setAnimalId(String animalId) {
        final String animalIdCln = StringUtils.trimToNull(animalId);
        this.animalId = animalIdCln;
    }
}
