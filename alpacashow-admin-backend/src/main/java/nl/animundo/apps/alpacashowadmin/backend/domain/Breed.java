package nl.animundo.apps.alpacashowadmin.backend.domain;

/**
 * Created by Anniek van Dijk on 7-6-2016.
 */
public enum Breed {

    HUACAYA(1),
    SURI(2),
    HUACAYAFLEECE(3),
    SURIFLEECE(4);

    private final int breedCode;

    Breed(int breedCode) {
        this.breedCode = breedCode;
    }

    public int getBreedCode() {
        return breedCode;
    }
}
