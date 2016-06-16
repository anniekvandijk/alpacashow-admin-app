package nl.animundo.apps.alpacashowadmin.backend.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowType;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.xssf.usermodel.*;

import javax.imageio.IIOException;

/**
 * Created by Anniek van Dijk on 15-6-2016.
 */
public class ConvertToCsvService {

    private static List<List<XSSFCell>> cellGrid;
    private static String fileLocation = "src/test/resources/";
    private static FileInputStream myInput;
    private static File outputFile;

    public static void convertExcelToCsv(String excelFile, ShowType showType) throws IOException {

        String ext = FilenameUtils.getExtension(excelFile);
        String filename = FilenameUtils.getBaseName(excelFile);
        if (ext.equalsIgnoreCase("xls")) {
            throw new IIOException("Upload excel file .xls not allowed");
        }

        try {
            cellGrid = new ArrayList<>();

            File resourcePath = new File(fileLocation);
            if (! (resourcePath.isDirectory() && resourcePath.exists())) {
                throw new IOException("Expected to get resourceDir '" + fileLocation
                        + "', but does not exist on '" + resourcePath + "'");
            }
                myInput = new FileInputStream(fileLocation + "fileupload/" + excelFile);

            XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);
            Iterator<?> rowIter = mySheet.rowIterator();

            while (rowIter.hasNext()) {
                XSSFRow myRow = (XSSFRow) rowIter.next();
                Iterator<?> cellIter = myRow.cellIterator();
                List<XSSFCell> cellRowList = new ArrayList<>();
                while (cellIter.hasNext()) {
                    XSSFCell myCell = (XSSFCell) cellIter.next();
                    cellRowList.add(myCell);
                }
                cellGrid.add(cellRowList);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        outputFile = new File(fileLocation + "csv/" + showType + "_" + filename + ".csv");

        PrintStream stream = new PrintStream(outputFile);
        for (int i = 0; i < cellGrid.size(); i++) {
            List<XSSFCell> cellRowList = cellGrid.get(i);
            for (int j = 0; j < cellRowList.size(); j++) {
                XSSFCell myCell = cellRowList.get(j);
                String stringCellValue = myCell.toString();
                stream.print(stringCellValue + ";");
            }
            stream.println("");
        }
    }

}