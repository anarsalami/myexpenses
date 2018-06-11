package com.bsptechs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
  
    ;
  
  @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/login**").permitAll()
                .and().authorizeRequests().antMatchers("/sign**").permitAll()
                .and().authorizeRequests().antMatchers("/users").hasAuthority("ADMIN")
                .and().authorizeRequests().antMatchers("/authorises").hasAuthority("ADMIN")
                .and().authorizeRequests().antMatchers("/types").hasAnyAuthority("USER","ADMIN")
                .and().authorizeRequests().antMatchers("/categories").hasAnyAuthority("USER","ADMIN")
                .and().authorizeRequests().antMatchers("/expenses").hasAnyAuthority("USER","ADMIN")
                .and().authorizeRequests().anyRequest().hasAnyAuthority("ADMIN", "USER")
                .and().formLogin().permitAll()
                .and().logout().logoutSuccessUrl("/login").permitAll();
//                .and().csrf().();
    }
}
