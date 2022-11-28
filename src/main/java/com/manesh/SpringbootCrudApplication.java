package com.manesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


@SpringBootApplication
public class SpringbootCrudApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootCrudApplication.class, args);
		context.getBean(DispatcherServlet.class).setThrowExceptionIfNoHandlerFound(true);

	}

}
