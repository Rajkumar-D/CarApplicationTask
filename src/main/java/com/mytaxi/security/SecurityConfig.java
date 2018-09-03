package com.mytaxi.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Adding security configuration for the REST API. The password is encoded using bcrypt endoder.
 * @author rajkumar
 *
 */

@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    protected void configure(AuthenticationManagerBuilder auth)
        throws Exception
    {
        auth.inMemoryAuthentication()
            .passwordEncoder(new BCryptPasswordEncoder())
            .withUser("user").password("$2a$04$PQH/bewBNgOmxjGy4jGi6un8PDjWfHKjOM1SVW4BXFuim8B/DA8hi").roles("USER");

    }


    protected void configure(HttpSecurity security) throws Exception
    {
        security.httpBasic().and().authorizeRequests()
            .antMatchers("/**").hasRole("USER").and().csrf().disable().headers().frameOptions().disable();
    }
}
