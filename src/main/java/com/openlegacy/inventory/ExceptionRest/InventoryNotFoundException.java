package com.openlegacy.inventory.ExceptionRest;

public class InventoryNotFoundException extends RuntimeException {

    public InventoryNotFoundException(Long id) {
        super("Could not find inventory " + id);
    }
}
