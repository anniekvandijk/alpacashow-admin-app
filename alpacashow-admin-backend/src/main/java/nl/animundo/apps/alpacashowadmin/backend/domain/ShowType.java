package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Anniek van Dijk on 12-6-2016.
 */
public class ShowType {
    private static Logger logger = LoggerFactory.getLogger(ShowType.class);

    private ShowTypes showTypes;

    public ShowType(ShowTypes showTypes) {
        this.showTypes = showTypes;
    }

    public ShowTypes getShowTypes() {
        return showTypes;
    }
}
