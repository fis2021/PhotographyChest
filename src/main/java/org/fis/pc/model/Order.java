package org.fis.pc.model;

public class Order {
    private String photographerName;
    private String photographerEmail;
    private String photoName;
    private String buyerName;
    private String buyerEmail;

    public Order(String photographerName, String photoName, String buyerName){
        this.photographerName = photographerName;
        this.photoName = photoName;
        this.buyerName = buyerName;
    }

    public String getPhotographerName() {
        return photographerName;
    }

    public void setPhotographerName(String photographerName) {
        this.photographerName = photographerName;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
}
