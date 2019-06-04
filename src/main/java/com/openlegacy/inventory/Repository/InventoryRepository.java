package com.openlegacy.inventory.Repository;

import com.openlegacy.inventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Repository for persist data.
 * @author César Villalba Visuet
 * @version 1.0
 * @since 1.0
 *
 */
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
