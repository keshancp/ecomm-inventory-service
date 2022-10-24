package com.ecomm.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ecomm.inventoryservice.model.Inventory;
import com.ecomm.inventoryservice.repository.InventoryRepository;

@SpringBootApplication
public class EcommInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommInventoryServiceApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
//		
//		return args->{
//			Inventory inventory=new Inventory();
//			inventory.setItemCode("Iphone_13");
//			inventory.setQuantity(20);
//			
//			Inventory inventory2=new Inventory();
//			inventory2.setItemCode("Iphone_14");
//			inventory2.setQuantity(10);
//			
//			inventoryRepository.save(inventory);
//			inventoryRepository.save(inventory2);
//		};
//	}
	
}
