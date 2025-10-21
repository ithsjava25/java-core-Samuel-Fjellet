package com.example;

import java.math.BigDecimal;
import java.util.*;

public class Warehouse {
    List<Product> products;
    List<Shippable> shippables;
    List<Perishable> perishables;
    static HashMap<String, Warehouse> warehouses = new HashMap<>();

    private Warehouse() {
        this.products = new ArrayList<>();
        this.shippables = new ArrayList<>();
        this.perishables = new ArrayList<>();

    }

    public List<Product> getProducts(){
        return Collections.unmodifiableList(products);
    }

    public List<Shippable> shippableProducts() {
        return shippables;
    }

    public void clearProducts(){
        products.clear();
        Category.categories.clear();
        shippables.clear();
    }

    public boolean isEmpty(){
        return products.isEmpty();
    }

    public void addProduct(Product product){
        if (product == null)
            throw new IllegalArgumentException("Product cannot be null.");
        if (getProductById(product.uuid).isPresent())
            throw new IllegalArgumentException("Product with that id already exists, use updateProduct for updates.");
        products.add(product);
        if(product instanceof Shippable)
            shippables.add((Shippable) product);
        if(product instanceof Perishable)
            perishables.add((Perishable) product);
    }

    public void remove(UUID id){
        products.removeIf(product -> product.uuid == id);
    }

    public Optional<Product> getProductById(UUID id){
       if (products.isEmpty())
           return Optional.empty();

        return products.stream()
                .filter(p -> p.uuid == id)
                .findFirst();


    }

    public static synchronized Warehouse getInstance(String string) {
        if (!warehouses.containsKey(string)) {
            warehouses.put(string, new Warehouse());
        }
        return warehouses.get(string);
    }

    public static synchronized Warehouse getInstance() {
        if(!warehouses.containsKey("default"))
            warehouses.put("default", new  Warehouse());
        return warehouses.get("default");
    }

    public Map<Category, List<Product>> getProductsGroupedByCategories() {
        if(products == null || products.isEmpty()){
            return Collections.emptyMap();
        }

        HashMap<Category, List<Product>> result = new HashMap<>();

        var tempMap = Category.categories.entrySet();

        for(var category : tempMap){
            List<Product> tempList = new ArrayList<>();

            products.stream()
                    .filter(element -> element.category.equals(category.getValue()))
                    .forEach(tempList::add);

            result.put(category.getValue(), tempList);
        }

        return result;

    }

    public void updateProductPrice(UUID id, BigDecimal newPrice){

        var product = getProductById(id);

        if(product.isPresent())
            product.get().setPrice(newPrice);
        else
            throw new NoSuchElementException("Product not found with id:" + id);


    }

    public List<Perishable> expiredProducts() {
        return perishables.stream()
                .filter(perishable -> perishable.isExpired(perishable))
                .toList();
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
