package Boot.Util;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan({ "Boot.Controller", "Boot.DAO", "Boot.Service", "Boot.TO", "Boot.Util" })
public class JLCAppConfig implements WebMvcConfigurer {

	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		System.out.println("---------------------JLCAPpConfig ViewResolver -----------");
		return viewResolver;
	}

	@Bean
	public LocalSessionFactoryBean getSession(DataSource myds) {

		Properties props = new Properties();
		props.put("hibernate.show_sql", "true");
		props.put("org.hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.use_sql_comments", "true");

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setHibernateProperties(props);
		sessionFactory.setDataSource(myds);
		sessionFactory.setPackagesToScan("Boot.TO");

		return sessionFactory;
	}

	@Bean
	public HibernateTemplate getHT(SessionFactory sf) {
		return new HibernateTemplate(sf);
	}

	@Bean
	public PlatformTransactionManager getTXManger(SessionFactory sf) {

		return new HibernateTransactionManager(sf);
	}

}
