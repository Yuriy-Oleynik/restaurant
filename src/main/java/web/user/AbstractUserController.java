package web.user;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;
import util.exception.NotFoundException;

import java.util.List;

import static util.ValidationUtil.checkNew;


public abstract class AbstractUserController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    public User create(User user) {
        log.info("create user {}", user);
        checkNew(user);
        return userService.create(user);
    }

    public User get(int id) throws NotFoundException {
        log.info("get user with if = {}", id);
        return userService.get(id);
    }


    public List<User> getAll() {
        log.info("get all users");
        return userService.getAll();
    }

}