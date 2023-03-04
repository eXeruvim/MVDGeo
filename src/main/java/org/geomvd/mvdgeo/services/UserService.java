package org.geomvd.mvdgeo.services;

import org.geomvd.mvdgeo.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User save(User user);
    User findUserByLogin(String username);
    User findUserByEmail(String email);
    List<User> findAllUsers();
}
