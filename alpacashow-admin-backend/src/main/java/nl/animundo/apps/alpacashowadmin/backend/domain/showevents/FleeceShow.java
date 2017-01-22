package nl.animundo.apps.alpacashowadmin.backend.domain.showevents;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.*;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventAnimalDetail;
import nl.animundo.apps.alpacashowadmin.backend.services.AgeClassService;
import nl.animundo.apps.alpacashowadmin.backend.services.ShowClassService;
import nl.animundo.apps.alpacashowadmin.backend.services.ShowFleeceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class FleeceShow extends Show {
    private static Logger logger = LoggerFactory.getLogger(ShowEventAnimalDetail.class);

    private AgeClass ageClass;
    private int showClass;
    private LocalDate sheerDate;
    private LocalDate beforeSheerdate;
    private float fleeceWeight;
    private int fleeceGrowthInDays;
    private float fleeceWeightCorrection;

    public FleeceShow(final String showEventKey, final String participantKey, final String animalKey, final boolean present, final int startNumber,
                      final LocalDate dateOfBirth, final BreedClass breed, final SexClass sex, final ColorClass color,
                      final LocalDate sheerDate, final LocalDate beforeSheerdate, final float fleeceWeight) {
        super(showEventKey, participantKey, animalKey, present, startNumber, dateOfBirth, breed, sex, color);
        ageClass = AgeClassService.getAgeClass(sheerDate, dateOfBirth);
        showClass = ShowClassService.getShowClassCode(breed, ageClass, sex, color);
        fleeceGrowthInDays = ShowFleeceService.fleeceGrowthInDays(dateOfBirth, sheerDate, beforeSheerdate);
        fleeceWeightCorrection = ShowFleeceService.fleeceWeightCorrection(dateOfBirth, sheerDate, beforeSheerdate, fleeceWeight);
        this.sheerDate = sheerDate;
        this.beforeSheerdate = beforeSheerdate;
        this.fleeceWeight = fleeceWeight;
    }

    private FleeceShow(final String showEventKey, final String participantKey, final String animalKey, final boolean present, final int startNumber,
                      final LocalDate dateOfBirth, final BreedClass breed, final AgeClass ageClass, final SexClass sex, final ColorClass color,
                      final int showClass, final LocalDate sheerDate, final LocalDate beforeSheerdate, final float fleeceWeight,
                      final int fleeceGrowthInDays, final float fleeceWeightCorrection) {
        super(showEventKey, participantKey, animalKey, present, startNumber, dateOfBirth, breed, sex, color);
        this.ageClass = ageClass;
        this.showClass = showClass;
        this.sheerDate = sheerDate;
        this.beforeSheerdate = beforeSheerdate;
        this.fleeceWeight = fleeceWeight;
        this.fleeceGrowthInDays = fleeceGrowthInDays;
        this.fleeceWeightCorrection = fleeceWeightCorrection;
    }

    public AgeClass getAgeClass() {
        return ageClass;
    }

    public int getShowClass() {
        return showClass;
    }

    public LocalDate getSheerDate() {
        return sheerDate;
    }

    public LocalDate getBeforeSheerdate() {
        return beforeSheerdate;
    }

    public float getFleeceWeight() {
        return fleeceWeight;
    }

    public int getFleeceGrowthInDays() {
        return fleeceGrowthInDays;
    }

    public float getFleeceWeightCorrection() {
        return fleeceWeightCorrection;
    }
}


