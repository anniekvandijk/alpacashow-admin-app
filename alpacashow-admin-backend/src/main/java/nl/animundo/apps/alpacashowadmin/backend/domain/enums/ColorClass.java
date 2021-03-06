package nl.animundo.apps.alpacashowadmin.backend.domain.enums;

public enum ColorClass {

    WHITE(0),
    FAWN(1),
    BROWN(2),
    GREY(3),
    BLACK(4),
    FANCY(5),
    BEIGE(6);

    private final int colorCode;

    ColorClass(final int colorCode) {
        this.colorCode = colorCode;
    }

    public int getColorCode() {
        return colorCode;
    }
}
