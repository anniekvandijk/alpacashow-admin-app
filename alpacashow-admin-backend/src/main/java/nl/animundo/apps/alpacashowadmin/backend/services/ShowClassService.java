package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.*;

import java.time.LocalDate;

public class ShowClassService {

    private ShowClassService() throws InstantiationException {
        throw new InstantiationException("Instances of this type are forbidden!");
    }

    public static int getShowClassCode(BreedClass breed, AgeClass ageClass, SexClass sex, ColorClass color) {

        String ageSex = ageClass + "_" + sex;
        int ageSexCode = AgeSexClass.valueOf(ageSex).getAgeSexCode();
        int breedCode = breed.getBreedCode();
        int colorCode = color.getColorCode();

        return Integer.valueOf(String.format("%d%d%d", breedCode, ageSexCode, colorCode));
    }

    public static String getShowClassNameWithSex(BreedClass breed, AgeClass ageClass, SexClass sex, ColorClass color)
    {

        String ageClassToString = ageClass.toString();
        String ageName = ageClassToString.substring(0, 1).toUpperCase() + ageClassToString.substring(1).toLowerCase();

        String sexToString = sex.toString();
        String sexName = sexToString.substring(0, 1).toUpperCase() + sexToString.substring(1).toLowerCase();

        String colorToString = color.toString();
        String colorName = colorToString.substring(0, 1).toUpperCase() + colorToString.substring(1).toLowerCase();


        String breedToString = breed.toString();
        String breedName;
        String fleece;

        if (breedToString.contains("_"))
        {
            String[] split = breedToString.split("_");
            breedName = split[0].substring(0, 1).toUpperCase() + split[0].substring(1).toLowerCase();
            fleece = split[1].substring(0, 1).toUpperCase() + split[1].substring(1).toLowerCase();
            return breedName + " " + ageName + " " + colorName + " " + sexName + " " + fleece;
        }
        else {
            breedName = breedToString.substring(0, 1).toUpperCase() + breedToString.substring(1).toLowerCase();
            return breedName + " " + ageName + " " + colorName + " " + sexName;
        }
    }

    public static String getShowClassNameWithoutSex(BreedClass breed, AgeClass ageClass, ColorClass color)
    {
        String ageClassToString = ageClass.toString();
        String ageName = ageClassToString.substring(0, 1).toUpperCase() + ageClassToString.substring(1).toLowerCase();

        String colorToString = color.toString();
        String colorName = colorToString.substring(0, 1).toUpperCase() + colorToString.substring(1).toLowerCase();

        String breedToString = breed.toString();
        String breedName;
        String fleece;

        if (breedToString.contains("_"))
        {
            String[] split = breedToString.split("_");
            breedName = split[0].substring(0, 1).toUpperCase() + split[0].substring(1).toLowerCase();
            fleece = split[1].substring(0, 1).toUpperCase() + split[1].substring(1).toLowerCase();
            return breedName + " " + ageName + " " + colorName + " " + fleece;
        }
        else {
            breedName = breedToString.substring(0, 1).toUpperCase() + breedToString.substring(1).toLowerCase();
            return breedName + " " + ageName + " " + colorName;
        }
    }


}

