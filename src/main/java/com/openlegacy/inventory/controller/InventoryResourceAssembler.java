package com.openlegacy.inventory.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import com.openlegacy.inventory.entity.Inventory;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

@Component
public class InventoryResourceAssembler implements ResourceAssembler<Inventory, Resource<Inventory>> {

    @Override
    public Resource<Inventory> toResource(Inventory inventory) {
        return new Resource<>(inventory,
            linkTo(methodOn(InventoryController.class).readInventoryDetails(inventory.getId())).withSelfRel(),
            linkTo(methodOn(InventoryController.class).getAllInventory()).withRel("inventories"));
    }
}