package model;

import java.util.Date;

public class Vote {

    private User user;

    private Date date = new Date();

    private Restaurant restaurant;


    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }

    public Restaurant getRestaurant() {

        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {

        this.restaurant = restaurant;
    }

}
