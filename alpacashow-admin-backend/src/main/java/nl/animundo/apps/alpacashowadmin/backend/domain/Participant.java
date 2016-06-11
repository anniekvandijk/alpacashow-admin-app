package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Anniek van Dijk on 5-6-2016.
 */
public class Participant {

    private String name;

    public Participant(final String name) {

        final String nameCln = StringUtils.trimToNull(name);
        if (nameCln == null) {
            throw new IllegalArgumentException("Field participant can not be empty");
        }
        this.name = nameCln;
    }

    public String getName() {
        return name;
    }

}
