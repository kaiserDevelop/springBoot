package com.openlegacy.inventory;

import com.openlegacy.inventory.Repository.InventoryRepository;
import com.openlegacy.inventory.entity.Inventory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InventoryApplicationTests {


	@Test
	public void readItemDetails() {}
/*
	@Test
	public void readItemDetails() {
		Inventory result = inventoryRepository.findById(productOne.getId()).get();
		assertThat(result.getId(), is(productOne.getId()));
	}

	@Test
	public void updateQuantity() {
		final Integer newAmount = 999;
		Optional<Inventory> item = inventoryRepository.findById(productThree.getId());
		item.get().setAmount(newAmount);
		Inventory product = inventoryRepository.save(item.get());
		assertThat(product.getAmount(), is(newAmount));
	}

	@Test
	public void deleteItem() {
		Optional<Inventory>  item = inventoryRepository.findById(productFour.getId());
		inventoryRepository.delete(item.get());
		Inventory result = inventoryRepository.findById(item.get().getId()).get();
		assertThat(result, is(nullValue()));
	}

*/
}
