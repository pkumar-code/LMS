package Boot.Util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import Boot.Service.LeadsService;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class MyBootApplication {
	
	@Autowired
	LeadsService leadsService;
	
	public static void main(String[] args) {
		System.out.println("Main Begin");

		SpringApplication.run(MyBootApplication.class, args);

		System.out.println("Main End");
	}

	

	
}
