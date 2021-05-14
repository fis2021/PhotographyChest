package org.fis.pc.exceptions;

public class NoNameException extends Exception{
    public NoNameException(){
        super("Please add a name first!");
    }
}
