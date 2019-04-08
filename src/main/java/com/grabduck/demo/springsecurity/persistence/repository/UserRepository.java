package com.grabduck.demo.springsecurity.persistence.repository;

import com.grabduck.demo.springsecurity.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
