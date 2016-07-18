package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import com.opencsv.CSVReader;
import nl.animundo.apps.alpacashowadmin.backend.domain.Show;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowType;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Anniek van Dijk on 1-7-2016.
 */
public class CsvShowEventRepository extends ShowEventRepository {
    private static final int COL_NAME = 0;
    private static final int COL_DATE= 1;
    private static final int COL_CLOSEDATE = 2;
    private static final int COL_LOCATION = 3;
    private static final int COL_JUDGE = 4;
    private static final int COL_SHOWTYPES = 5;
    private static Logger logger = LoggerFactory.getLogger(CsvShowEventRepository.class);


    public static ShowEventRepository create(Reader reader) throws IOException {

        CsvShowEventRepository repo = new CsvShowEventRepository();

        repo.read(reader);
        return repo;
    }

    private void read(Reader reader) throws IOException {
        CSVReader csvReader = new CSVReader(reader, ';');


        csvReader.readNext(); // read the first row (header)
        String[] nextLine = null;

        while ((nextLine = csvReader.readNext()) != null) {

            Set<Show> show = new HashSet<>();
            String[] showList = nextLine[COL_SHOWTYPES].split(",");

            for ( String showInList : showList) {
                String showInListCln = StringUtils.trimToNull(showInList);
                show.add(new Show(ShowType.valueOf(showInListCln.toUpperCase())));
            }

            String dateCln = StringUtils.trimToNull(nextLine[COL_DATE]);
            String closeDateCln = StringUtils.trimToNull(nextLine[COL_CLOSEDATE]);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(dateCln, formatter);
            LocalDate closeDate = LocalDate.parse(closeDateCln, formatter);

            add(new ShowEvent(nextLine[COL_NAME], date, closeDate, nextLine[COL_LOCATION], nextLine[COL_JUDGE], show));
        }

        csvReader.close();

    }



}
