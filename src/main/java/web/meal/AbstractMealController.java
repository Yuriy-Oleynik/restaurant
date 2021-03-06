package web.meal;

import model.Meal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import service.MealService;
import util.exception.NotFoundException;

import java.util.List;

import static util.ValidationUtil.assureIdConsistent;

public abstract class AbstractMealController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    MealService mealService;

    public Meal create(Meal meal, int restaurantId) {
        log.info("create {}", meal);
        return mealService.create(meal, restaurantId);
    }

    public Meal get(int id) throws NotFoundException {
        log.info("get meal with id = {}", id);
        return mealService.get(id);
    }

    public void update(Meal meal, int id, int restaurantId) {
        log.info("update {}", meal);
        assureIdConsistent(meal, id);
        mealService.update(meal, restaurantId);
    }

    public void delete(int id) throws NotFoundException {
        log.info("delete meal with id = {}", id);
        mealService.delete(id);
    }

    public List<Meal> getAll() {
        log.info("get all meals");
        return mealService.getAll();
    }

    public List<Meal> getAllByRestaurantId(Integer id) {
        log.info("get all meals for restaurant with id = {}", id);
        return mealService.getAllByRestaurantId(id);
    }

    public List<Meal> getAllForTodayByRestaurantId(Integer id) {
        log.info("get all meal for today for restaurant with id = {}", id);
        return mealService.getAllForTodayByRestaurantId(id);
    }

}
