package nl.animundo.apps.alpacashowadmin.backend.domain.enums;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

public class AgeSexClassTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void juniorFemale() {

        assertEquals(0, AgeSexClass.JUNIOR_FEMALE.getAgeSexCode());
    }

    @Test
    public void juniorMale() {

        assertEquals(1, AgeSexClass.JUNIOR_MALE.getAgeSexCode());

    }

    @Test
    public void intermediateFemale() {

        assertEquals(2, AgeSexClass.INTERMEDIATE_FEMALE.getAgeSexCode());
    }

    @Test
    public void intermediateMale() {

        assertEquals(3, AgeSexClass.INTERMEDIATE_MALE.getAgeSexCode());
    }

    @Test
    public void adultFemale() {

        assertEquals(4, AgeSexClass.ADULT_FEMALE.getAgeSexCode());
    }

    @Test
    public void adultMale() {

        assertEquals(5, AgeSexClass.ADULT_MALE.getAgeSexCode());
    }

    @Test
    public void seniorFemale() {

        assertEquals(6, AgeSexClass.SENIOR_FEMALE.getAgeSexCode());
    }

    @Test
    public void seniorMale() {

        assertEquals(7, AgeSexClass.SENIOR_MALE.getAgeSexCode());
    }

    @Test
    public void matureFemale() {

        assertEquals(8, AgeSexClass.MATURE_FEMALE.getAgeSexCode());
    }

    @Test
    public void matureMale() {

        assertEquals(9, AgeSexClass.MATURE_MALE.getAgeSexCode());
    }
}
