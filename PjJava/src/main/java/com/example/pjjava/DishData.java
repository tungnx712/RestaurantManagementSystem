package com.example.pjjava;

public class DishData {

    private Integer dish_ID;
    private String dish_name;
    private String type_name;
    private Double price;
    private Double made_price;
    private Integer stock;
    private String availability;
    private String image_link;

    public DishData() {
    }

    public DishData(Integer dish_ID, String dish_name, String type_name, Double price, Double made_price, Integer stock, String availability, String image_link) {
        this.dish_ID = dish_ID;
        this.dish_name = dish_name;
        this.type_name = type_name;
        this.price = price;
        this.made_price = made_price;
        this.stock = stock;
        this.availability = availability;
        this.image_link = image_link;
    }

    public Integer getDish_ID() {
        return dish_ID;
    }

    public void setDish_ID(Integer dish_ID) {
        this.dish_ID = dish_ID;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMade_price() {
        return made_price;
    }

    public void setMade_price(Double made_price) {
        this.made_price = made_price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }
}
