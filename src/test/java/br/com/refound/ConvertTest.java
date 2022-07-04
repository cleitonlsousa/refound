package br.com.refound;

import br.com.refound.convert.Convert;
import br.com.refound.exception.LineConverterException;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.text.MessageFormat;

import static br.com.refound.util.Constants.CONVERT_STRING_EXCEPTION_MSG;
import static br.com.refound.util.Constants.LINE_CONVERTER_EXCEPTION_MSG;
import static org.junit.jupiter.api.Assertions.*;

public class ConvertTest {

    private final String msgExpected =  MessageFormat.format(LINE_CONVERTER_EXCEPTION_MSG, 1);

    @Test
    void TEST_CONVERT_INTEGER_EXCEPTION() {
        String line = "00000000AA                             Terra Daniel DDS00000008360000000003     1899.0220210909";

        Throwable exception = assertThrows(LineConverterException.class, () -> new Convert().execute(getReader(line)));
        assertEquals(msgExpected, exception.getMessage());
        assertTrue(exception.getCause() instanceof NumberFormatException);
    }

    @Test
    public void TEST_CONVERT_STRING_EXCEPTION() {
        String line = "0000000088                                             00000008360000000003     1899.0220210909";

        Throwable exception = assertThrows(LineConverterException.class, () -> new Convert().execute(getReader(line)));
        assertEquals(msgExpected, exception.getMessage());
        assertEquals(CONVERT_STRING_EXCEPTION_MSG, exception.getCause().getCause().getMessage());
    }

    @Test
    public void TEST_CONVERT_BIG_DECIMAL_EXCEPTION() {
        String line = "0000000088                             Terra Daniel DDS00000008360000000003     1899.AA20210909";

        Throwable exception = assertThrows(LineConverterException.class, () -> new Convert().execute(getReader(line)));
        assertEquals(msgExpected, exception.getMessage());
        assertTrue(exception.getCause() instanceof NumberFormatException);
    }

    private BufferedReader getReader(String value){
        return new BufferedReader(new StringReader(value));
    }

}
