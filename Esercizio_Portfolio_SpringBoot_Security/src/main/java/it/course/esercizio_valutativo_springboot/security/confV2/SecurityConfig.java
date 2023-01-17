package it.course.esercizio_valutativo_springboot.security.confV2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {

        UserDetails user1 = User.withUsername("user1")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build();

        UserDetails user2 = User.withUsername("user2")
                .password(passwordEncoder.encode("password"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .clearAuthentication(true)
                .logoutSuccessUrl("/login")
                .deleteCookies()
                .invalidateHttpSession(true)
                .and()
                .authorizeRequests()
                .requestMatchers("/createProject/**").access("hasAnyRole('ADMIN', 'USER')")
                .requestMatchers("/deleteProject/**").access("hasAnyRole('ADMIN', 'USER')")
                .requestMatchers("/createSkill/**").hasRole("ADMIN")
                .requestMatchers("/deleteSkill/**").hasRole("ADMIN")
                .requestMatchers("/createCategory/**").hasRole("ADMIN")
                .requestMatchers("/deleteCategory/**").hasRole("ADMIN")
                // .requestMatchers("/admin/**")
                // .authenticated()
                // .requestMatchers("/")
                // .permitAll()
                .and()
                .httpBasic();
        return http.build();
    }
}


