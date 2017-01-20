package nl.animundo.apps.alpacashowadmin.backend.utilities;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.helpclasses.FleeceWeightPoints;

import java.util.Comparator;

public class FleeceWeightPointsComparator implements Comparator<FleeceWeightPoints> {

    @Override
    public int compare(FleeceWeightPoints fleeceWeightPoints1, FleeceWeightPoints fleeceWeightPoints2) {

        // TODO Sort FleeceWeightPoints by breed, ageClass, weight

        return fleeceWeightPoints1.getAgeClass().compareTo(fleeceWeightPoints2.getAgeClass());
    }
}