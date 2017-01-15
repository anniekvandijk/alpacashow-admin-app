package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.*;

public class ShowClassService {

    private ShowClassService() throws InstantiationException {
        throw new InstantiationException("Instances of this type are forbidden!");
    }

    public static int getShowClassCode(int breedCode, int ageSexCode, int colorCode) {

        int showClassCode;

        showClassCode = Integer.valueOf(breedCode + "" + ageSexCode + "" + colorCode);
        return showClassCode;
    }

    public static String getShowClassName(BreedClass breed, AgeClass ageClass, SexClass sex, ColorClass color)
    {
        String breedToString = breed.toString();
        String breedName = breedToString.substring(0, 1).toUpperCase() + breedToString.substring(1).toLowerCase();

        String ageClassToString = ageClass.toString();
        String ageName = ageClassToString.substring(0, 1).toUpperCase() + ageClassToString.substring(1).toLowerCase();

        String sexToString = sex.toString();
        String sexName = sexToString.substring(0, 1).toUpperCase() + sexToString.substring(1).toLowerCase();

        String colorToString = color.toString();
        String colorName = colorToString.substring(0, 1).toUpperCase() + colorToString.substring(1).toLowerCase();

        return breedName + " " + ageName + " " + sexName + " " + colorName;
    }
}

