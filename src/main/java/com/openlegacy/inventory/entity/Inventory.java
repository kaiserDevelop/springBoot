package com.openlegacy.inventory.entity;

import lombok.Data;
import javax.persistence.*;

/**
 * Represents an Inventory.
 * @author César Villalba Visuet
 * @version 1.0
 * @since 1.0
 *
 */
@Data
@Entity
@Table(name="INVENTORY")
public class Inventory  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="NAME")
    private String name;
    @Column(name="AMOUNT")
    private Integer amount;
    @Column(name="INVENTORY_CODE")
    private String inventoryCode;

    public Inventory() { this(null, null, null);}

    /**
     * Creates an Inventory entity
     * @param name
     * @param amount
     * @param inventoryCode
     */
    public Inventory(String name, Integer amount, String inventoryCode) {
        this.name = name;
        this.amount = amount;
        this.inventoryCode = inventoryCode;
    }

    /**
     * Gets id
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name
     *
     * @param name of inventory
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *  Gets amount
     *
     * @return the amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * Sets mount
     *
     * @param amount of inventory
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * Gets inventaryCode
     *
     * @return the inventary code
     */
    public String getInventoryCode() {
        return inventoryCode;
    }

    /**
     *  Sets inventaryCode
     *
     * @param inventoryCode
     */
    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }
}
