package nl.animundo.apps.alpacashowadmin.backend.domain;

/**
 * Created by Anniek van Dijk on 5-6-2016.
 */
public class Animal {

    /**
     * Velden:
     * Naam
     * Type (breed)
     * Geslacht
     * Kleur
     * Geboortedatum
     * Microship
     * Registratienummer
     * Naam vader
     * Naam moeder
     */

    public enum breed {

        HUACAYA,
        SURI,
        HUACAYAFLEECE,
        SURIFLEECE;

    }

    public enum sex {

        MALE,
        FEMALE;
    }

    public enum color {

        WHITE,
        BEIGE,
        FAWN,
        BROWN,
        BLACK,
        GREY,
        FANCY;
    }





}
