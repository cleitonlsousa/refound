package br.com.refound.output;

import br.com.refound.exception.FileSaveException;
import br.com.refound.model.User;
import org.json.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Logger;

import static br.com.refound.util.Constants.getPathFileSave;

public class Output {

    private static final Logger logger = Logger.getLogger(Process.class.getName());

    public void save(Collection<User> users) throws FileSaveException {

        try {
            JSONArray jsonObject = new JSONArray(users);

            String path = getPathFileSave();

            FileWriter json = new FileWriter(path);
            json.write(jsonObject.toString());
            json.close();

            logger.info("arquivo de estorno gerado em: " + path);

        } catch (IOException e) {
            throw new FileSaveException(e);
        }
    }

}
