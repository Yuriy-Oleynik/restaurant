package model;

import java.util.Date;
import java.util.List;

public class Restaurant {

    private String title;

    private String description;

    private Integer todayRating;

    private Integer overallRating;

    private Integer todayMenuPrice;

    private Date date = new Date();

    protected List<Meal> meals;

    protected List<Vote> votes;


    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Integer getTodayRating() {

        return todayRating;
    }

    public void setTodayRating(Integer todayRating) {

        this.todayRating = todayRating;
    }

    public Integer getOverallRating() {

        return overallRating;
    }

    public void setOverallRating(Integer overallRating) {

        this.overallRating = overallRating;
    }

    public Integer getTodayMenuPrice() {

        return todayMenuPrice;
    }

    public void setTodayMenuPrice(Integer todayMenuPrice) {

        this.todayMenuPrice = todayMenuPrice;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }

    public List<Meal> getMeals() {

        return meals;
    }

    public void setMeals(List<Meal> meals) {

        this.meals = meals;
    }

    public List<Vote> getVotes() {

        return votes;
    }

    public void setVotes(List<Vote> votes) {

        this.votes = votes;
    }

}
