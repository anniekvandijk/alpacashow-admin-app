package nl.animundo.apps.alpacashowadmin.backend.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;

public class AnimalFleeceShowFleeceWeight {
    private static Logger logger = LoggerFactory.getLogger(ShowEventAnimal.class);

    private String showEventKey;
    private int startNumber;
    private float fleeceWeight;

    public AnimalFleeceShowFleeceWeight(final String showEventKey,final int startNumber) {
        this (showEventKey, startNumber, 0.0f);
    }

    @JsonCreator
    public AnimalFleeceShowFleeceWeight(@JsonProperty("showEventKey") final String showEventKey,
          @JsonProperty("startNumber") final int startNumber, @JsonProperty("fleeceWeight") final float fleeceWeight) {
        this.showEventKey = showEventKey;
        this.startNumber = startNumber;
        this.fleeceWeight = fleeceWeight;
    }

    public String getShowEventKey() {
        return showEventKey;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public float getFleeceWeight() {
        return fleeceWeight;
    }
}
