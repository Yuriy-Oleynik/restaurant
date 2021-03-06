package repository;

import model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import util.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {

    @Override
    List<Meal> findAll();

    @Override
    @Transactional
    Meal save(Meal meal);

    @Override
    Optional<Meal> findById(Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Meal m WHERE m.id=:id")
    void delete(@Param("id") int id) throws NotFoundException;

    List<Meal> getAllByRestaurantId(Integer id);

    @Query("SELECT m FROM Meal m WHERE m.date >= CURRENT_DATE AND m.restaurant.id=:id")
    List<Meal> getAllForTodayByRestaurantId(@Param("id") Integer id);

    @Query("SELECT SUM (m.price) FROM Meal m WHERE m.date>=CURRENT_DATE AND m.restaurant.id=:id")
    Integer getMealsPriceForTodayByRestaurantId(@Param("id") Integer id);

}
