package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import com.opencsv.CSVReader;
import nl.animundo.apps.alpacashowadmin.backend.domain.Show;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.SortedSet;
import java.util.TreeSet;

public class CsvShowEventRepository extends ShowEventRepository {

    private static final int COL_NAME = 0;
    private static final int COL_DATE= 1;
    private static final int COL_CLOSEDATE = 2;
    private static final int COL_LOCATION = 3;
    private static final int COL_JUDGE = 4;
    private static final int COL_SHOWTYPES = 5;

    public static ShowEventRepository importData(Reader reader) throws IOException {

        CsvShowEventRepository repo = new CsvShowEventRepository();
        repo.read(reader);
        return repo;
    }

    public static void exportData(final Writer writer, final ShowEventRepository showEventRepo) throws IOException {
        writer  .append("NAAM").append(";")
                .append("DATUM").append(";")
                .append("SLUITDATUM").append(";")
                .append("LOCATIE").append(";")
                .append("JURY").append(";")
                .append("SHOWTYPEN").append("\n");

        for (String showEvent : showEventRepo.getShowEvents()) {
            ShowEvent show = showEventRepo.getShowEventsByKeySet(showEvent);
            writer  .append(show.getName()).append(";")
                    .append(show.getDate().toString()).append(";")
                    .append(show.getCloseDate().toString()).append(";")
                    .append(show.getLocation()).append(";")
                    .append(show.getJudge()).append(";")
                    .append(createShowTypeString(show.getShows())).append("\n");
        }
    }

    private static String createShowTypeString(SortedSet<Show> showTypes) {

        final StringBuilder bldr = new StringBuilder();
        for (Show showType : showTypes) {
            if (bldr.length() != 0) {
                bldr.append(", ");
            }
            bldr.append(showType.getShowType());
        }
        return bldr.toString();
    }



    private void read(Reader reader) throws IOException {
        CSVReader csvReader = new CSVReader(reader, ';');


        csvReader.readNext(); // read the first row (header)
        String[] nextLine;

        while ((nextLine = csvReader.readNext()) != null) {

            SortedSet<Show> show = new TreeSet<>();
            String[] showList = nextLine[COL_SHOWTYPES].split(",");

            for ( String showInList : showList) {
                String showInListCln = StringUtils.trimToNull(showInList);
                show.add(new Show(ShowType.valueOf(showInListCln)));
            }

            String dateCln = StringUtils.trimToNull(nextLine[COL_DATE]);
            String closeDateCln = StringUtils.trimToNull(nextLine[COL_CLOSEDATE]);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(dateCln, formatter);
            LocalDate closeDate = LocalDate.parse(closeDateCln, formatter);

            add(new ShowEvent(nextLine[COL_NAME], date, closeDate, nextLine[COL_LOCATION], nextLine[COL_JUDGE], show));
        }

        csvReader.close();

    }



}
