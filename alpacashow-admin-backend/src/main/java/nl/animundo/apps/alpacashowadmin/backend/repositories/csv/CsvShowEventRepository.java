package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import com.opencsv.CSVReader;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import nl.animundo.apps.alpacashowadmin.backend.repositories.Repository;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CsvShowEventRepository extends Repository<ShowEvent> {

    private static final int COL_ID = 0;
    private static final int COL_NAME = 1;
    private static final int COL_DATE= 2;
    private static final int COL_CLOSEDATE = 3;
    private static final int COL_LOCATION = 4;
    private static final int COL_JUDGE = 5;
    private static final int COL_SHOWTYPE = 6;

    public static Repository<ShowEvent> importData(Reader reader) throws IOException {

        CsvShowEventRepository repo = new CsvShowEventRepository();
        repo.read(reader);
        return repo;
    }

    public static void exportData(final Writer writer, final Repository<ShowEvent> showEventRepo) throws IOException {
        writer  .append("ID").append(";")
                .append("NAME").append(";")
                .append("DATE").append(";")
                .append("CLOSEDATE").append(";")
                .append("LOCATION").append(";")
                .append("JUDGE").append(";")
                .append("SHOWTYPE").append("\n");

        for (String id : showEventRepo.getAllById()) {
            ShowEvent show = showEventRepo.getById(id);
            writer  .append(show.getId()).append(";")
                    .append(show.getName()).append(";")
                    .append(show.getDate().toString()).append(";")
                    .append(show.getCloseDate().toString()).append(";")
                    .append(show.getLocation()).append(";")
                    .append(show.getJudge()).append(";")
                    .append(show.getShowType().toString()).append("\n");
        }
    }

    private void read(Reader reader) throws IOException {
        CSVReader csvReader = new CSVReader(reader, ';');


        csvReader.readNext(); // read the first row (header)
        String[] nextLine;

        while ((nextLine = csvReader.readNext()) != null) {

            String idCln = StringUtils.trimToNull(nextLine[COL_ID]);
            String nameCln = StringUtils.trimToNull(nextLine[COL_NAME]);
            String dateCln = StringUtils.trimToNull(nextLine[COL_DATE]);
            String closeDateCln = StringUtils.trimToNull(nextLine[COL_CLOSEDATE]);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(dateCln, formatter);
            LocalDate closeDate = LocalDate.parse(closeDateCln, formatter);
            String locationCln = StringUtils.trimToNull(nextLine[COL_LOCATION]);
            String judgeCln = StringUtils.trimToNull(nextLine[COL_JUDGE]);
            ShowType showTypeCln = ShowType.valueOf(StringUtils.trimToNull(nextLine[COL_SHOWTYPE]));

            add(idCln, new ShowEvent(idCln, nameCln, date, closeDate, locationCln, judgeCln, showTypeCln));
        }
        csvReader.close();
    }
}
