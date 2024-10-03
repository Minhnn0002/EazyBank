package com.eazycode.springsecuritybasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) ->
                requests.requestMatchers("/myAccount","/myLoans","/myBalance","/myCards").authenticated()
                        .requestMatchers("/notices","/contact").permitAll()
                /*Deny all request*/
//                requests.anyRequest().denyAll()
                /*permit all request*/
//                requests.anyRequest().permitAll()

        );
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
}
