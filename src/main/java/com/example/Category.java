package com.example;

public class Category {
    static String name;

    private Category(String categoryName) {

    }

    public static Category of(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Category name cannot be null or empty");
        }
        name = name;

        name = name.substring(0, 1).toUpperCase()
                + name.substring(1).toLowerCase();

        return new Category(name);

    }

    public String getName() {
        return name;
    }

}

/*
Cache/flyweight: return the same instance for the same normalized name.
 */
