package ArrayListExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<>();

        // Creating three Product objects and adding them to the ArrayList
        Product product1 = new Product(1, "Product A", 19.99);
        Product product2 = new Product(2, "Product B", 7.49);
        Product product3 = new Product(3, "Product C", 12.99);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        // Iterating through the elements of the ArrayList
        System.out.println("Elements of the ArrayList:");
        for (Product product : productList)
            System.out.println("ID: " + product.getId() + ", Name: " + product.getName() + ", Price: " + product.getPrice());

        // Sorting the ArrayList in increasing order of price using a Comparator
        Collections.sort(productList, Comparator.comparingDouble(Product::getPrice));

        // Displaying the elements of the ArrayList in increasing order of price
        System.out.println("\nElements of the ArrayList in increasing order of price:");
        for (Product product : productList)
            System.out.println("ID: " + product.getId() + ", Name: " + product.getName() + ", Price: " + product.getPrice());
    }

}