package com.roadmap.sh.AdvancedTrackerApi.service;

import com.roadmap.sh.AdvancedTrackerApi.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService
        implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String id) {

        UUID uuid = UUID.fromString(id);

        return userRepo.findById(uuid)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));
    }
}
