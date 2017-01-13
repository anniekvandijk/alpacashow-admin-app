package nl.animundo.apps.alpacashowadmin.backend.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ColorClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.SexClass;
import nl.animundo.apps.alpacashowadmin.backend.util.JsonDateDeserializer;
import nl.animundo.apps.alpacashowadmin.backend.util.JsonDateSerializer;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

public class Animal {

    private final String name;
    private final BreedClass breed;
    private final SexClass sex;
    private final ColorClass color;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private final LocalDate dateOfBirth;
    private final String microchip;
    private final String registration;
    private final String sire;
    private final String dam;

    @JsonCreator
    public Animal(@JsonProperty("name") final String name, @JsonProperty("breed") final BreedClass breed,
                  @JsonProperty("sex") final SexClass sex, @JsonProperty("color") final ColorClass color,
                  @JsonProperty("dateOfBirth") final LocalDate dateOfBirth, @JsonProperty("microchip") final String microchip,
                  @JsonProperty("registration") final String registration, @JsonProperty("sire") final String sire, @JsonProperty("dam") final String dam) {

        final String nameCln = StringUtils.trimToNull(name);
        if (nameCln == null) {
            throw new IllegalArgumentException("Field name can not be empty");
        }
        if (breed == null) {
            throw new IllegalArgumentException("Field breed can not be empty");
        }
        if (sex == null) {
            throw new IllegalArgumentException("Field sex can not be empty");
        }
        if (color == null) {
            throw new IllegalArgumentException("Field color can not be empty");
        }
        if (dateOfBirth == null) {
            throw new IllegalArgumentException("Field date of birth can not be empty");
        }
        final String microchipCln = StringUtils.trimToNull(microchip);
        if (microchipCln == null) {
            throw new IllegalArgumentException("Field microchip can not be empty");
        }
        final String registrationCln = StringUtils.trimToNull(registration);
        final String sireCln = StringUtils.trimToNull(sire);
        if (sireCln == null) {
            throw new IllegalArgumentException("Field sire can not be empty");
        }
        final String damCln = StringUtils.trimToNull(dam);
        if (damCln == null) {
            throw new IllegalArgumentException("Field dam can not be empty");
        }

        this.name = nameCln;
        this.breed = breed;
        this.sex = sex;
        this.color = color;
        this.dateOfBirth = dateOfBirth;
        this.microchip = microchipCln;
        this.registration = registrationCln;
        this.sire = sireCln;
        this.dam = damCln;
    }

    public String getName() {
        return name;
    }

    public BreedClass getBreed() {
        return breed;
    }

    public SexClass getSex() {
        return sex;
    }

    public ColorClass getColor() {
        return color;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getMicrochip() {
        return microchip;
    }

    public String getRegistration() {
        return registration;
    }

    public String getSire() {
        return sire;
    }

    public String getDam() {
        return dam;
    }
}
