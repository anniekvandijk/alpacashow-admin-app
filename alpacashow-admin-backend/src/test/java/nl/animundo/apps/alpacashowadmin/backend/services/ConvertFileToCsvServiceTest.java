package nl.animundo.apps.alpacashowadmin.backend.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.imageio.IIOException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;

/**
 * Created by Anniek van Dijk on 15-6-2016.
 */
public class ConvertFileToCsvServiceTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void noInstanceTest() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        exception.expect(InstantiationException.class);
        exception.expectMessage("Instances of this type are forbidden!");

        Constructor<ConvertFileToCsvService> constructor = ConvertFileToCsvService.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);

        try {
            constructor.newInstance();
        } catch (InvocationTargetException e) {
            throw (InstantiationException) e.getTargetException();
        }

        constructor.setAccessible(false);

    }

    @Test
    public void docxToCsvNotAllowed() throws IOException {

        exception.expect(IOException.class);
        exception.expectMessage("Upload filetype docx not allowed");

        String file = "HALTERSHOW_haltershow.docx";
        ConvertFileToCsvService.convertFileToCsv(file);
    }

    @Test
    public void xlsNotAllowed() throws IOException {

        exception.expect(IIOException.class);
        exception.expectMessage("Upload filetype xls not allowed");

        String file = "HALTERSHOW_haltershow.xls";
        ConvertFileToCsvService.convertFileToCsv(file);
    }

    @Test
    public void fileNotFound() throws IOException {

        exception.expect(FileNotFoundException.class);
        exception.expectMessage("File does not excist in upload directory");

        String file = "HALTERSHOW_waltershow.xlsx";
        ConvertFileToCsvService.convertFileToCsv(file);
    }

    @Test
    public void excelXLSXToCsv() throws IOException {

        String file = "HALTERSHOW_haltershow.xlsx";
        ConvertFileToCsvService.convertFileToCsv(file);
    }

    @Test
    public void excelXLSXToCsvWithName() throws IOException {

        String file = "HALTERSHOW_haltershow2.xlsx";
        ConvertFileToCsvService.convertFileToCsv(file);
    }

}

