package nl.animundo.apps.alpacashowadmin.backend.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.animundo.apps.alpacashowadmin.backend.deserializers.*;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ColorClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.SexClass;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

public class Animal {

    private final String name;
    @JsonDeserialize(using = JsonBreedClassDeserializer.class)
    @JsonSerialize(using = JsonBreedClassSerializer.class)
    private final BreedClass breed;
    @JsonDeserialize(using = JsonSexClassDeserializer.class)
    @JsonSerialize(using = JsonSexClassSerializer.class)
    private final SexClass sex;
    @JsonDeserialize(using = JsonColorClassDeserializer.class)
    @JsonSerialize(using = JsonColorClassSerializer.class)
    private final ColorClass color;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private final LocalDate dateOfBirth;
    private final String microchip;
    private final String registration;
    private final String sire;
    private final String dam;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private final LocalDate sheerDate;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private final LocalDate beforeSheerDate;

    public Animal (final String name, final BreedClass breed, final SexClass sex, final ColorClass color, final LocalDate dateOfBirth,
                   final String microchip, final String registration, final String sire, final String dam)
    {
        this(name, breed, sex, color, dateOfBirth, microchip, registration, sire, dam, null, null);
    }

    @JsonCreator
    public Animal(@JsonProperty("name") final String name, @JsonProperty("breed") final BreedClass breed,
                  @JsonProperty("sex") final SexClass sex, @JsonProperty("color") final ColorClass color,
                  @JsonProperty("dateOfBirth") final LocalDate dateOfBirth, @JsonProperty("microchip") final String microchip,
                  @JsonProperty("registration") final String registration, @JsonProperty("sire") final String sire,
                  @JsonProperty("dam") final String dam, @JsonProperty("sheerDate") final LocalDate sheerDate, @JsonProperty("beforeSheerDate") final LocalDate beforeSheerDate) {

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
        if (sheerDate != null)
        {
            if (sheerDate.isEqual(LocalDate.now()) || sheerDate.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Sheerdate is today or later");
            }
        }
        if (beforeSheerDate != null)
        {
            if (beforeSheerDate.isEqual(LocalDate.now()) || beforeSheerDate.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Before sheerdate is today or later");
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
        // TODO: more validation on sheerdate
        // sheerdate is before birth
        // sheerdate and birth do not match
        // beforesheerdate and birth do not match
        // If Fleeceshow, sheerdate must be filled

        this.name = nameCln;
        this.breed = breed;
        this.sex = sex;
        this.color = color;
        this.dateOfBirth = dateOfBirth;
        this.microchip = microchipCln;
        this.registration = registrationCln;
        this.sire = sireCln;
        this.dam = damCln;
        this.sheerDate = sheerDate;
        this.beforeSheerDate = beforeSheerDate;
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

    public LocalDate getSheerDate() {
        return sheerDate;
    }

    public LocalDate getBeforeSheerDate() {
        return beforeSheerDate;
    }
}
