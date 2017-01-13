package nl.animundo.apps.alpacashowadmin.backend.domain.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public enum AgeClass {

    JUNIOR (6, 11),
    INTERMEDIATE (12, 23),
    ADULT (24, 47),
    SENIOR (48, 71),
    MATURE (72, 600);

    private final int monthMin;
    private final int monthMax;

    AgeClass(final int monthMin, final int monthMax) {
        this.monthMin = monthMin;
        this.monthMax = monthMax;
    }

    public int getMonthMin() {
        return monthMin;
    }

    public int getMonthMax() {
        return monthMax;
    }
}
