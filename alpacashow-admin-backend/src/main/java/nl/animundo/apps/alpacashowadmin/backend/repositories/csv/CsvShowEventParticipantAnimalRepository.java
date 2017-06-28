package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import com.opencsv.CSVReader;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventParticipantAnimal;
import nl.animundo.apps.alpacashowadmin.backend.repositories.Repository;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.UUID;

public class CsvShowEventParticipantAnimalRepository extends Repository<ShowEventParticipantAnimal> {

    private static final int COL_SHOWEVENTID = 0;
    private static final int COL_PARTICIPANTID= 1;
    private static final int COL_ANIMALID= 2;

    public static Repository<ShowEventParticipantAnimal> importData(Reader reader) throws IOException {

        CsvShowEventParticipantAnimalRepository repo = new CsvShowEventParticipantAnimalRepository();
        repo.read(reader);
        return repo;
    }

    public static void exportData(final Writer writer, final Repository<ShowEventParticipantAnimal> showEventParticipantAnimalRepo) throws IOException {
        writer  .append("SHOWEVENTID").append(";")
                .append("PARTICIPANTID").append(";")
                .append("ANIMALID").append("\n");

        for (ShowEventParticipantAnimal spa : showEventParticipantAnimalRepo.getAll()) {
            writer  .append(spa.getShowEventId()).append(";")
                    .append(spa.getParticipantId()).append(";")
                    .append(spa.getAnimalId()).append("\n");
        }
    }

    private void read(Reader reader) throws IOException {
        CSVReader csvReader = new CSVReader(reader, ';');

        csvReader.readNext(); // read the first row (header)
        String[] nextLine;

        while ((nextLine = csvReader.readNext()) != null) {

            String showEventIdCln = StringUtils.trimToNull(nextLine[COL_SHOWEVENTID]);
            String participantIdCln = StringUtils.trimToNull(nextLine[COL_PARTICIPANTID]);
            String animalIdCln = StringUtils.trimToNull(nextLine[COL_ANIMALID]);
            String id = UUID.randomUUID().toString();

            add(id, new ShowEventParticipantAnimal(showEventIdCln, participantIdCln, animalIdCln));
        }
        csvReader.close();
    }
}
