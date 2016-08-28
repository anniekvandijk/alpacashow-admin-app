package nl.animundo.apps.alpacashowadmin.backend.domain;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ColorClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.SexClass;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

public class Animal {


    private final String name;
    private final BreedClass breedClass;
    private final SexClass sexClass;
    private final ColorClass colorClass;
    private final LocalDate dateOfBirth;
    private final String microchip;
    private final String registration;
    private final String sire;
    private final String dam;

    public Animal(final String name, final BreedClass breedClass, final SexClass sexClass, final ColorClass colorClass,
                  final LocalDate dateOfBirth, final String microchip, final String registration, final String sire, final String dam) {

        final String nameCln = StringUtils.trimToNull(name);
        if (nameCln == null) {
            throw new IllegalArgumentException("Field name can not be empty");
        }
        if (breedClass == null) {
            throw new IllegalArgumentException("Field breed can not be empty");
        }
        if (sexClass == null) {
            throw new IllegalArgumentException("Field sex can not be empty");
        }
        if (colorClass == null) {
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
        this.breedClass = breedClass;
        this.sexClass = sexClass;
        this.colorClass = colorClass;
        this.dateOfBirth = dateOfBirth;
        this.microchip = microchipCln;
        this.registration = registrationCln;
        this.sire = sireCln;
        this.dam = damCln;
    }

    public String getName() {
        return name;
    }

    public BreedClass getBreedClass() {
        return breedClass;
    }

    public SexClass getSexClass() {
        return sexClass;
    }

    public ColorClass getColorClass() {
        return colorClass;
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
