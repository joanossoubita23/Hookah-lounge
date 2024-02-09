package com.hookah.demo.security;

import com.hookah.demo.exception.AuthEntrypoint;
import com.hookah.demo.exception.AuthEntrypoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
    @Autowired
    private AuthEntrypoint authEntrypoint;
    @Autowired
    private AuthenticationFilter authenticationFilter;
    @Autowired
    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    // Header ->Authentication : Basic username: password
    //body{
    // id;
    // make"toyota",
    //}
    //crf cross site request forgery(CSRF) attack
    //cors
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//        return http
//                .cors(Customizer.withDefaults())
//                .csrf(c -> c.disable())
//                .authorizeHttpRequests(
//                        auth ->auth.
//                                requestMatchers(HttpMethod.POST,"/login").permitAll()
//                                .anyRequest()
//                                .authenticated())
//                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .exceptionHandling((ex)->ex.authenticationEntryPoint(authEntrypoint))
//
//
//
//                .build();
        return http
                .cors(withDefaults())
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().permitAll())
                .build();
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());}
    @Bean
        CorsConfigurationSource corsConfigurationSource(){
            UrlBasedCorsConfigurationSource source = new
                    UrlBasedCorsConfigurationSource();
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedOrigins(Arrays.asList("*"));
            config.setAllowedMethods(Arrays.asList("*"));
            config.setAllowedHeaders(Arrays.asList("*"));
            config.setAllowCredentials(false);
            config.applyPermitDefaultValues();
            source.registerCorsConfiguration("/**",config);
            return source;


    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
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
