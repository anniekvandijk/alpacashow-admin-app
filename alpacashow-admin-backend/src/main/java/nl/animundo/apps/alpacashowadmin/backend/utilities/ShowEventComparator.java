package nl.animundo.apps.alpacashowadmin.backend.utilities;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;

import java.util.Comparator;

public class ShowEventComparator implements Comparator<ShowEvent> {

    @Override
    public int compare(ShowEvent showEvent1, ShowEvent showEvent2) {
        return showEvent1.getDate().compareTo(showEvent2.getDate());
    }
}
