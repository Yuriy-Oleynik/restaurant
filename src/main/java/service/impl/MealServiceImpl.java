package service.impl;

import model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.MealRepository;
import repository.RestaurantRepository;
import service.MealService;
import util.exception.NotFoundException;

import java.util.List;

import static util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealServiceImpl implements MealService {

    private MealRepository mealRepository;

    private RestaurantRepository restaurantRepository;

    @Autowired
    public MealServiceImpl(MealRepository mealRepository, RestaurantRepository restaurantRepository) {
        this.mealRepository = mealRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Meal create(Meal meal, int restaurantId) {
        Assert.notNull(meal, "meal must not be null");
        meal.setRestaurant(restaurantRepository.getOne(restaurantId));
        return mealRepository.save(meal);
    }

    @Override
    public Meal get(int id) throws NotFoundException {
        return mealRepository.findById(id).orElse(null);
    }

    @Override
    public Meal update(Meal meal, int restaurantId) {
        meal.setRestaurant(restaurantRepository.getOne(restaurantId));
        return checkNotFoundWithId(mealRepository.save(meal), meal.getId());
    }

    @Override
    public void delete(int id) throws NotFoundException {
        mealRepository.delete(id);
    }

    @Override
    public List<Meal> getAll() {
        return mealRepository.findAll();
    }

    @Override
    public List<Meal> getAllByRestaurantId(Integer id) {
        return mealRepository.getAllByRestaurantId(id);
    }

    @Override
    public List<Meal> getAllForTodayByRestaurantId(Integer id) {
        return mealRepository.getAllForTodayByRestaurantId(id);
    }

    @Override
    public Integer getMealsPriceForTodayByRestaurantId(Integer id) {
        return mealRepository.getMealsPriceForTodayByRestaurantId(id);
    }
}