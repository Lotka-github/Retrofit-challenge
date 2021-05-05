package org.lotka.retrofitapi.Module;

public class StandardJsonModule {
    String category ;
    float price ;
    String instructions ;
    String photo ;
    String name;
    int productId ;



    public StandardJsonModule(String category, float price, String instructions, String photo, String name, int productId) {
        this.category = category;
        this.price = price;
        this.instructions = instructions;
        this.photo = photo;
        this.name = name;
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
