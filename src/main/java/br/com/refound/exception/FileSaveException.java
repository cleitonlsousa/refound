package br.com.refound.exception;

import static br.com.refound.util.Constants.FILE_SAVE_EXCEPTION_MSG;

public class FileSaveException extends Exception{
    public FileSaveException(Exception e){
        super(FILE_SAVE_EXCEPTION_MSG, e);
    }
}
