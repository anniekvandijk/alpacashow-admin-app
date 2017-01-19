package nl.animundo.apps.alpacashowadmin.backend.domain.enums;

public enum BreedClass {

    HUACAYA (1),
    SURI (2),
    HUACAYA_FLEECE (3),
    SURI_FLEECE (4);

    private final int breedCode;

    BreedClass(final int breedCode) {
        this.breedCode = breedCode;
    }

    public int getBreedCode() {
        return breedCode;
    }
}
