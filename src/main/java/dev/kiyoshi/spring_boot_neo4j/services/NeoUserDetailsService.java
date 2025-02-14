package dev.kiyoshi.spring_boot_neo4j.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.kiyoshi.spring_boot_neo4j.repositories.UserRepository;

@Service
public class NeoUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public NeoUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
            .findUserByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
    }

}
