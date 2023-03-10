package org.geomvd.mvdgeo.services;

import org.geomvd.mvdgeo.models.User;
import org.geomvd.mvdgeo.models.consts.ERole;
import org.geomvd.mvdgeo.repositories.RoleRepository;
import org.geomvd.mvdgeo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        super();
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public User save(User registration) {
        if (findUserByLogin(registration.getLogin()) != null){
            throw new IllegalArgumentException();
        } else {

            registration.setRoles(Set.of(roleRepository.findByName(ERole.USER)));
            userRepository.save(registration);
            return registration;
        }
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByLogin(String username) {
        return userRepository.findByLogin(username);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
