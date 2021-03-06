package service;

import model.Meal;
import util.exception.NotFoundException;

import java.util.List;

public interface MealService {


    Meal create(Meal meal, int restaurantId);

    Meal get(int id) throws NotFoundException;

    Meal update(Meal meal, int restaurantId) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    List<Meal> getAll();

    List<Meal> getAllByRestaurantId(Integer id);

    List<Meal> getAllForTodayByRestaurantId(Integer id);

    Integer getMealsPriceForTodayByRestaurantId(Integer id);
}