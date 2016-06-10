package nl.animundo.apps.alpacashowadmin.backend.domain;

/**
 * Created by Anniek van Dijk on 5-6-2016.
 */
public class Participant {

    // TODO check for null and empty string

    private String name;

    public Participant(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
