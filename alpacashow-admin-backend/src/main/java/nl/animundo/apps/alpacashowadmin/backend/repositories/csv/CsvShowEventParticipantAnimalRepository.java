package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import com.opencsv.CSVReader;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventParticipantAnimal;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventParticipantAnimalRepository;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CsvShowEventParticipantAnimalRepository extends ShowEventParticipantAnimalRepository {

    private static final int COL_SHOWEVENTID = 0;
    private static final int COL_PARTICIPANTID= 1;
    private static final int COL_ANIMALID= 2;

    public static ShowEventParticipantAnimalRepository importData(Reader reader) throws IOException {

        CsvShowEventParticipantAnimalRepository repo = new CsvShowEventParticipantAnimalRepository();
        repo.read(reader);
        return repo;
    }

    public static void exportData(final Writer writer, final ShowEventParticipantAnimalRepository showEventParticipantAnimalRepo) throws IOException {
        writer  .append("SHOWEVENTID").append(";")
                .append("PARTICIPANTID").append(";")
                .append("ANIMALID").append("\n");

        for (ShowEventParticipantAnimal showEventParticipantAnimal : showEventParticipantAnimalRepo.getAll()) {
            writer  .append(showEventParticipantAnimal.getShowEventId()).append(";")
                    .append(showEventParticipantAnimal.getParticipantId()).append(";");
                    if (showEventParticipantAnimal.getAnimalId() != null) {
                        writer.append(showEventParticipantAnimal.getAnimalId()).append("\n");
                    }
                    else {
                        writer.append("\n");
                    }
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

            add(new ShowEventParticipantAnimal(showEventIdCln, participantIdCln, animalIdCln));
        }
        csvReader.close();
    }
}
