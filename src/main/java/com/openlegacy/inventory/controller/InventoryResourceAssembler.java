package com.openlegacy.inventory.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import com.openlegacy.inventory.entity.Inventory;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

/**
 * Implements hateoas resource for endpoints.
 * @author César Villalba Visuet
 * @version 1.0
 * @since 1.0
 *
 */
@Component
public class InventoryResourceAssembler implements ResourceAssembler<Inventory, Resource<Inventory>> {

    @Override
    public Resource<Inventory> toResource(Inventory inventory) {
        return new Resource<>(inventory,
            linkTo(methodOn(InventoryController.class).readInventoryDetails(inventory.getId())).withSelfRel(),
            linkTo(methodOn(InventoryController.class).getAllInventory()).withRel("inventories"));
    }
}