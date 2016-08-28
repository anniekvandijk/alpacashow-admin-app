package nl.animundo.apps.alpacashowadmin.backend.services;

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

