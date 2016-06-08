package nl.animundo.apps.alpacashowadmin.backend.domain;

/**
 * Created by Anniek van Dijk on 8-6-2016.
 */
public enum ShowType {

    HALTERSHOW ("Haltershow"),
    FLEECESHOW ("Fleeceshow"),
    MALEPROGENYSHOW ("Male progeny show"),
    FEMALEPROGENYSHOW ("Female progeny show");

    private final String showType;

    ShowType(String showType) {
        this.showType = showType;
    }

    public String getShowType() {
        return showType;
    }

}


