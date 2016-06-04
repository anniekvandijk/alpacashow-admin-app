package nl.animundo.apps.alpacashowadmin.backend.services;

/**
 * Created by Anniek van Dijk on 4-6-2016.
 */
public class AnimalClassService {


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
}
