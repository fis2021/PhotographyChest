package org.fis.pc.exceptions;

public class NoCategoryException extends Exception{
    public NoCategoryException(){
        super("Please select a category first!");
    }
}
