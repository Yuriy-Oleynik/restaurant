package service;

import model.User;
import to.UserTo;
import util.exception.NotFoundException;

import java.util.List;

public interface UserService {

    User create(User user);

    User get(int id) throws NotFoundException;

    void update(User user);

    void update(UserTo user);

    void delete(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    List<User> getAll();

    User getWithVotes(int id);


}