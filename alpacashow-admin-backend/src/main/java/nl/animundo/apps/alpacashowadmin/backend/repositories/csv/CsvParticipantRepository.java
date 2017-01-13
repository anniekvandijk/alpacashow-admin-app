package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import com.opencsv.CSVReader;
import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ParticipantRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CsvParticipantRepository extends ParticipantRepository {

    private static final int COL_NAME = 0;
    private static final int COL_FARMNAME= 1;
    private static final int COL_EMAIL = 2;
    private static final int COL_TELEPHONE = 3;
    private static final int COL_ADDRESS = 4;
    private static final int COL_ZIPCODE = 5;
    private static final int COL_CITY = 6;
    private static final int COL_COUNTRY = 7;

    public static ParticipantRepository importData(Reader reader) throws IOException {

        CsvParticipantRepository repo = new CsvParticipantRepository();
        repo.read(reader);
        return repo;
    }

    public static void exportData(final Writer writer, final ParticipantRepository participantRepo) throws IOException {
        writer  .append("NAME").append(";")
                .append("FARMNAME").append(";")
                .append("EMAIL").append(";")
                .append("TELEPHONE").append(";")
                .append("ADDRESS").append(";")
                .append("ZIPCODE").append(";")
                .append("CITY").append(";")
                .append("COUNTRY").append("\n");

        for (String participant : participantRepo.getAllParticipantsByKeySet()) {
            Participant part = participantRepo.getParticipantByKeySet(participant);
            writer  .append(part.getName()).append(";")
                    .append(part.getFarmName().toString()).append(";")
                    .append(part.getEmail().toString()).append(";")
                    .append(part.getTelephone()).append(";")
                    .append(part.getAddress()).append(";")
                    .append(part.getZipCode()).append(";")
                    .append(part.getCity()).append(";")
                    .append(part.getCountry().toString()).append("\n");
        }
    }

    private void read(Reader reader) throws IOException {
        CSVReader csvReader = new CSVReader(reader, ';');

        csvReader.readNext(); // read the first row (header)
        String[] nextLine;

        while ((nextLine = csvReader.readNext()) != null) {

            String nameCln = StringUtils.trimToNull(nextLine[COL_NAME]);
            String farmNameCln = StringUtils.trimToNull(nextLine[COL_FARMNAME]);
            String emailCln = StringUtils.trimToNull(nextLine[COL_EMAIL]);
            String telephoneCln = StringUtils.trimToNull(nextLine[COL_TELEPHONE]);
            String addressCln = StringUtils.trimToNull(nextLine[COL_ADDRESS]);
            String zipCodeCln = StringUtils.trimToNull(nextLine[COL_ZIPCODE]);
            String cityCln = StringUtils.trimToNull(nextLine[COL_CITY]);
            String countryCln = StringUtils.trimToNull(nextLine[COL_COUNTRY]);

            add(new Participant(nameCln, farmNameCln, emailCln, telephoneCln, addressCln, zipCodeCln, cityCln, countryCln));
        }
        csvReader.close();
    }
}
