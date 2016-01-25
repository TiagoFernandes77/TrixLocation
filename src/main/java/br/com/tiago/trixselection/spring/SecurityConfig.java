package br.com.tiago.trixselection.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.POST, "/**").authenticated()
				.antMatchers(HttpMethod.PUT, "/**").authenticated()
				.antMatchers(HttpMethod.DELETE, "/**").authenticated()
				.anyRequest().permitAll().and().httpBasic().and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password")
				.roles("USER").and().withUser("admin").password("password")
				.roles("USER", "ADMIN");
	}

	// Expose the UserDetailsService as a Bean
	@Bean
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}
}