package com.example.ItemLists;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories("com.example.ItemLists.repository")
//@EntityScan("com.example.ItemLists.model")
@EnableAutoConfiguration
@SpringBootApplication
public class ItemListsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemListsApplication.class, args);
	}

}
