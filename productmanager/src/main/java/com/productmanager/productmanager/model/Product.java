package com.productmanager.productmanager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
public class Product implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String ean;
    private String description;
    private String type;
    private String generation;
    private String supplier;
    private String purchasePrice;
    private String resellerPrice;
//    @Column(nullable = false, updatable = false)
//    private String productCode;

    public Product() {}

    public Product(String ean, String description, String type, String generation, String supplier, String purchasePrice, String resellerPrice)
    {
        this.ean = ean;
        this.description = description;
        this.type = type;
        this.generation = generation;
        this.supplier = supplier;
        this.purchasePrice = purchasePrice;
        this.resellerPrice = resellerPrice;
 //       this.productCode = productCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getResellerPrice() {
        return resellerPrice;
    }

    public void setResellerPrice(String resellerPrice) {
        this.resellerPrice = resellerPrice;
    }

//    public String getProductCode(){
//        return productCode;
//    }
//
//    public void setProductCode(String productCode){
//        this.productCode = productCode;
//    }



    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", ean='" + ean + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", generation='" + generation + '\'' +
                ", supplier='" + supplier + '\'' +
                ", purchasePrice='" + purchasePrice + '\'' +
                ", resellerPrice='" + resellerPrice + '\'' +
                '}';
    }

}
