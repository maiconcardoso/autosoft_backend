package br.com.autosoft.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import lombok.extern.log4j.Log4j2;

@EnableWebSecurity
@Log4j2
public class ConfigSecurity extends WebSecurityConfigurerAdapter{

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .and()
            .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        log.info("Password encoded {}", passwordEncoder.encode("test"));
        auth.inMemoryAuthentication()
            .withUser("dosocon")
            .password(passwordEncoder.encode("senha"))
            .roles("USER", "ADMIN")
            .and()
            .withUser("user")
            .password(passwordEncoder.encode("senha"))
            .roles("USER")
            .and();
    }
    

}
