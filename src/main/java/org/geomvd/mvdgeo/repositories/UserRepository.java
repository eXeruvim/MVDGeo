package org.geomvd.mvdgeo.repositories;

import org.geomvd.mvdgeo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByLogin(String username);
    User findByEmail(String email);
}
