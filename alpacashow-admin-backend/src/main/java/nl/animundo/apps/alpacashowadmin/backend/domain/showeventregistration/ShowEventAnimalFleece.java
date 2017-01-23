package nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class ShowEventAnimalFleece {
    private static Logger logger = LoggerFactory.getLogger(ShowEventAnimalFleece.class);

    private LocalDate sheerDate;
    private LocalDate beforeSheerDate;

    @JsonCreator
    public ShowEventAnimalFleece(@JsonProperty("sheerDate") final LocalDate sheerDate, @JsonProperty("beforeSheerDate") final LocalDate beforeSheerDate) {
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
