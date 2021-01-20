package pl.piomin.microservices.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(WebSecurityConfiguration.class, args);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        List<UserDetails> userDetails = new ArrayList<>();
        List<SimpleGrantedAuthority> userAuthorities = new ArrayList<>();
        userAuthorities.add(new SimpleGrantedAuthority("USER"));
        User user =  new User("user",passwordEncoder().encode("secret"),userAuthorities);
        List<SimpleGrantedAuthority> adminAuthorities = new ArrayList<>();
        adminAuthorities.add(new SimpleGrantedAuthority("USER"));
        User userAdmin =  new User("admin",passwordEncoder().encode("secret"),adminAuthorities);
//                UserDetails user= User.builder().username("user").password(passwordEncoder().encode("secret")).
//                roles("USER").build();
//        UserDetails userAdmin=User.builder().username("admin").password(passwordEncoder().encode("secret")).
//                roles("ADMIN").build();
        userDetails.add(user);
        userDetails.add(userAdmin);
        return new InMemoryUserDetailsManager(userDetails);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/index","/webpublico").permitAll()
                .antMatchers("/webprivado").authenticated()
                .antMatchers("/webadmin").hasRole("ADMIN").and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout() // Metodo get pues he desabilitado CSRF
                .permitAll();
    }

}