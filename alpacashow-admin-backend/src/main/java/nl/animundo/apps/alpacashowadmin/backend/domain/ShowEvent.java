package nl.animundo.apps.alpacashowadmin.backend.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import nl.animundo.apps.alpacashowadmin.backend.util.JsonDateDeserializer;
import nl.animundo.apps.alpacashowadmin.backend.util.JsonDateSerializer;
import nl.animundo.apps.alpacashowadmin.backend.util.JsonShowTypeDeserializer;
import nl.animundo.apps.alpacashowadmin.backend.util.JsonShowTypeSerializer;
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
    @JsonDeserialize(using = JsonShowTypeDeserializer.class)
    @JsonSerialize(using = JsonShowTypeSerializer.class)
    private ShowType showType;
    private Set<Participant> participants;

    public ShowEvent() {
        // For Json serialization
        super();
    }

    public ShowEvent(final String name, final LocalDate date, final LocalDate closeDate, final String location, final String judge, final ShowType showType) {
        this(name, date, closeDate, location, judge, showType, new HashSet<Participant>());
    }


    public ShowEvent(final String name, final LocalDate date, final LocalDate closeDate, final String location, final String judge, final ShowType showType, final Set<Participant> participants ) {

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
        if (showType == null) {
            throw new IllegalArgumentException("Field showType can not be empty");
        }
        this.name = nameCln;
        this.date = date;
        this.closeDate = closeDate;
        this.location = locationCln;
        this.judge = judgeCln;
        this.showType = showType;
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

    public ShowType getShowType() {
        return showType;
    }

    public void setShowType(final ShowType showType) {

        this.showType = showType;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }
}
