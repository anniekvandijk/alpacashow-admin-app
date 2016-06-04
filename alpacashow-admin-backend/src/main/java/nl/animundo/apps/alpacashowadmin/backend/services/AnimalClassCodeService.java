package nl.animundo.apps.alpacashowadmin.backend.services;

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

        int breedCode = -1;
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
                //error
        }
        return breedCode;
    }

    public static int getAgeSexCode (String ageClass, String sex) {

    // Niet geimplementeerd:
    //    AFST FLEECE	40
    //    AFST FEMALE	90
    //    AFST MALE	91
    //    GELDER	95

        int ageSexCode = -1;

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
                    //error
            }
        }
        else if ("Male".equals(sex)) {
            switch (ageClass) {
                case "Junior":
                    ageSexCode = 1;
                    break;
                case "Intermedeiate":
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
                    // error
            }
        }
        else {
            // error
        }
        return ageSexCode;
    }

    public static int getColorCode(String color) {

        int colorCode = -1;
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
                //error
        }
        return colorCode;
    }

}
