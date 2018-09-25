package model;

import java.util.Date;

public class Meal {

    private Date date = new Date();

    private Integer price;

    private String description;

    private Restaurant restaurant;



    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }

    public Integer getPrice() {

        return price;
    }

    public void setPrice(Integer price) {

        this.price = price;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Restaurant getRestaurant() {

        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {

        this.restaurant = restaurant;
    }

}
