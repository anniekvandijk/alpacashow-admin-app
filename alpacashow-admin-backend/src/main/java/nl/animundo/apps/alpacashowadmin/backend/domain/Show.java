package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.SortedSet;

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

    public void setShowType(final ShowType showType) {

        this.showType = showType;
    }

    @Override
    public int compareTo(final Show other) {
        return this.getShowType().compareTo(other.getShowType());
    }

}
