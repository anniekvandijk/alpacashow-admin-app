package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 3-6-2016.
 */
public class AgeSexClassTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void juniorFemale() {

        assertEquals(0, AgeSexClass.JUNIORFEMALE.getAgeSexCode());
    }

    @Test
    public void juniorMale() {

        assertEquals(1, AgeSexClass.JUNIORMALE.getAgeSexCode());

    }

    @Test
    public void intermediateFemale() {

        assertEquals(2, AgeSexClass.INTERMEDIATEFEMALE.getAgeSexCode());
    }

    @Test
    public void intermediateMale() {

        assertEquals(3, AgeSexClass.INTERMEDIATEMALE.getAgeSexCode());
    }

    @Test
    public void adultFemale() {

        assertEquals(4, AgeSexClass.ADULTFEMALE.getAgeSexCode());
    }

    @Test
    public void adultMale() {

        assertEquals(5, AgeSexClass.ADULTMALE.getAgeSexCode());
    }

    @Test
    public void seniorFemale() {

        assertEquals(6, AgeSexClass.SENIORFEMALE.getAgeSexCode());
    }

    @Test
    public void seniorMale() {

        assertEquals(7, AgeSexClass.SENIORMALE.getAgeSexCode());
    }

    @Test
    public void matureFemale() {

        assertEquals(8, AgeSexClass.MATUREFEMALE.getAgeSexCode());
    }

    @Test
    public void matureMale() {

        assertEquals(9, AgeSexClass.MATUREMALE.getAgeSexCode());
    }
}
