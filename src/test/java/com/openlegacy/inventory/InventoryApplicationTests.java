package com.openlegacy.inventory;

import com.openlegacy.inventory.Repository.InventoryRepository;
import com.openlegacy.inventory.entity.Inventory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InventoryApplicationTests {

	@Autowired
	private InventoryRepository inventoryRepository;

	private Inventory inventoryOne, inventoryTwo, inventoryThree, inventoryFour;

	@Before
	public void loadInvetoryData() {
		inventoryOne = new Inventory("Jabon",10,"4567889");
		inventoryTwo = new Inventory("Atun",120,"9086532");
		inventoryThree = new Inventory("Pan integral",8,"1264321");
		inventoryFour = new Inventory("Mermelada",16,"6754321");

		inventoryRepository.save(inventoryOne);
		inventoryRepository.save(inventoryTwo);
		inventoryRepository.save(inventoryThree);
		inventoryRepository.save(inventoryFour);
	}


	@Test
	public void readItemDetails() {
		Inventory result = inventoryRepository.findById(inventoryOne.getId()).get();
		assertThat(result.getId(), is(inventoryOne.getId()));
	}

	@Test
	public void updateQuantity() {
		final Integer newAmount = 999;
		Inventory item = inventoryRepository.findById(inventoryThree.getId()).get();
		item.setAmount(newAmount);
		Inventory product = inventoryRepository.save(item);
		assertThat(product.getAmount(), is(newAmount));
	}

	@Test
	public void deleteItem() {
		Optional<Inventory> item = inventoryRepository.findById(inventoryFour.getId());
		inventoryRepository.delete(item.get());
		Optional<Inventory> result = inventoryRepository.findById(inventoryFour.getId());
		assertThat(result.isPresent(), is(false));
	}


	@Test
	public void insertItem() {
		Inventory inventoryTest = new Inventory("Nuevo",1776,"SAEWE655465");
		inventoryRepository.save(inventoryTest);
		Optional<Inventory> item = inventoryRepository.findById(inventoryTest.getId());
		assertThat(item.isPresent(), is(true));
	}
}
