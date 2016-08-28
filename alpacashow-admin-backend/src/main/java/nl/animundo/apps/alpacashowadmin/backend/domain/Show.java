package nl.animundo.apps.alpacashowadmin.backend.domain;

public class Show implements Comparable<Show> {

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
