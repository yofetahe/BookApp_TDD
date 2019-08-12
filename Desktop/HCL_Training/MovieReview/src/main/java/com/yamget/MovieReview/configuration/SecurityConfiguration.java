//package com.yamget.MovieReview.configuration;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
////	@Resource(name = "userDetailService")
////	private UserDetailsService userDetailsService;
//	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	
//	@Autowired
//	private DataSource dataSource;
//	
//	@Value("${}")
//	private String usersQuery;
//	
//	@Value("${}")
//	private String rolesQuery;
//	
//	@Autowired
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth.jdbcAuthentication()
//		.usersByUsernameQuery(usersQuery)
//		.authoritiesByUsernameQuery(rolesQuery)
//		.dataSource(dataSource)
//		.passwordEncoder(bCryptPasswordEncoder);
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf()
//		.requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login"))
//		.and()
//		.authorizeRequests()
//		.antMatchers("/index").hasRole("USER").and().formLogin().defaultSuccessUrl("/index")
//		.loginPage("/login").and().logout().permitAll();
//	}
//
////	@Bean
////	public PasswordEncoder passwordEncoder() {
////		PasswordEncoder encoder = new BCryptPasswordEncoder();
////		return encoder;
////	}
//
////	@Autowired
////	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
////	}
//
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/*.css");
//		web.ignoring().antMatchers("/*.js");
//	}
//
//}
