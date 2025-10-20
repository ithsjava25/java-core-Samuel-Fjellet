package com.example;

import java.math.BigDecimal;
import java.util.*;

public class Warehouse {
    List<Product> products;
    List<Shippable> shippables;

    private static Warehouse single_instance = null;
    public String instanceName;

    public List<Product> getProducts(){
        return products;
    }

    public List<Shippable> shippableProducts() {
        return shippables;
    }

    public void clearProducts(){
        products.clear();
    }

    public boolean isEmpty(){
        return products.isEmpty();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void remove(UUID id){
        for(Product product : products){
            if (product.uuid == id)
                products.remove(product);
        }
    }

    public Optional<Product> getProductById(UUID id){
       var temp = products.stream()
               .filter(product -> product.uuid == id)
               .findFirst()
               .isEmpty();

       if(temp){
           return Optional.empty();
       } else {
           return Optional.empty();
       }
    }

    public static synchronized Warehouse getInstance(String string) {
        if (single_instance == null) {
            single_instance = new Warehouse();
        }
        return single_instance;
    }


    public Map<Product, Category> getProductsGroupedByCategories() {
        if(products == null || products.isEmpty()){
            return Collections.emptyMap();
        }
       return Collections.emptyMap();
    }

    public void updateProductPrice(UUID id, BigDecimal newPrice){
        for(Product product : products){
            if (product.uuid == id){

            }
        }
    }

    public List<Perishable> expiredProducts() {
        return null;
    }
}

/*
getInstance(String name) returns the same instance per unique name.
addProduct(Product): throw IllegalArgumentException("Product cannot be null.") if null.
getProducts(): return an unmodifiable copy.
getProductById(UUID): return Optional.
updateProductPrice(UUID, BigDecimal): when not found, throw NoSuchElementException("Product not found with id: "). Also track changed products in getChangedProducts().
expiredProducts(): return List that are expired.
shippableProducts(): return List from stored products.
remove(UUID): remove the matching product if present.
 */
