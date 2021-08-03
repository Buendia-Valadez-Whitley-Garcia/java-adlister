package com.outfitterexpert.outfitterexpert.repositories;

import com.outfitterexpert.outfitterexpert.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByFirstName(String firstName);
    User save(User user);
}
