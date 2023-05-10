package com.pcsgpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.pcsgpl.tc.service.MyUserDetailsService;

//import com.pcsgpl.tc.service.UserDetailsService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{


		@Autowired
		MyUserDetailsService myUserDetailsService;
		
		@Bean
		public AuthenticationProvider authProvider() {
			DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
			provider.setUserDetailsService(myUserDetailsService);
			//provider.setUserDetailsService(userDetailsService);
		    provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());		
			//provider.setPasswordEncoder(new BCryptPasswordEncoder());	
			return provider;
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception{
			http
			.csrf().disable()
			.authorizeRequests().antMatchers("/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login").permitAll()
			.and()
			.logout().invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/logout-success").permitAll();
			
		}
	}
	

