package nl.animundo.apps.alpacashowadmin.backend.domain.showevents;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeSexClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ColorClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.SexClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventAnimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class FleeceShow extends Show {
    private static Logger logger = LoggerFactory.getLogger(ShowEventAnimal.class);

    private LocalDate sheerDate;
    private LocalDate beforeSheerdate;
    private float fleeceWeight;
    private int fleeceGrowthInDays;
    private float fleeceWeightCorrection;

    public FleeceShow(final String showEventKey, final String participantKey, final String animalKey, final boolean present, final int startNumber,
                      final LocalDate dateOfBirth, final BreedClass breed, final AgeSexClass ageClass, final SexClass sex, final ColorClass color,
                      final int showClass, final LocalDate sheerDate, final LocalDate beforeSheerdate, final float fleeceWeight,
                      final int fleeceGrowthInDays, final float fleeceWeightCorrection) {
        super(showEventKey, participantKey, animalKey, present, startNumber, dateOfBirth, breed, ageClass, sex, color, showClass);
        this.sheerDate = sheerDate;
        this.beforeSheerdate = beforeSheerdate;
        this.fleeceWeight = fleeceWeight;
        this.fleeceGrowthInDays = fleeceGrowthInDays;
        this.fleeceWeightCorrection = fleeceWeightCorrection;
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


