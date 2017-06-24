package nl.animundo.apps.alpacashowadmin.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import nl.animundo.apps.alpacashowadmin.backend.context.RepositoryContext;
import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

import static nl.animundo.apps.alpacashowadmin.backend.controllers.JsonFileReaderHelper.readJsonfile;
import static org.junit.Assert.assertEquals;

@Ignore
public class AnimalControllerTest {

    private RepositoryContext context;
    private AnimalController controller;
    private ApplicationRepositoryService service;

    @Before
    public void before() throws IOException {
        this.context = new RepositoryContext();
        service = new ApplicationRepositoryService();
        context.animalRepository = service.loadAnimalRepository();
        controller = new AnimalController(context);
    }

    @Test
    public void getAllAnimals() throws IOException {

        Response response = controller.getAnimals();
        assertEquals(200, response.getStatus());

        ObjectMapper mapper = new ObjectMapper();
        List<Animal> list = mapper.readValue(response.getEntity().toString(),
                TypeFactory.defaultInstance().constructCollectionType(List.class, Animal.class));
        assertEquals(5, list.size());
    }

    @Test
    public void getAnimalById() throws IOException {

        Response response = controller.getAnimalByKey("869c1d60-d0f0-4f6a-b4d0-4326a7165b13");
        assertEquals(200, response.getStatus());

        ObjectMapper mapper = new ObjectMapper();
        Animal animal = mapper.readValue(response.getEntity().toString(), Animal.class);
        assertEquals("869c1d60-d0f0-4f6a-b4d0-4326a7165b13", animal.getId());
    }

    @Test
    public void addDeleteUpdateAnimal() throws IOException {

        assertEquals(5, context.animalRepository.getAllAnimals().size());

        String file = readJsonfile("add_animal.json");
        Response response1 = controller.addAnimal(file);
        assertEquals(200, response1.getStatus());

        assertEquals(6, context.animalRepository.getAllAnimals().size());

        Animal animal = context.animalRepository.getAnimalById("chippie");
        assertEquals("SURI", animal.getBreed().toString());

        String file2 = readJsonfile("update_animal.json");
        Response response2 = controller.updateAnimal("chippie", file2);
        assertEquals(200, response2.getStatus());

        Animal animal2 = context.animalRepository.getAnimalById("chippie");
        assertEquals("HUACAYA", animal2.getBreed().toString());

        controller.deleteAnimal("chippie");

    }

    @Test
    public void getAnimalByNotExistingKey() throws IOException {

        Response resultCode = controller.getAnimalByKey("Some not known animal");
        assertEquals(404, resultCode.getStatus());
    }

    @Test
    public void addAnimalWithWrongData() throws IOException {

        String file = readJsonfile("add_animalWrong.json");
        Response resultCode = controller.addAnimal(file);

        assertEquals(400, resultCode.getStatus());

    }

    @Test
    public void updateAnimalWithWrongKey() throws IOException {

        String file = readJsonfile("update_animal.json");
        Response resultCode = controller.updateAnimal("not known chip", file);

        assertEquals(404, resultCode.getStatus());
    }

    @Test
    public void updateAnimalWithWrongData() throws IOException {

        String file = readJsonfile("update_animalWrong.json");
        Response resultCode = controller.updateAnimal("5555", file);

        assertEquals(400, resultCode.getStatus());
    }

    @Test
    public void deleteAnimalWithWrongKey() throws IOException {

        Response resultCode = controller.deleteAnimal("Animal X");

        assertEquals(404, resultCode.getStatus());

    }
}
