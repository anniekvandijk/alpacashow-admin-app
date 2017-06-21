package nl.animundo.apps.alpacashowadmin.backend.domain;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ColorClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.SexClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;


public class ParticipantTest {

    private String id;
    private String name;
    private String farmName;
    private String email;
    private String telephone;
    private String address;
    private String zipCode;
    private String city;
    private String country;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void newParticipantWithTrim() {

        id          = "965d2976-1a82-4610-a18b-c30c44a55e18";
        name        = " New Participant";
        farmName    = "farm";
        email       = " farm@farm.nl ";
        telephone   = "06-12345678";
        address     = "some address";
        zipCode     = "1234 AA";
        city        = "some City";
        country     = "Netherlands   ";

        Participant participant = new Participant(id, name, farmName, email, telephone, address, zipCode, city, country);

        assertEquals("New Participant", participant.getName());
        assertEquals("farm", participant.getFarmName());
        assertEquals("farm@farm.nl", participant.getEmail());
        assertEquals("06-12345678", participant.getTelephone());
        assertEquals("some address", participant.getAddress());
        assertEquals("1234 AA", participant.getZipCode());
        assertEquals("some City", participant.getCity());
        assertEquals("Netherlands", participant.getCountry());
    }

    @Test
    public void newParticipantWithAnimals()
    {
        id          = "965d2976-1a82-4610-a18b-c30c44a55e18";
        name        = "New Participant";
        farmName    = "farm";
        email       = "farm@farm.nl";
        telephone   = "06-12345678";
        address     = "some address";
        zipCode     = "1234 AA";
        city        = "some City";
        country     = "Netherlands";

        Set<Animal> animals = new LinkedHashSet<Animal>();
        animals.add(new Animal("869c1d60-d0f0-4f6a-b4d0-4326a7165b19", "Alpaca1", BreedClass.HUACAYA, SexClass.FEMALE, ColorClass.BLACK, LocalDate.now().minusYears(1), "123456789", null, "Vader", "Moeder"));
        animals.add(new Animal("869c1d60-d0f0-4f6a-b4d0-4326a7165b18", "Alpaca2", BreedClass.SURI, SexClass.MALE, ColorClass.FANCY, LocalDate.now().minusYears(2), "987654321", "BAF12345", "Vader2", "Moeder2"));

        Participant participant = new Participant(id, name, farmName, email, telephone, address, zipCode, city, country, animals);

        assertEquals(animals, participant.getAnimals());
    }

    @Test
    public void nameNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field participant can not be empty");

        id          = "965d2976-1a82-4610-a18b-c30c44a55e18";
        name        = "  ";
        farmName    = "farm";
        email       = "farm@farm.nl";
        telephone   = "06-12345678";
        address     = "some address";
        zipCode     = "1234 AA";
        city        = "some City";
        country     = "Netherlands";

        new Participant(id, name, farmName, email, telephone, address, zipCode, city, country);
    }

    @Test
    public void nameNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field participant can not be empty");

        id          = "965d2976-1a82-4610-a18b-c30c44a55e18";
        name        = null;
        farmName    = "farm";
        email       = "farm@farm.nl";
        telephone   = "06-12345678";
        address     = "some address";
        zipCode     = "1234 AA";
        city        = "some City";
        country     = "Netherlands";

        new Participant(id, name, farmName, email, telephone, address, zipCode, city, country);
    }

    @Test
    public void farmNameNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field farmName can not be empty");

        id          = "965d2976-1a82-4610-a18b-c30c44a55e18";
        name        = "Participant";
        farmName    = "";
        email       = "farm@farm.nl";
        telephone   = "06-12345678";
        address     = "some address";
        zipCode     = "1234 AA";
        city        = "some City";
        country     = "Netherlands";

        new Participant(id, name, farmName, email, telephone, address, zipCode, city, country);
    }

    @Test
    public void farmNameNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field farmName can not be empty");

        id          = "965d2976-1a82-4610-a18b-c30c44a55e18";
        name        = "Participant";
        farmName    = null;
        email       = "farm@farm.nl";
        telephone   = "06-12345678";
        address     = "some address";
        zipCode     = "1234 AA";
        city        = "some City";
        country     = "Netherlands";

        new Participant(id, name, farmName, email, telephone, address, zipCode, city, country);
    }
}
