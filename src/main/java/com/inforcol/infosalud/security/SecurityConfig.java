package com.inforcol.infosalud.security;

import com.inforcol.infosalud.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.inforcol.infosalud.config.JwtUtils;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Autowired
    private JwtUtils jwtUtils;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests -> authorizeRequests
                .requestMatchers( new AntPathRequestMatcher("swagger-ui/**")).permitAll()
                .requestMatchers( new AntPathRequestMatcher("/swagger-ui/**")).permitAll()
                .requestMatchers( new AntPathRequestMatcher("v3/api-docs/**")).permitAll()
                .requestMatchers( new AntPathRequestMatcher("/v3/api-docs/**")).permitAll()
                .requestMatchers( new AntPathRequestMatcher("/swagger-ui.html")).permitAll()
                .requestMatchers( new AntPathRequestMatcher("/v3/api-docs/swagger-config")).permitAll()
                .requestMatchers( new AntPathRequestMatcher("/api-docs/swagger-config")).permitAll()
                .requestMatchers( new AntPathRequestMatcher("/api-docs/**")).permitAll()
                .requestMatchers( new AntPathRequestMatcher("/api/**")).permitAll()
                .requestMatchers( new AntPathRequestMatcher("/auth/**")).permitAll()
                .anyRequest().authenticated()
        ).addFilterBefore(new JwtTokenValidator(jwtUtils), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailServiceImpl userDetailService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailService);
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}