package org.fis.pc.exceptions;

public class EmptyFieldsException extends Throwable {
    public EmptyFieldsException(){
        super("Please complete the missing fields!");
    }
}
