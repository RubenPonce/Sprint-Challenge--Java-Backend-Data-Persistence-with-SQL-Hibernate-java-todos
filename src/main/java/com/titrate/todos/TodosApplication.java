package com.titrate.todos;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
public class TodosApplication {

    public static void main(String[] args) {
         SpringApplication.run(TodosApplication.class, args);

    }

}
