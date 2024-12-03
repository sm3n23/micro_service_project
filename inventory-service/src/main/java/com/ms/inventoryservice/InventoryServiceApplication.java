package com.ms.inventoryservice;

import com.ms.inventoryservice.Entity.Inventory;
import com.ms.inventoryservice.Repository.InventoryRepository;
import com.ms.inventoryservice.Service.InventoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory1= new Inventory();
			inventory1.setSkuCode("iphone");
			inventory1.setQuantity(10);

			Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("tv");
			inventory2.setQuantity(10);

			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);

		};
	}

}
