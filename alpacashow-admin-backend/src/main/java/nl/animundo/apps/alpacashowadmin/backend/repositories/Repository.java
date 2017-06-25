package nl.animundo.apps.alpacashowadmin.backend.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

public class Repository<T> {
    private static Logger logger = LoggerFactory.getLogger(Repository.class);
    private Map<String, T> objects = new HashMap<>();

    public T add(final String id, final T object) {

        objects.put(id, object);
        logger.info("Added '" + id + "' to repo");
        return object;
    }

    public T update(final String id, final T object)
    {
        delete(id);
        add(id, object);
        logger.info("Updated '" + id + "' from repo");
        return object;
    }

    public String delete(final String id) {

        T objectToDelete = getById(id);
        if (objectToDelete != null) {
            objects.remove(id);
            logger.info("Deleted '" + id + "' from Repo");
            return id;
        } else {
            return null;
        }
    }

    public void deleteAll () {
            objects.clear();
    }

    public Set<String> getAllById() {
        return objects.keySet();
    }

    public Collection<T> getAll() {
        return objects.values();
    }

    public T getById(final String id) {
        return objects.get(id);
    }

}
