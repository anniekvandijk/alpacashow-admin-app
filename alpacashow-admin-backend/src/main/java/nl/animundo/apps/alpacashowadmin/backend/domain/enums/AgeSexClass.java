package nl.animundo.apps.alpacashowadmin.backend.domain.enums;

public enum AgeSexClass {

    JUNIOR_FEMALE(0),
    JUNIOR_MALE(1),
    INTERMEDIATE_FEMALE(2),
    INTERMEDIATE_MALE(3),
    ADULT_FEMALE(4),
    ADULT_MALE(5),
    SENIOR_FEMALE(6),
    SENIOR_MALE(7),
    MATURE_FEMALE(8),
    MATURE_MALE(9);

    private final int ageSexCode;

    AgeSexClass(final int ageSexCode) {
        this.ageSexCode = ageSexCode;
    }

    public int getAgeSexCode() {
        return ageSexCode;
    }
}
