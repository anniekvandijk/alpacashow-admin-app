package nl.animundo.apps.alpacashowadmin.backend.services;

/**
 * Created by Anniek van Dijk on 4-6-2016.
 */

public class AnimalClassCodeService {

    private AnimalClassCodeService() throws InstantiationException {
        throw new InstantiationException("Instances of this type are forbidden!");
    }

    public static int getAnimalClassCode(int breedCode, int ageSexCode, int colorCode) {

        int animalClassCode;

        animalClassCode = Integer.valueOf(breedCode + "" + ageSexCode + "" + colorCode);
        return animalClassCode;
    }

}

