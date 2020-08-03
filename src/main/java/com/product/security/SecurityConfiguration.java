package com.product.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.product.service.CustomUserDetailsService;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
//@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
           System.out.println("SecurityConfiguration.configure() auth");
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(getPasswordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

    	System.out.println("SecurityConfiguration.configure() http");
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/login1").hasAnyRole("admin")
                .antMatchers("/proceed").hasAnyRole("admin")
                .anyRequest().permitAll()
                .and()
                .formLogin().defaultSuccessUrl("/login1")
                .and().logout().logoutSuccessUrl("/")
                .permitAll();
    }

    private PasswordEncoder getPasswordEncoder() {
    	
    	System.out.println("SecurityConfiguration.getPasswordEncoder() encode");
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        };
    }
}
