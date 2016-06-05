package nl.animundo.apps.alpacashowadmin.backend.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by Anniek van Dijk on 4-6-2016.
 */
public class AnimalClassCodeService {

    public static int getAnimalClassCode(String breed, String ageClass, String sex, String color) {

        int animalClassCode = 000;

        animalClassCode = Integer.valueOf(AnimalClassCodeService.getBreedCode(breed) + "" +  AnimalClassCodeService.getAgeSexCode(ageClass, sex) + "" + AnimalClassCodeService.getColorCode(color));
        return animalClassCode;
    }

    public static int getBreedCode(String breed) {

        int breedCode;
        switch (breed) {
            case "Huacaya":
                breedCode = 1;
                break;
            case "Suri":
                breedCode = 2;
                break;
            case "Huacaya Fleece":
                breedCode = 3;
                break;
            case "Suri Fleece":
                breedCode = 4;
                break;
            default:
                throw new IllegalArgumentException("Soort onbekend");
        }
        return breedCode;
    }

    public static int getAgeSexCode (String ageClass, String sex) {

        int ageSexCode;

        if ("Female".equals(sex)) {
            switch (ageClass) {
                case "Junior":
                    ageSexCode = 0;
                    break;
                case "Intermediate":
                    ageSexCode = 2;
                    break;
                case "Adult":
                    ageSexCode = 4;
                    break;
                case "Senior":
                    ageSexCode = 6;
                    break;
                case "Mature":
                    ageSexCode = 8;
                    break;
                default:
                    throw new IllegalArgumentException("Leeftijdsklasse kan niet bepaald worden");
            }
        }
        else if ("Male".equals(sex)) {
            switch (ageClass) {
                case "Junior":
                    ageSexCode = 1;
                    break;
                case "Intermediate":
                    ageSexCode = 3;
                    break;
                case "Adult":
                    ageSexCode = 5;
                    break;
                case "Senior":
                    ageSexCode = 7;
                    break;
                case "Mature":
                    ageSexCode = 9;
                    break;
                default:
                    throw new IllegalArgumentException("Leeftijdsklasse kan niet bepaald worden");
            }
        }
        else {
            throw new IllegalArgumentException("Geslacht onbekend");
        }
        return ageSexCode;
    }

    public static int getColorCode(String color) {

        int colorCode;
        switch (color) {
            case "White":
                colorCode = 0;
                break;
            case "Fawn":
                colorCode = 1;
                break;
            case "Brown":
                colorCode = 2;
                break;
            case "Grey":
                colorCode = 3;
                break;
            case "Black":
                colorCode = 4;
                break;
            case "Fancy":
                colorCode = 5;
                break;
            case "Beige":
                colorCode = 6;
                break;
            default:
                throw new IllegalArgumentException("Kleur onbekend");
        }
        return colorCode;
    }

    public static String getAgeClass(int ageInMonths) {

        String ageClass = "";

        if (ageInMonths < 0 ) {
            throw new IllegalArgumentException("Leeftijd onder de 0 maanden. Controleer de geboortedatum.");
        }
        else if (ageInMonths >= 0 & ageInMonths < 6 ) {
            throw new IllegalArgumentException("Dieren onder de 6 maanden mogen niet deelnemen");
        }
        else if (ageInMonths >= 6 & ageInMonths < 12 ) {
            return "Junior";
        }
        else if (ageInMonths >= 12 & ageInMonths < 24 ) {
            return "Intermediate";
        }
        else if (ageInMonths >= 24 & ageInMonths < 48 ) {
            return "Adult";
        }
        else if (ageInMonths >= 48 & ageInMonths < 72) {
            return "Senior";
        }
        else if (ageInMonths >= 72 ) {
            return "Mature";
        }
        return ageClass;
    }

    public static long getAgeInMonths(LocalDate showDate, LocalDate dateOfBirth) {

        return ChronoUnit.MONTHS.between(dateOfBirth, showDate);

    }
}
