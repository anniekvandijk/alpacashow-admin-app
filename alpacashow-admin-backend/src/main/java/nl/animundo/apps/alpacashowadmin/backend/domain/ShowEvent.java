package nl.animundo.apps.alpacashowadmin.backend.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import nl.animundo.apps.alpacashowadmin.backend.utilities.JsonDateDeserializer;
import nl.animundo.apps.alpacashowadmin.backend.utilities.JsonDateSerializer;
import nl.animundo.apps.alpacashowadmin.backend.utilities.JsonShowTypeDeserializer;
import nl.animundo.apps.alpacashowadmin.backend.utilities.JsonShowTypeSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import java.time.*;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ShowEvent {
    private static Logger logger = LoggerFactory.getLogger(ShowEvent.class);

    private String id;
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

    public ShowEvent(final String id, final String name, final LocalDate date, final LocalDate closeDate,
                     final String location, final String judge, final ShowType showType)
    {
        this(id, name, date, closeDate, location, judge, showType, new LinkedHashSet<Participant>());
    }

    @JsonCreator
    public ShowEvent(@JsonProperty("id") final String id, @JsonProperty("name") final String name, @JsonProperty("date") final LocalDate date,
                     @JsonProperty("closeDate") final LocalDate closeDate, @JsonProperty("location") final String location,
                     @JsonProperty("judge") final String judge, @JsonProperty("showType") final ShowType showType,
                     @JsonProperty("participants") final Set<Participant> participants ) {

        final String idCln = StringUtils.trimToNull(id);
        final String nameCln = StringUtils.trimToNull(name);
        final String locationCln = StringUtils.trimToNull(location);
        final String judgeCln = StringUtils.trimToNull(judge);
//        if (idCln == null) {
//            throw new IllegalArgumentException("Field id can not be empty");
//        }
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
        if (date.isBefore(closeDate) || date.isEqual(closeDate)) {
            throw new IllegalArgumentException("Date show before or same as close date subscriptions");
        }
        if (showType == null) {
            throw new IllegalArgumentException("Field showType can not be empty");
        }
        this.id = idCln;
        this.name = nameCln;
        this.date = date;
        this.closeDate = closeDate;
        this.location = locationCln;
        this.judge = judgeCln;
        this.showType = showType;
        this.participants = participants;
    }

    public String getId() { return id; }

    public void setId(String id) {
        final String idCln = StringUtils.trimToNull(id);
        if (idCln == null) {
            throw new IllegalArgumentException("Field id can not be empty");
        }
        this.id = idCln;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public String getLocation() {
        return location;
    }

    public String getJudge() {
        return judge;
    }

    public ShowType getShowType() {
        return showType;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }
}
