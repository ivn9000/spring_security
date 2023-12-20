package com.nannya.app_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //DEFAULT CONFIGURATION
        /*
        http.authorizeHttpRequests(auth ->
                auth.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
         */
        //CUSTOM CONFIGURATION FOR NANNYA
        http.authorizeHttpRequests(auth ->
                        auth.requestMatchers("/loans","/cards","/accounts","/balance" ).authenticated()
                                .anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());


        return http.build();
    }
}
