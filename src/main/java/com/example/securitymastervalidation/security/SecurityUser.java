package com.example.securitymastervalidation.security;

import com.example.securitymastervalidation.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class SecurityUser implements UserDetails {

    private final Person person;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return person.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return person.getPassword();
    }

    @Override
    public String getUsername() {
        return person.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
