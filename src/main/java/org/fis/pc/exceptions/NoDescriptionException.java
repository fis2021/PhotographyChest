package org.fis.pc.exceptions;

public class NoDescriptionException extends Exception{
    public NoDescriptionException(){
        super("Please add a description first!");
    }
}
