package ch.erard22.mysecondhand.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
public class MySecondHandCustomerServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(MySecondHandCustomerServiceApplication.class, args);
	}
}
