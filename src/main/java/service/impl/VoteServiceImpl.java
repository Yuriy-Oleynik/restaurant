package service.impl;

import model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.RestaurantRepository;
import repository.UserRepository;
import repository.VoteRepository;
import service.VoteService;
import util.exception.NotFoundException;

import java.util.List;


@Service
public class VoteServiceImpl implements VoteService {

    private VoteRepository voteRepository;

    private RestaurantRepository restaurantRepository;

    private UserRepository userRepository;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository, RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.voteRepository = voteRepository;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Vote create(Vote vote, int restaurantId, int userId) {
        Assert.notNull(vote, "vote must not be null");
        if (voteRepository.getVotesCountForTodayByUserId(userId) == 0) {
            vote.setRestaurant(restaurantRepository.getOne(restaurantId));
            vote.setUser(userRepository.getOne(userId));
            return voteRepository.save(vote);
        } else return null;
    }

    @Override
    public Vote get(int id) throws NotFoundException {
        return voteRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Vote vote) {
        Assert.notNull(vote, "vote must not be null");
        voteRepository.save(vote);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        voteRepository.delete(id);
    }

    @Override
    public List<Vote> getAll() {
        return voteRepository.findAll();
    }

    @Override
    public Integer getRatingForTodayByRestaurantId(Integer id) {
        return voteRepository.getRatingForTodayByRestaurantId(id);
    }

    @Override
    public Integer getRatingOverallByRestaurantId(Integer id) {
        return voteRepository.getRatingOverallByRestaurantId(id);
    }
}