package br.com.refound.exception;

import java.text.MessageFormat;

import static br.com.refound.util.Constants.LINE_CONVERTER_EXCEPTION_MSG;

public class LineConverterException extends Exception{
    public LineConverterException(int lineNumber, Exception e){
        super(MessageFormat.format(LINE_CONVERTER_EXCEPTION_MSG, lineNumber),  e);
    }
}
