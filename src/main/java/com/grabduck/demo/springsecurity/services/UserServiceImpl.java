package com.grabduck.demo.springsecurity.services;

import com.grabduck.demo.springsecurity.persistence.entity.User;
import com.grabduck.demo.springsecurity.persistence.repository.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findById(@NonNull Long id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }
}
