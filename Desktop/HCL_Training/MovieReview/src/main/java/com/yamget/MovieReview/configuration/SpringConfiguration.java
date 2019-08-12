package com.yamget.MovieReview.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan
@PropertySource("classpath:application.properties")
public class SpringConfiguration {
	
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
		
	@Bean
	public ViewResolver viewResolver(){
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/pages/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
 
        return dataSource;
    }
	
	@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.yamget.MovieReview.Model");
        sessionFactory.setHibernateProperties(hibernateProperties());
 
        return sessionFactory;
    }
	
	@Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
 
    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        //hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");        
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.put("hibernate.show_sql", false);
        return hibernateProperties;
    }
    
//    @Bean
//   	public PasswordEncoder passwordEncoder(){
//   		PasswordEncoder encoder = new BCryptPasswordEncoder();
//   		return encoder;
//   	}
	
//	private Properties getHibernateProperties(){
//		Properties properties = new Properties();
//		properties.put("hibernate.show_sql", false);
//		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//		return properties;
//	}	
//	@Bean
//	public AnnotationSessionFactoryBean sessionFactory(){
//		AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource());
//		sessionFactory.setPackagesToScan(new String[]{"com.fidel.sms.model"});
//		sessionFactory.setHibernateProperties(getHibernateProperties());
//		return sessionFactory;
//	}	
//	@Autowired
//	@Bean(name = "transactionManager")
//	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//		transactionManager.setSessionFactory(sessionFactory);
//		return transactionManager;
//	}
}
