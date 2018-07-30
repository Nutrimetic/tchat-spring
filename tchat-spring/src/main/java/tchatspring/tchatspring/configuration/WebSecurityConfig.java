package tchatspring.tchatspring.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user1 =
             User.withDefaultPasswordEncoder()
                .username("1")
                .password("password")
                .roles("USER")
                .build();
        
        UserDetails user2 =
                User.withDefaultPasswordEncoder()
                   .username("2")
                   .password("password")
                   .roles("ADMIN")
                   .build();
        
        UserDetails user3 =
                User.withDefaultPasswordEncoder()
                   .username("3")
                   .password("password")
                   .roles("USER")
                   .build();
        
        List<UserDetails> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        return new InMemoryUserDetailsManager(users);
    } 
	
	//on configure les accès au niveau des routes
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                //.antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                //.loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
}
