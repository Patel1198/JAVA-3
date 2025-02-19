package ca.sheridancollege.pate2516.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private LoggingAccessDeniedHandler accessDeniedHandler;

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
	.antMatchers("/secure/**").hasRole("USER")
	.antMatchers("/", "/js/**", "/css/**", "/images/**", "/**").permitAll()
	.anyRequest().authenticated()
	.and().formLogin()
	.loginPage("/login").permitAll()
.and().logout()
	.invalidateHttpSession(true)
	.clearAuthentication(true)
	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
.logoutSuccessUrl("/login?logout").permitAll()
.and().exceptionHandling()
.accessDeniedHandler(accessDeniedHandler);


	// a tiny bit more to place here in a few slides
}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.passwordEncoder(NoOpPasswordEncoder.getInstance()) 
		.withUser("frank@frank.com").password("1234").roles("USER")
		.and()
		.withUser("guest@guest.com").password("password").roles("GUEST");
	}

}
