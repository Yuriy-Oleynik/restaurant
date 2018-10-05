package service.impl;

import model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.RestaurantRepository;
import service.RestaurantService;
import util.exception.NotFoundException;

import java.util.List;


@Service
public class RestaurantServiceImpl implements RestaurantService {


    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant get(int id) throws NotFoundException {
        return restaurantRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        restaurantRepository.save(restaurant);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        restaurantRepository.delete(id);
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getWithVotes(int id) {
        return restaurantRepository.getWithVotes(id);
    }

    @Override
    public Restaurant getWithMeals(int id) {
        return restaurantRepository.getWithMeals(id);
    }
}
