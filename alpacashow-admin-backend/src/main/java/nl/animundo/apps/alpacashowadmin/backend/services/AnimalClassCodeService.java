package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static nl.animundo.apps.alpacashowadmin.backend.domain.Animal.breed.*;
import static nl.animundo.apps.alpacashowadmin.backend.domain.Animal.color.*;
import static nl.animundo.apps.alpacashowadmin.backend.services.AnimalClassCodeService.ageClass.*;

/**
 * Created by Anniek van Dijk on 4-6-2016.
 */

public class AnimalClassCodeService {

    public static int getAnimalClassCode(Enum breed, Enum ageClass, Enum sex, Enum color) {

        int animalClassCode;

        animalClassCode = Integer.valueOf(AnimalClassCodeService.getBreedCode(breed) + "" +  AnimalClassCodeService.getAgeSexCode(ageClass, sex) + "" + AnimalClassCodeService.getColorCode(color));
        return animalClassCode;
    }

    public static int getBreedCode(Enum breed) {

        int breedCode;
        if (breed.equals(Animal.breed.HUACAYA)) {
            breedCode = 1;

        } else if (breed.equals(Animal.breed.SURI)) {
            breedCode = 2;

        } else if (breed.equals(Animal.breed.HUACAYAFLEECE)) {
            breedCode = 3;

        } else if (breed.equals(Animal.breed.SURIFLEECE)) {
            breedCode = 4;

        } else {
            throw new IllegalArgumentException("Soort onbekend");
        }
        return breedCode;
    }

    public static int getAgeSexCode (Enum ageClass, Enum sex) {

        int ageSexCode;

        if (sex.equals(Animal.sex.FEMALE)) {
            if (ageClass.equals(AnimalClassCodeService.ageClass.JUNIOR)) {
                ageSexCode = 0;

            } else if (ageClass.equals(AnimalClassCodeService.ageClass.INTERMEDIATE)) {
                ageSexCode = 2;

            } else if (ageClass.equals(AnimalClassCodeService.ageClass.ADULT)) {
                ageSexCode = 4;

            } else if (ageClass.equals(AnimalClassCodeService.ageClass.SENIOR)) {
                ageSexCode = 6;

            } else if (ageClass.equals(AnimalClassCodeService.ageClass.MATURE)) {
                ageSexCode = 8;

            } else {
                throw new IllegalArgumentException("Leeftijdsklasse kan niet bepaald worden");
            }
        }
        else if (sex.equals(Animal.sex.MALE)) {
            if (ageClass.equals(AnimalClassCodeService.ageClass.JUNIOR)) {
                ageSexCode = 1;

            } else if (ageClass.equals(AnimalClassCodeService.ageClass.INTERMEDIATE)) {
                ageSexCode = 3;

            } else if (ageClass.equals(AnimalClassCodeService.ageClass.ADULT)) {
                ageSexCode = 5;

            } else if (ageClass.equals(AnimalClassCodeService.ageClass.SENIOR)) {
                ageSexCode = 7;

            } else if (ageClass.equals(AnimalClassCodeService.ageClass.MATURE)) {
                ageSexCode = 9;

            } else {
                throw new IllegalArgumentException("Leeftijdsklasse kan niet bepaald worden");
            }
        }
        else {
            throw new IllegalArgumentException("Geslacht onbekend");
        }
        return ageSexCode;
    }

    public static int getColorCode(Enum color) {

        int colorCode;
        if (color.equals(Animal.color.WHITE)) {
            colorCode = 0;

        } else if (color.equals(Animal.color.FAWN)) {
            colorCode = 1;

        } else if (color.equals(Animal.color.BROWN)) {
            colorCode = 2;

        } else if (color.equals(Animal.color.GREY)) {
            colorCode = 3;

        } else if (color.equals(Animal.color.BLACK)) {
            colorCode = 4;

        } else if (color.equals(Animal.color.FANCY)) {
            colorCode = 5;

        } else if (color.equals(Animal.color.BEIGE)) {
            colorCode = 6;

        } else {
            throw new IllegalArgumentException("Kleur onbekend");
        }
        return colorCode;
    }

    public static String getAgeClass(int ageInMonths) {

        Enum ageClass = null;

        if (ageInMonths < 0 ) {
            throw new IllegalArgumentException("Leeftijd onder de 0 maanden. Controleer de geboortedatum.");
        }
        else if (ageInMonths >= 0 & ageInMonths < 6 ) {
            throw new IllegalArgumentException("Dieren onder de 6 maanden mogen niet deelnemen");
        }
        else if (ageInMonths >= 6 & ageInMonths < 12 ) {
            ageClass = AnimalClassCodeService.ageClass.JUNIOR;
        }
        else if (ageInMonths >= 12 & ageInMonths < 24 ) {
            ageClass = AnimalClassCodeService.ageClass.INTERMEDIATE;
        }
        else if (ageInMonths >= 24 & ageInMonths < 48 ) {
            ageClass = AnimalClassCodeService.ageClass.ADULT;
        }
        else if (ageInMonths >= 48 & ageInMonths < 72) {
            ageClass = AnimalClassCodeService.ageClass.SENIOR;
        }
        else if (ageInMonths >= 72 ) {
            ageClass = AnimalClassCodeService.ageClass.MATURE;
        }
        return String.valueOf(ageClass);
    }

    public static long getAgeInMonths(LocalDate showDate, LocalDate dateOfBirth) {

        return ChronoUnit.MONTHS.between(dateOfBirth, showDate);

    }

    public enum ageClass {

        JUNIOR,
        INTERMEDIATE,
        ADULT,
        SENIOR,
        MATURE;
    }
}
