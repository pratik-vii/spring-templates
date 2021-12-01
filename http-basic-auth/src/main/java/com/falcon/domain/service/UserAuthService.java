package com.falcon.domain.service;

import com.falcon.application.auth.basicauth.UserAuthDetails;
import com.falcon.infrastructure.models.UserAuthEntity;
import com.falcon.infrastructure.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthService implements UserDetailsService {
    @Autowired
    private UserAuthRepository userAuthRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<UserAuthEntity> userAuthEntity = userAuthRepository.findByUsername(username);
        userAuthEntity.orElseThrow(() -> new UsernameNotFoundException("User name not found: " + username));
        return new UserAuthDetails(userAuthEntity.get().getUsername(), userAuthEntity.get().getPassword(), userAuthEntity.get().isActive());
    }
}
