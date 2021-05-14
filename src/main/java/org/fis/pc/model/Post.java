package org.fis.pc.model;

import org.dizitart.no2.objects.Id;

public class Post {

    private static int count;
    @Id
    private int ID;
    private String name;
    private String price;
    private String description;
    private String category;
    private String ownerName;
    private String image;

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static void setCount(int count) {
        Post.count = count;
    }

    public Post(String name, String price, String category, String description, String image, String ownerName){
        this.ID = count;
        count++;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.image = image;
        this.ownerName = ownerName;
    }
    public Post(){

    }
}
