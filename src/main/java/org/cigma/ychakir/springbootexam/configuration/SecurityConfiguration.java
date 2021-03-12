package org.cigma.ychakir.springbootexam.configuration;

import lombok.RequiredArgsConstructor;
import org.cigma.ychakir.springbootexam.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final UserService userService;

  public static void main(String[] args) {
    System.out.println(new BCryptPasswordEncoder().encode("clientpass"));
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/passport/**").permitAll()
        .antMatchers("/passport/change-password").authenticated()
        .antMatchers("/home").hasAnyAuthority("ADMIN", "CLIENT")
        .anyRequest().authenticated().and()
        .csrf().disable()
        .formLogin().loginPage("/passport/login")
        .failureUrl("/passport/login?error=true")
        .defaultSuccessUrl("/articles/search")
        .usernameParameter("username")
        .passwordParameter("password").and()
        .logout().logoutRequestMatcher(new AntPathRequestMatcher("/passport/logout"))
        .logoutSuccessUrl("/").and()
        .exceptionHandling().accessDeniedPage("/access-denied");
  }

  @Override
  public void configure(WebSecurity web) {
    web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}