package nl.animundo.apps.alpacashowadmin.backend.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventAnimalSheeringDetail;
import nl.animundo.apps.alpacashowadmin.backend.utilities.*;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ColorClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.SexClass;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Animal {

    private String id;
    private String name;
    @JsonDeserialize(using = JsonBreedClassDeserializer.class)
    @JsonSerialize(using = JsonBreedClassSerializer.class)
    private BreedClass breed;
    @JsonDeserialize(using = JsonSexClassDeserializer.class)
    @JsonSerialize(using = JsonSexClassSerializer.class)
    private SexClass sex;
    @JsonDeserialize(using = JsonColorClassDeserializer.class)
    @JsonSerialize(using = JsonColorClassSerializer.class)
    private ColorClass color;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDate dateOfBirth;
    private String microchip;
    private String registration;
    private String sire;
    private String dam;
    private ShowEventAnimalSheeringDetail showEventAnimalSheeringDetail;

    public Animal (final String id, final String name, final BreedClass breed, final SexClass sex, final ColorClass color, final LocalDate dateOfBirth,
                   final String microchip, final String registration, final String sire, final String dam)
    {
        this(id, name, breed, sex, color, dateOfBirth, microchip,
                registration, sire, dam, new ShowEventAnimalSheeringDetail(null, null));
    }

    @JsonCreator
    public Animal(@JsonProperty("id") final String id, @JsonProperty("name") final String name, @JsonProperty("breed") final BreedClass breed,
                  @JsonProperty("sex") final SexClass sex, @JsonProperty("color") final ColorClass color,
                  @JsonProperty("dateOfBirth") final LocalDate dateOfBirth, @JsonProperty("microchip") final String microchip,
                  @JsonProperty("registration") final String registration, @JsonProperty("sire") final String sire,
                  @JsonProperty("dam") final String dam, @JsonProperty("sheeringDetail") ShowEventAnimalSheeringDetail showEventAnimalSheeringDetail) {

        final String idCln = StringUtils.trimToNull(id);
        final String nameCln = StringUtils.trimToNull(name);
        final String microchipCln = StringUtils.trimToNull(microchip);
        final String registrationCln = StringUtils.trimToNull(registration);
        final String sireCln = StringUtils.trimToNull(sire);
        final String damCln = StringUtils.trimToNull(dam);
//        if (idCln == null) {
//            throw new IllegalArgumentException("Field id can not be empty");
//        }

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
        if (microchipCln == null) {
            throw new IllegalArgumentException("Field microchip can not be empty");
        }
        if (sireCln == null) {
            throw new IllegalArgumentException("Field sire can not be empty");
        }
        if (damCln == null) {
            throw new IllegalArgumentException("Field dam can not be empty");
        }

        this.id = idCln;
        this.name = nameCln;
        this.breed = breed;
        this.sex = sex;
        this.color = color;
        this.dateOfBirth = dateOfBirth;
        this.microchip = microchipCln;
        this.registration = registrationCln;
        this.sire = sireCln;
        this.dam = damCln;
        this.showEventAnimalSheeringDetail = showEventAnimalSheeringDetail;
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

    public ShowEventAnimalSheeringDetail getShowEventAnimalSheeringDetail() {
        return showEventAnimalSheeringDetail;
    }

    public void setShowEventAnimalSheeringDetail(ShowEventAnimalSheeringDetail showEventAnimalSheeringDetail) {
        this.showEventAnimalSheeringDetail = showEventAnimalSheeringDetail;
    }
}
