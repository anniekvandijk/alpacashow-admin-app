package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import com.opencsv.CSVReader;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventParticipantAnimal;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventParticipantAnimalRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventParticipantRepository;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CsvShowEventParticipantAnimalRepository extends ShowEventParticipantAnimalRepository {

    private static final int COL_SHOWEVENTKEY = 0;
    private static final int COL_PARTICIPANTKEY= 1;
    private static final int COL_ANIMALKEY= 2;

    public static ShowEventParticipantAnimalRepository importData(Reader reader) throws IOException {

        CsvShowEventParticipantAnimalRepository repo = new CsvShowEventParticipantAnimalRepository();
        repo.read(reader);
        return repo;
    }

    public static void exportData(final Writer writer, final ShowEventParticipantAnimalRepository showEventParticipantAnimalRepository) throws IOException {
        writer  .append("SHOWEVENTKEY").append(";")
                .append("PARTICIPANTKEY").append(";")
                .append("ANIMALKEY").append("\n");

        for (String showEventParticipantAnimal : showEventParticipantAnimalRepository.getAllShowEventParticipantAnimalsByKeySet()) {
            ShowEventParticipantAnimal participantAnimal = showEventParticipantAnimalRepository.getShowEventParticipantAnimalByKeySet(showEventParticipantAnimal);
            writer  .append(participantAnimal.getShowEventKey()).append(";")
                    .append(participantAnimal.getParticipantKey()).append(";")
                    .append(participantAnimal.getAnimalKey()).append("\n");
        }
    }

    private void read(Reader reader) throws IOException {
        CSVReader csvReader = new CSVReader(reader, ';');

        csvReader.readNext(); // read the first row (header)
        String[] nextLine;

        while ((nextLine = csvReader.readNext()) != null) {

            String showEventKeyCln = StringUtils.trimToNull(nextLine[COL_SHOWEVENTKEY]);
            String participantKeyCln = StringUtils.trimToNull(nextLine[COL_PARTICIPANTKEY]);
            String animalKeyCln = StringUtils.trimToNull(nextLine[COL_ANIMALKEY]);

            add(new ShowEventParticipantAnimal(showEventKeyCln, participantKeyCln, animalKeyCln));
        }
        csvReader.close();
    }
}
