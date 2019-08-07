package com.openlegacy.inventory.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import java.util.List;
import java.util.stream.Collectors;
import com.openlegacy.inventory.ExceptionRest.InventoryNotFoundException;
import com.openlegacy.inventory.Repository.InventoryRepository;
import com.openlegacy.inventory.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest Controller contains endpoints for api rest inventory.
 * @author César Villalba Visuet
 * @version 1.0
 * @since 1.0
 *
 */
@RestController
@RequestMapping(value = "/api/inventory", produces = "application/json")
public class InventoryController {

    
    @Autowired
    private InventoryRepository  inventoryRepository;
    @Autowired
    private InventoryResourceAssembler assembler;

    /**
     * Get all items from inventory
     *
     * @return list of inventory
     */
    @GetMapping("/records")
    public Resources<Resource<Inventory>> getAllInventory() {
        List<Resource<Inventory>> inventories =  inventoryRepository.findAll()
                .stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(inventories, linkTo(methodOn(InventoryController.class).getAllInventory()).withSelfRel());
    }

    /**
     * Get one item from inventory
     *
     * @param  id inventary
     * @return one inventary json object
     */
    @GetMapping("/records/{id}")
    public Resource<Inventory> readInventoryDetails(@PathVariable Long id) {
        Inventory result = inventoryRepository.findById(id).orElseThrow(() -> new InventoryNotFoundException(id));
        return assembler.toResource(result);
    }

    /**
     * Delete one item from inventory
     *
     * @param id inventary
     * @return message confirm the acction
     */
    @DeleteMapping("/records/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        Inventory result = inventoryRepository.findById(id).orElseThrow(() -> new InventoryNotFoundException(id));
        inventoryRepository.delete(result);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("The record was deleted, id: " + result.getId());
    }

    /**
     * Add a new item in inventory
     *
     * @param inventory json
     * @return the inventary json with the id generated
     */
    @PostMapping("/records")
    public ResponseEntity<Resource<Inventory>> saveInventory(@RequestBody Inventory inventory) {
        Inventory newInventory = inventoryRepository.save(inventory);
        return ResponseEntity
                .created(linkTo(methodOn(InventoryController.class).readInventoryDetails(newInventory.getId())).toUri())
                .body(assembler.toResource(newInventory));
    }

    /**
     * Update the amount for a inventory
     *
     * @param id inventary
     * @param inventory json
     * @return the inventary json with the id updated
     */
    @PutMapping("/records/{id}")
    public ResponseEntity<ResourceSupport> updateInventoryQuantity(@PathVariable Long id, @RequestBody Inventory inventory) {
        Inventory  inventoryResult = inventoryRepository.findById(id).orElseThrow(() -> new InventoryNotFoundException(id));
        if(inventory.getAmount() != null && inventory.getAmount() >= 0) {
            inventoryResult.setAmount(inventory.getAmount());
            return ResponseEntity.ok(assembler.toResource(inventoryRepository.save(inventoryResult)));
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new VndErrors.VndError("Invalid Amount value","The Amount value must be no not null and equal to or greater than 0"));
    }
}
