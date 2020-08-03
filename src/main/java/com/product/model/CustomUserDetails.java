package com.product.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails extends Users implements UserDetails {

	static {
		
		System.out.println("CustomUserDetails.enclosing_method()");
	}
    public CustomUserDetails(final Users users) {
        super(users);
        System.out.println("CustomUserDetails.CustomUserDetails() con");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

    	System.out.println("CustomUserDetails.getAuthorities() getauth");
    	
        return getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getEmailId();
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
