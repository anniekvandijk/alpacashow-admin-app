package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 8-6-2016.
 */
public class SexClassTest {

    @Test
    public void female() {

        assertEquals("Female", SexClass.FEMALE.getSex());

    }

    @Test
    public void male() {

        assertEquals("Male", SexClass.MALE.getSex());

    }


}
