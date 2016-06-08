package nl.animundo.apps.alpacashowadmin.backend.domain;

/**
 * Created by Anniek van Dijk on 7-6-2016.
 */
public enum BreedClass {

    HUACAYA("Huacaya", 1),
    SURI("Suri", 2),
    HUACAYAFLEECE("Huacaya fleece", 3),
    SURIFLEECE("Suri fleece", 4);

    private final String breed;
    private final int breedCode;

    BreedClass(String breed, int breedCode) {
        this.breed = breed;
        this.breedCode = breedCode;
    }

    public String getBreed() {
        return breed;
    }

    public int getBreedCode() {
        return breedCode;
    }
}
