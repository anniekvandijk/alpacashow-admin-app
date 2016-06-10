package nl.animundo.apps.alpacashowadmin.backend.domain;

import java.time.LocalDate;

/**
 * Created by Anniek van Dijk on 5-6-2016.
 */
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

        // TODO Required fields

        this.name = name;
        this.breedClass = breedClass;
        this.sexClass = sexClass;
        this.colorClass = colorClass;
        this.dateOfBirth = dateOfBirth;
        this.microchip = microchip;
        this.registration = registration;
        this.sire = sire;
        this.dam = dam;
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
