package com.example.securitymastervalidation.security;

import com.example.securitymastervalidation.repository.PersonDao;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final PersonDao personDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return personDao.findPersonByUserName(username).map(SecurityUser::new).orElseThrow(() -> new EntityNotFoundException("userName not found"));
    }
}
