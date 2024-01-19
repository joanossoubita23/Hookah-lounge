package com.hookah.demo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {
    public final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.cors(Customizer.withDefaults())
                .csrf(c->c.disable())
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(
                        auth->auth.requestMatchers(HttpMethod.GET,"api/v1/hookah/*").hasAnyRole("USER","ADMIN")
                                .requestMatchers(HttpMethod.POST,"api/v1/hookah/*").hasRole("ADMIN")
                                .anyRequest()
                                .authenticated()
                )
                .build();
    }
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());

    }




//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails admin= User.builder()
//                .username("admin")
//                .password(bCryptPasswordEncoder().encode("adminPass"))
//                .roles("ADMIN")
//                .build();
//        var user=User.builder()
//                .username("user")
//                .password(bCryptPasswordEncoder().encode("UserPass"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user,admin);

    // }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }

}

