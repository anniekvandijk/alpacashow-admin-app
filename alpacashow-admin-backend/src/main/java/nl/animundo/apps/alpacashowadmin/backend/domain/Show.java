package nl.animundo.apps.alpacashowadmin.backend.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import nl.animundo.apps.alpacashowadmin.backend.util.JsonShowTypeDeserializer;
import nl.animundo.apps.alpacashowadmin.backend.util.JsonShowTypeSerializer;

public class Show implements Comparable<Show> {

    @JsonSerialize(using = JsonShowTypeSerializer.class)
    @JsonDeserialize(using = JsonShowTypeDeserializer.class)
    private ShowType showType;

    public Show() {
        // For Json serialization
        super();
    }

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
