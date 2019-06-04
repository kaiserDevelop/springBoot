package com.openlegacy.inventory.ExceptionRest;

/**
 * Implements expetion
 * @author César Villalba Visuet
 * @version 1.0
 * @since 1.0
 *
 */
public class InventoryNotFoundException extends RuntimeException {

    public InventoryNotFoundException(Long id) {
        super("Could not find inventory " + id);
    }
}
