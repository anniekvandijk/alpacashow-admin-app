package nl.animundo.apps.alpacashowadmin.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import org.junit.Before;
import org.junit.Test;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import static nl.animundo.apps.alpacashowadmin.backend.controllers.JsonFileReaderHelper.readJsonfile;
import static org.junit.Assert.assertEquals;

public class AnimalControllerTest {

    private AnimalController controller;
    private ObjectMapper mapper;

    @Before
    public void before() throws IOException {
        controller = new AnimalController();
        mapper = new ObjectMapper();
    }

    @Test
    public void getAllAnimals() throws IOException {

        Response response = controller.getAnimals();
        assertEquals(200, response.getStatus());

        List<Animal> list = mapper.readValue(response.getEntity().toString(),
                TypeFactory.defaultInstance().constructCollectionType(List.class, Animal.class));
        assertEquals(5, list.size());
    }

    @Test
    public void getAnimalById() throws IOException {

        Response response = controller.getAnimalById("a1d81f18-e47e-4f0a-b7f5-28b9eb42fa8e");
        assertEquals(200, response.getStatus());

        Animal animal = mapper.readValue(response.getEntity().toString(), Animal.class);
        assertEquals("a1d81f18-e47e-4f0a-b7f5-28b9eb42fa8e", animal.getId());
    }

    @Test
    public void addDeleteAnimal() throws IOException {

        String file = readJsonfile("add_animal.json");
        Response response1 = controller.addAnimal(file);
        assertEquals(200, response1.getStatus());

        Response response2 = controller.getAnimals();
        List<Animal> list = mapper.readValue(response2.getEntity().toString(),
                TypeFactory.defaultInstance().constructCollectionType(List.class, Animal.class));
        assertEquals(6, list.size());

        String animalId = null;
        for (Animal animal: list)
        {

            if (animal.getName().equals("My English alpaca"))
            {
                animalId = animal.getId();
            }
        }

        Response response3 = controller.deleteAnimal(animalId);
        assertEquals(200, response3.getStatus());
        Response response4 = controller.getAnimals();
        List<Animal> list2 = mapper.readValue(response4.getEntity().toString(),
                TypeFactory.defaultInstance().constructCollectionType(List.class, Animal.class));
        assertEquals(5, list2.size());

    }

    @Test
    public void updateAnimal() throws IOException {
        String file = readJsonfile("update_animal.json");
        Response response = controller.updateAnimal("96a801d5-dd4b-40a4-a2a7-e7ecff35aefb", file);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void getAnimalByNotExistingKey() throws IOException {

        Response response = controller.getAnimalById("Some not known animal");
        assertEquals(404, response.getStatus());
    }

    @Test
    public void addAnimalWithWrongData() throws IOException {

        String file = readJsonfile("add_animalWrong.json");
        Response response = controller.addAnimal(file);

        assertEquals(400, response.getStatus());

    }

    @Test
    public void updateAnimalWithWrongKey() throws IOException {

        String file = readJsonfile("update_animal.json");
        Response response = controller.updateAnimal("not known chip", file);

        assertEquals(404, response.getStatus());
    }

    @Test
    public void updateAnimalWithWrongData() throws IOException {

        String file = readJsonfile("update_animalWrong.json");
        Response response = controller.updateAnimal("6b82f05a-aabf-482b-a6f9-25816413294d", file);

        assertEquals(400, response.getStatus());
    }

    @Test
    public void deleteAnimalWithWrongKey() throws IOException {

        Response response = controller.deleteAnimal("Animal X");

        assertEquals(404, response.getStatus());

    }
}
