package br.com.refound.process;

import br.com.refound.convert.Convert;
import br.com.refound.exception.FilePathException;
import br.com.refound.exception.FileReaderException;
import br.com.refound.exception.FileSaveException;
import br.com.refound.exception.LineConverterException;
import br.com.refound.model.User;
import br.com.refound.output.Output;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.logging.Logger;


public class Process {
    private static final Logger logger = Logger.getLogger("process");

    public static void main(String[] args) throws FilePathException, FileNotFoundException, FileReaderException,
            FileSaveException, LineConverterException {

        logger.info("inicio procesamento arquivo");

        validatePath(args);

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        Collection<User> users = new Convert().execute(reader);

        new Output().save(users);

        logger.info("fim processamento arquivo");

    }
    private static void validatePath(String[] args) throws FilePathException {
        if(args == null || args.length == 0 || args[0] == null || args[0].trim().isEmpty()){
            throw new FilePathException();
        }
    }
}
