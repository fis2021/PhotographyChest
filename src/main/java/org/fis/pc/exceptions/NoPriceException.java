package org.fis.pc.exceptions;

public class NoPriceException extends Exception{
    public NoPriceException(){
        super("Please add a price first!");
    }
}
