package br.com.refound;

import br.com.refound.exception.FilePathException;
import br.com.refound.exception.FileReaderException;
import br.com.refound.exception.FileSaveException;
import br.com.refound.exception.LineConverterException;
import br.com.refound.process.Process;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static br.com.refound.util.Constants.FILE_PATH_EXCEPTION_MSG;
import static br.com.refound.util.Constants.getPathFileSave;
import static org.junit.jupiter.api.Assertions.*;

public class ProcessTest {

    @Test
    public void TEST_PATH_NAO_ENVIADO() {
        Throwable exception = assertThrows(FilePathException.class, () -> Process.main(null));
        assertEquals(FILE_PATH_EXCEPTION_MSG, exception.getMessage());
    }

    @Test
    public void TEST_PATH_VAZIO() {
        String[] args = {};
        Throwable exception = assertThrows(FilePathException.class, () -> Process.main(args));
        assertEquals(FILE_PATH_EXCEPTION_MSG, exception.getMessage());
    }

    @Test
    public void TEST_PATH_NULL() {
        String[] args = new String[1];
        args[0] = null;
        Throwable exception = assertThrows(FilePathException.class, () -> Process.main(args));
        assertEquals(FILE_PATH_EXCEPTION_MSG, exception.getMessage());
    }

    @Test
    public void TEST_PATH_EMPTY() {
        String[] args = new String[1];
        args[0] = "";
        Throwable exception = assertThrows(FilePathException.class, () -> Process.main(args));
        assertEquals(FILE_PATH_EXCEPTION_MSG, exception.getMessage());
    }

    @Test
    public void TEST_PROCESS_SUCESS() throws IOException, FileReaderException, FilePathException,
            FileSaveException, LineConverterException {

        File created = new File(getPathFileSave());

        String[] args = new String[]{getDataTest("data_teste.txt")};

        Process.main(args);
        assertTrue(created.exists());
        assertTrue(created.delete());

    }

    @Test
    public void TEST_PROCESS_SUCESS_JSON() throws LineConverterException, FileReaderException, IOException,
            FilePathException, FileSaveException {

        File created = new File(getPathFileSave());

        String[] args = new String[]{getDataTest("data_teste.txt")};

        Process.main(args);

        byte[] fileExpected = Files.readAllBytes(Path.of(getDataTest("estorno.txt")));
        byte[] fileCreated = Files.readAllBytes(Path.of(getPathFileSave()));

        assertArrayEquals(fileExpected, fileCreated);

        assertTrue(created.exists());
        assertTrue(created.delete());

    }

    private String getDataTest(String fileName){
        Path resourceDirectory = Paths.get("src","test","resources", fileName);
        return resourceDirectory.toFile().getAbsolutePath();
    }

}
