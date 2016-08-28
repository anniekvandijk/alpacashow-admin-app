package nl.animundo.apps.alpacashowadmin.backend.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.animundo.apps.alpacashowadmin.backend.util.JsonDateDeserializer;
import nl.animundo.apps.alpacashowadmin.backend.util.JsonDateSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import java.time.*;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

public class ShowEvent {
    private static Logger logger = LoggerFactory.getLogger(ShowEvent.class);

    private String name;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDate date;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDate closeDate;
    private String location;
    private String judge;
    private SortedSet<Show> shows;
    private Set<Participant> participants;

    public ShowEvent() {
        // For Json serialization
        super();
    }

    public ShowEvent(final String name, final LocalDate date, final LocalDate closeDate, final String location, final String judge, final SortedSet<Show> shows) {
        this(name, date, closeDate, location, judge, shows, new HashSet<Participant>());
    }


    public ShowEvent(final String name, final LocalDate date, final LocalDate closeDate, final String location, final String judge, final SortedSet<Show> shows, final Set<Participant> participants ) {

        final String nameCln = StringUtils.trimToNull(name);
        final String locationCln = StringUtils.trimToNull(location);
        final String judgeCln = StringUtils.trimToNull(judge);
        if (nameCln == null) {
            throw new IllegalArgumentException("Field name can not be empty");
        }
        if (date == null) {
            throw new IllegalArgumentException("Field date can not be empty");
        }
        if (closeDate == null) {
            throw new IllegalArgumentException("Field closeDate can not be empty");
        }

        if (locationCln == null) {
            throw new IllegalArgumentException("Field location can not be empty");
        }

        if (judgeCln == null) {
            throw new IllegalArgumentException("Field judge can not be empty");
        }
        if (date.isBefore(LocalDate.now()) || date.isEqual(LocalDate.now()) || closeDate.isBefore(LocalDate.now()) || closeDate.isEqual(LocalDate.now())) {
            throw new IllegalArgumentException("Date is (before) today");
        }
        if (date.isBefore(closeDate) || date.isEqual(closeDate)) {
            throw new IllegalArgumentException("Date show before or same as close date subscriptions");
        }
        this.name = nameCln;
        this.date = date;
        this.closeDate = closeDate;
        this.location = locationCln;
        this.judge = judgeCln;
        this.shows = shows;
        this.participants = participants;
    }


    public String getName() {
        return name;
    }

    public void setName(final String name) {

        final String nameCln = StringUtils.trimToNull(name);
        if (nameCln == null) {
            throw new IllegalArgumentException("Field name can not be empty");
        }

        this.name = nameCln;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Field date can not be empty");
        }
        if (date.isBefore(LocalDate.now()) || date.isEqual(LocalDate.now())) {
            throw new IllegalArgumentException("Date is (before) today");
        }
        if (closeDate != null) {
            if (date.isBefore(closeDate) || date.isEqual(closeDate)) {
                throw new IllegalArgumentException("Date show before or same as close date subscriptions");
            }
        }
        this.date = date;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(final LocalDate closeDate) {
        if (closeDate == null) {
            throw new IllegalArgumentException("Field closeDate can not be empty");
        }
        if (closeDate.isBefore(LocalDate.now()) || closeDate.isEqual(LocalDate.now())) {
            throw new IllegalArgumentException("Close date is (before) today");
        }
        if (date != null) {
            if (date.isBefore(closeDate) || date.isEqual(closeDate)) {
                throw new IllegalArgumentException("Date show before or same as close date subscriptions");
            }
        }
        this.closeDate = closeDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {

        final String locationCln = StringUtils.trimToNull(location);
        if (locationCln == null) {
            throw new IllegalArgumentException("Field location can not be empty");
        }

        this.location = locationCln;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(final String judge) {

        final String judgeCln = StringUtils.trimToNull(judge);
        if (judgeCln == null) {
            throw new IllegalArgumentException("Field judge can not be empty");
        }

        this.judge = judgeCln;
    }

    public SortedSet<Show> getShow() {
        return shows;
    }

    public void setShow(final SortedSet<Show> shows) {

        this.shows = shows;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public String toStringShow() {
        StringBuilder bldr = new StringBuilder();
        for (Show types : shows) {
            if (bldr.length() > 0) {
                bldr.append(", ");
            }
            bldr.append(types.getShowType());
        }
        return bldr.toString();
    }
}
