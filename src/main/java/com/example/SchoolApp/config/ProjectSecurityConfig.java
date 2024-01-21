package com.example.SchoolApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/home").authenticated()
                        .requestMatchers("/holidays/**").permitAll()
                        .requestMatchers("/contact").permitAll()
                        .requestMatchers("/saveMsg").permitAll()
                        .requestMatchers("/courses").permitAll()
                        .requestMatchers("/assets/**").permitAll()
                        .anyRequest().authenticated()
                        )
                        .httpBasic(withDefaults());
        return http.build();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsService(){

        UserDetails user = User.withDefaultPasswordEncoder()  //deprecated since insecure for production user.
                .username("user")
                .password("12345")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                            .username("admin")
                             .password("54321")
                             .roles("USER","ADMIN")
                              .build();
        return new InMemoryUserDetailsManager(user,admin);

    }

}
