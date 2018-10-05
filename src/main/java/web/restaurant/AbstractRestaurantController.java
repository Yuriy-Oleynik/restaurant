package web.restaurant;

import model.Restaurant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import service.RestaurantService;
import util.exception.NotFoundException;

import java.util.List;

import static util.ValidationUtil.assureIdConsistent;


public abstract class AbstractRestaurantController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantService restaurantService;

    public Restaurant get(int id) throws NotFoundException {
        log.info("get restaurant with id = {}", id);
        return restaurantService.get(id);
    }


    public Restaurant create(Restaurant restaurant) {
        log.info("create {}", restaurant);
        return restaurantService.create(restaurant);
    }

    public void update(Restaurant restaurant, int id) {
        assureIdConsistent(restaurant,id);
        log.info("update {}", restaurant);
        restaurantService.update(restaurant);
    }

    public void delete(int id) throws NotFoundException {
        log.info("delete restaurant with id = {}", id);
        restaurantService.delete(id);
    }

    public List<Restaurant> getAll() {
        log.info("get all restaurants");
        return restaurantService.getAll();
    }
}