package com.tunadag.config.security;

import com.tunadag.repository.entity.Auth;
import com.tunadag.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtUserDetails implements UserDetailsService {

    @Autowired
    AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserDetails getUserByAuthId(Long authid){
        Optional<Auth> auth = authService.findById(authid);
        if (auth.isEmpty()) return null;
        List<GrantedAuthority> authorities = new ArrayList<>();
        /**
         * Burada belirtilen isimlendirmeler tamamen size aittir. Özel bir kullanım değildir.
         */
        authorities.add(new SimpleGrantedAuthority("USER"));
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        authorities.add(new SimpleGrantedAuthority("EDITOR"));
        authorities.add(new SimpleGrantedAuthority("DICKHEAD"));

        return User.builder()
                .username(authid.toString())
                .password("")
                .accountLocked(false)
                .accountExpired(false)
                .authorities(authorities)
                .build();
    }
}
