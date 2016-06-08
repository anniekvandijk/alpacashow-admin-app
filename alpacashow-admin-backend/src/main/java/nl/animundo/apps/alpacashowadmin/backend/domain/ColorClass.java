package nl.animundo.apps.alpacashowadmin.backend.domain;

/**
 * Created by Anniek van Dijk on 7-6-2016.
 */
public enum ColorClass {

    WHITE(0),
    FAWN(1),
    BROWN(2),
    GREY(3),
    BLACK(4),
    FANCY(5),
    BEIGE(6);

    private final int colorCode;

    ColorClass(int colorCode) {
        this.colorCode = colorCode;
    }

    public int getColorCode() {
        return colorCode;
    }
}
