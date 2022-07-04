package br.com.refound.exception;

import static br.com.refound.util.Constants.FILE_PATH_EXCEPTION_MSG;

public class FilePathException extends Exception{
    public FilePathException(){
        super(FILE_PATH_EXCEPTION_MSG);
    }
}
