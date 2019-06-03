package com.openlegacy.inventory;

import com.openlegacy.inventory.Repository.InventoryRepository;
import com.openlegacy.inventory.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.boot.CommandLineRunner;

@EnableSwagger2
@SpringBootApplication
public class InventoryApplication implements CommandLineRunner{

	@Autowired
	private InventoryRepository inventoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

	@Override
	public void run(String... args) {
		inventoryRepository.save(new Inventory("Jabon",10,"4567889"));
		inventoryRepository.save(new Inventory("Atun",120,"9086532"));
		inventoryRepository.save(new Inventory("Pan integral",8,"1264321"));
		inventoryRepository.save(new Inventory("Mermelada",16,"6754321"));
	}

}
