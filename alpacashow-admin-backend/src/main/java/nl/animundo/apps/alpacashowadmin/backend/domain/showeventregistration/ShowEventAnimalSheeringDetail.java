package nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.utilities.JsonDateDeserializer;
import nl.animundo.apps.alpacashowadmin.backend.utilities.JsonDateSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class ShowEventAnimalSheeringDetail {
    private static Logger logger = LoggerFactory.getLogger(ShowEventAnimalSheeringDetail.class);

    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDate sheerDate;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDate beforeSheerDate;

    @JsonCreator
    public ShowEventAnimalSheeringDetail(@JsonProperty("sheerDate") final LocalDate sheerDate, @JsonProperty("beforeSheerDate") final LocalDate beforeSheerDate) {
        if (beforeSheerDate != null && sheerDate == null) {
            throw new IllegalArgumentException("Sheerdate has to be filled when you also have a before sheerdate");
        }
        if (sheerDate != null) {
            if (sheerDate.isEqual(LocalDate.now()) || sheerDate.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Sheerdate is today or later");
            }
        }
        if (sheerDate != null && beforeSheerDate != null) {
            if (beforeSheerDate.isEqual(sheerDate)) {
                throw new IllegalArgumentException("Sheerdate and before sheerdate can not be the same");
            }
            if (beforeSheerDate.isAfter(sheerDate)) {
                throw new IllegalArgumentException("Before sheerdate is after sheerdate");
            }
        }
        this.sheerDate = sheerDate;
        this.beforeSheerDate = beforeSheerDate;
    }

    public LocalDate getSheerDate() {
        return sheerDate;
    }

    public LocalDate getBeforeSheerDate() {
        return beforeSheerDate;
    }

}
