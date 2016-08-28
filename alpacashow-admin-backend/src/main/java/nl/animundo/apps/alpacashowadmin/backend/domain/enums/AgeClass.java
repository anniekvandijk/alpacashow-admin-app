package nl.animundo.apps.alpacashowadmin.backend.domain.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public enum AgeClass {

    JUNIOR (6, 12),
    INTERMEDIATE (12, 24),
    ADULT (24, 48),
    SENIOR (48, 72),
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
