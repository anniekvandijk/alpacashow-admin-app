package nl.animundo.apps.alpacashowadmin.backend.repositories.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.animundo.apps.alpacashowadmin.backend.helpclasses.FleeceWeightPoints;
import nl.animundo.apps.alpacashowadmin.backend.repositories.FleeceWeightPointsRepository;
import java.io.IOException;
import java.io.Reader;
import java.util.Set;

public class JsonFleeceWeightPointsRepository extends FleeceWeightPointsRepository {


    public static FleeceWeightPointsRepository importData(Reader reader) throws IOException {

        JsonFleeceWeightPointsRepository repo = new JsonFleeceWeightPointsRepository();
        repo.read(reader);
        return repo;
    }

    private void read(Reader reader) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Set<FleeceWeightPoints> list = null;
        try {
            list = mapper.readValue(reader, new TypeReference<Set<FleeceWeightPoints>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (list != null) {
            for (FleeceWeightPoints fleeceWeightPoints : list) {
                add(new FleeceWeightPoints(fleeceWeightPoints.getBreed(), fleeceWeightPoints.getAgeClass(),
                        fleeceWeightPoints.getCleanFleeceWeight(), fleeceWeightPoints.getWeightPoints()));
            }
        }
    }
}
