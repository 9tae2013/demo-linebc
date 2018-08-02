package com.example.demo;

import com.example.demo.domain.Department;
import com.example.demo.employee.DepartmentRepository;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner, Jackson2ObjectMapperBuilderCustomizer {
    @Autowired
    private DepartmentRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Department dep = new Department();
        dep.setName("Innovation");
        repository.save(dep);
        System.out.println("Create >>> " + dep);
    }

    @Override
    public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
        jacksonObjectMapperBuilder.modules(new Hibernate5Module());
    }

}
