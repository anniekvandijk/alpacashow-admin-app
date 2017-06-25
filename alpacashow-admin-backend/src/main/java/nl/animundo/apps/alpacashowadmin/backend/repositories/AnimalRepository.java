package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import static java.util.Comparator.comparing;

public class AnimalRepository {
    private static Logger logger = LoggerFactory.getLogger(AnimalRepository.class);
    private Map<String, Animal> animals = new HashMap<>();


    public Animal add(final String id, final Animal animal) {

        animals.put(id, animal);
        logger.info("Added animal '" + id + "' to animalRepo");
        return animal;
    }

    public Animal update(final String id, final Animal animal)
    {
        delete(id);
        add(id, animal);
        logger.info("Updated animal '" + id + "' from animalRepo");
        return animal;
    }

    public String delete(final String id) {

        Animal animalToDelete = getAnimalById(id);
        if (animalToDelete != null) {
            animals.remove(id);
            logger.info("Deleted animal '" + id + "' from animalRepo");
            return animalToDelete.getId();
        } else {
            return null;
        }
    }

    public void deleteAll () {
            animals.clear();
    }

    public Set<String> getAllAnimalsById() {
        return animals.keySet();
    }

    public Collection<Animal> getAllAnimals() {
        return animals.values();
    }

    public List<Animal> getAllAnimalsSorted() {

        List<Animal> AnimalList  = new ArrayList<>(animals.values());
        AnimalList.sort(comparing(Animal::getName).thenComparing(Animal::getDateOfBirth));
        AnimalList.stream();
        return AnimalList;
    }

    public Animal getAnimalById(final String id) {
        return animals.get(id);
    }

}
