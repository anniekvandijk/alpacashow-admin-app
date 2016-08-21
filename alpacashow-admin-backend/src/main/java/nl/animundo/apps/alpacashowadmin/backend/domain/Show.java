package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Anniek van Dijk on 12-6-2016.
 */
public class Show implements Comparable<Show> {

    private ShowType showType;

    public Show(final ShowType showType) {

        if (showType == null) {
            throw new IllegalArgumentException("Show can not be empty");
        }
        this.showType = showType;
    }

    public ShowType getShowType() {
        return showType;
    }

    @Override
    public int compareTo(final Show other) {
        return this.getShowType().compareTo(other.getShowType());
    }

}
