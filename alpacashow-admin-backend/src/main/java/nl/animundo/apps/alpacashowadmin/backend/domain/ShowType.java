package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Anniek van Dijk on 8-6-2016.
 */
public enum ShowType {

    HALTERSHOW,
    FLEECESHOW,
    MALE_PROGENY_SHOW,
    FEMALEPROGENYSHOW;

    public static ShowType fromText(final String showTypeStr) {
        final String showTypeCln = StringUtils.trimToNull(showTypeStr);
        for (ShowType showType : values()) {
            if (showType.name().replace('_', ' ').equalsIgnoreCase(showTypeCln)) {
                return showType;
            }
        }

        throw new RuntimeException();
    }
}



