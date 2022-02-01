package br.com.autosoft.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.autosoft.service.UserDetailService;
import lombok.extern.log4j.Log4j2;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true )
@Log4j2
public class ConfigSecurity extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailService detailService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
            .authorizeRequests()
            .antMatchers("/*/auth/admin/**").hasRole("ADMIN")
            .antMatchers("/*/auth/**").hasAnyRole("ADMIN", "USER")

            .antMatchers("/h2-console/**").permitAll().and()
            .headers().frameOptions().disable().and()
            
            .formLogin()
            .and()
            .httpBasic();
    }

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    //     log.info("Password encoded {}", passwordEncoder.encode("test"));
    //     auth.inMemoryAuthentication()
    //         .withUser("dosocon").password(passwordEncoder.encode("senha")).roles("USER", "ADMIN")
    //         .and()
    //         .withUser("user").password(passwordEncoder.encode("senha")).roles("USER")
    //         .and();
    // }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(detailService).passwordEncoder(new BCryptPasswordEncoder());
    }
    

}
