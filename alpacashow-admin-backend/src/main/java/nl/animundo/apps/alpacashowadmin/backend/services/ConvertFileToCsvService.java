package nl.animundo.apps.alpacashowadmin.backend.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationFileDirService;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.xssf.usermodel.*;

import javax.imageio.IIOException;

public class ConvertFileToCsvService {

    private static List<List<XSSFCell>> cellGrid;
    private static FileInputStream myInput;
    private static File outputFile;
    private static ApplicationFileDirService fileDirService = new ApplicationFileDirService();

    private ConvertFileToCsvService() throws InstantiationException {
        throw new InstantiationException("Instances of this type are forbidden!");
    }

    public static void convertFileToCsv(String file) throws IOException {

        String fileExtension = FilenameUtils.getExtension(file);
        String filename = FilenameUtils.getBaseName(file);
         if (fileExtension.equalsIgnoreCase("xlsx")) {
            convertExcelToCsv(file, filename);
        } else {
            throw new IIOException("Upload filetype " + fileExtension + " not allowed");
        }
    }

    private static void convertExcelToCsv(String excelFile, String filename) throws IOException {

        try {
            cellGrid = new ArrayList<>();

        myInput = new FileInputStream(fileDirService.getFilePath("fileupload/" + excelFile));

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
        } catch (NullPointerException e) {
            throw new FileNotFoundException("File does not excist in upload directory");
        }

        String newCsvFile = "csv";
        outputFile = new File(fileDirService.getFilePath(newCsvFile));

        PrintStream stream = new PrintStream(outputFile + "/" + filename + ".csv");
        for (int i = 0; i < cellGrid.size(); i++) {
            List<XSSFCell> cellRowList = cellGrid.get(i);
            for (int j = 0; j < cellRowList.size(); j++) {
                XSSFCell myCell = cellRowList.get(j);
                String stringCellValue = myCell.toString();
                stream.print(stringCellValue + ";");
            }
            stream.println("");
        }
        stream.close();
    }
}