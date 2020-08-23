package com.test.emlpoyee.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

import com.test.emlpoyee.config.BeanConfig;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EntityScan({"com.test.emlpoyee.entity"})
@RestController
@Import(BeanConfig.class)
@SpringBootApplication(scanBasePackages={"com.test.emlpoyee"})
@EnableJpaRepositories(basePackages="com.test.emlpoyee.repository")
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
