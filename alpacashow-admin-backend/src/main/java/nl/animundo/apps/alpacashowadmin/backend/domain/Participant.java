package nl.animundo.apps.alpacashowadmin.backend.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashSet;
import java.util.Set;

public class Participant {
    private static Logger logger = LoggerFactory.getLogger(Participant.class);

    private String name;
    private Set<Animal> animals;

    public Participant(final String name) {
        this(name, new HashSet<Animal>());
    }

    @JsonCreator
    public Participant(@JsonProperty("name") final String name, @JsonProperty("animals") final Set<Animal> animals) {

        final String nameCln = StringUtils.trimToNull(name);
        if (nameCln == null) {
            throw new IllegalArgumentException("Field participant can not be empty");
        }
        logger.info("\n Participant: " + name + "\n Animal(s): " + animals);
        this.name = nameCln;
        this.animals = animals;
    }

    public String getName() {
        return name;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }



}
