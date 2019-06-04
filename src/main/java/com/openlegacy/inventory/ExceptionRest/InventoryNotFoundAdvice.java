package com.openlegacy.inventory.ExceptionRest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Send a 404 back to client
 * @author César Villalba Visuet
 * @version 1.0
 * @since 1.0
 *
 */
@ControllerAdvice
public class InventoryNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(InventoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String inventoryNotFoundHandler(InventoryNotFoundException ex) {
        return ex.getMessage();
    }
}
