package org.fis.pc.exceptions;

public class NoImageSelectedException extends Exception {
    public NoImageSelectedException(){
        super("Please select a photo first!");
    }
}
