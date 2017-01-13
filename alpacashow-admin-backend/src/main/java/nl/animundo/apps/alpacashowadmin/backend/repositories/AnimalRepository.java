package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnimalRepository {
    private static Logger logger = LoggerFactory.getLogger(AnimalRepository.class);
    private Map<String, Animal> animals = new HashMap<>();


    public void add(final Animal animal) {

        String animalKey = animal.getMicrochip();
        if (getAnimalByKeySet(animalKey) == null) {
            animals.put(animalKey, animal);
            logger.info("Added animal '" + animalKey + "' to animalRepo");
        } else {
            throw new IllegalArgumentException("Animal already exists");
        }
    }

    public String delete(final String animalKey) {

        Animal animalToDelete = getAnimalByKeySet(animalKey);
        if (animalToDelete != null) {
            animals.remove(animalToDelete.getMicrochip());
            logger.info("Deleted animal '" + animalKey + "' from animalRepo");
            return animalToDelete.getMicrochip();
        } else {
            return null;
        }
    }

    public Set<String> getAllAnimalsByKeySet() {
        return animals.keySet();
    }

    public Collection<Animal> getAllAnimals() {
        return animals.values();
    }

    public Animal getAnimalByKeySet(final String keySet) {
        return animals.get(keySet);
    }

}
