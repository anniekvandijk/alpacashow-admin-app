package nl.animundo.apps.alpacashowadmin.backend.domain;

/**
 * Created by Anniek van Dijk on 7-6-2016.
 */
public enum AgeSexClass {

    JUNIORFEMALE(0),
    JUNIORMALE(1),
    INTERMEDIATEFEMALE(2),
    INTERMEDIATEMALE(3),
    ADULTFEMALE(4),
    ADULTMALE(5),
    SENIORFEMALE(6),
    SENIORMALE(7),
    MATUREFEMALE(8),
    MATUREMALE(9);

    private final int ageSexCode;

    AgeSexClass(final int ageSexCode) {
        this.ageSexCode = ageSexCode;
    }

    public int getAgeSexCode() {
        return ageSexCode;
    }
}
