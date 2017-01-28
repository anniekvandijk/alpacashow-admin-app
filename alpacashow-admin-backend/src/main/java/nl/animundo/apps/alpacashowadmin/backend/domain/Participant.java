package nl.animundo.apps.alpacashowadmin.backend.domain;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

public class Participant {
    private static Logger logger = LoggerFactory.getLogger(Participant.class);

    private String name;
    private String farmName;
    private String email;
    private String telephone;
    private String address;
    private String zipCode;
    private String city;
    private String country;
    private Set<Animal> animals;

    public Participant(final String name, final String farmName, final String email, final String telephone,
                       final String address, final String zipCode, final String city, final String country) {
        this(name, farmName, email, telephone, address, zipCode, city, country, new LinkedHashSet<Animal>());
    }

    @JsonCreator
    public Participant(@JsonProperty("name") final String name, @JsonProperty("farmName") final String farmName,
                       @JsonProperty("email") final String email, @JsonProperty("telephone") final String telephone,
                       @JsonProperty("address") final String address, @JsonProperty("zipCode") final String zipCode,
                       @JsonProperty("city") final String city, @JsonProperty("country") final String country,
                       @JsonProperty("animals") Set<Animal> animals) {

        final String nameCln = StringUtils.trimToNull(name);
        final String farmNameCln = StringUtils.trimToNull(farmName);
        final String emailCln = StringUtils.trimToNull(email);
        final String telephoneCln = StringUtils.trimToNull(telephone);
        final String addressCln = StringUtils.trimToNull(address);
        final String zipCodeCln = StringUtils.trimToNull(zipCode);
        final String cityCln = StringUtils.trimToNull(city);
        final String countryCln = StringUtils.trimToNull(country);
        if (nameCln == null) {
            throw new IllegalArgumentException("Field participant can not be empty");
        }
        if (farmNameCln == null) {
            throw new IllegalArgumentException("Field farmName can not be empty");
        }
        this.name = nameCln;
        this.farmName = farmNameCln;
        this.email = emailCln;
        this.telephone = telephoneCln;
        this.address = addressCln;
        this.zipCode = zipCodeCln;
        this.city = cityCln;
        this.country = countryCln;
        this.animals = animals;
    }

    public String getName() {
        return name;
    }

    public String getFarmName() {
        return farmName;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }
}
