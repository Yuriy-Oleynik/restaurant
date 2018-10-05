package service.impl;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import repository.UserRepository;
import service.AuthorizedUser;
import service.UserService;
import to.UserTo;
import util.exception.NotFoundException;

import java.util.List;

import static util.UserUtil.prepareToSave;
import static util.UserUtil.updateFromTo;


@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public User create(User user) {
        Assert.notNull(user, "user must be not null");
        return userRepository.save(prepareToSave(user, passwordEncoder));
    }

    @Override
    public User get(int id) throws NotFoundException {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        userRepository.save(user);
    }


    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void delete(int id) throws NotFoundException {
        userRepository.delete(id);

    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    @Transactional
    public void update(UserTo userTo) {
        User user = updateFromTo(get(userTo.getId()), userTo);
        userRepository.save(prepareToSave(user, passwordEncoder));

    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        Assert.notNull(email, "email must not be null");
        return userRepository.getByEmail(email);
    }

    @Cacheable("users")
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getWithVotes(int id) {
        return userRepository.getWithVotes(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getByEmail(email.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("User with " + email + "is not found");
        } else return new AuthorizedUser(user);
    }
}