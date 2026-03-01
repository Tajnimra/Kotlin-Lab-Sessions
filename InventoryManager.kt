import java.util.*;

class Item<T> {
    int id;
    String name;
    T category;
    double price;
    int stock;

    Item(int id, String name, T category, double price, int stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }
}

public class Main {

    public static <T> void displayItems(List<Item<T>> items) {
        System.out.println("-----------------------------------");
        for (Item<T> item : items) {
            System.out.println("ID: " + item.id);
            System.out.println("Name: " + item.name);
            System.out.println("Category: " + item.category);
            System.out.println("Price: " + item.price);
            System.out.println("Stock: " + item.stock);
            System.out.println("-----------------------------------");
        }
    }

    public static <T> List<Item<T>> filterInStock(List<Item<T>> items) {
        List<Item<T>> result = new ArrayList<>();
        for (Item<T> item : items) {
            if (item.stock > 0) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T> List<Item<T>> filterByCategory(List<Item<T>> items, T category) {
        List<Item<T>> result = new ArrayList<>();
        for (Item<T> item : items) {
            if (item.category.equals(category)) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T> Map<T, Double> computeCategoryTotals(List<Item<T>> items) {
        Map<T, Double> totals = new HashMap<>();

        for (Item<T> item : items) {
            double totalValue = item.price * item.stock;
            totals.put(item.category,
                    totals.getOrDefault(item.category, 0.0) + totalValue);
        }

        return totals;
    }

    public static void main(String[] args) {

        List<Item<String>> inventory = new ArrayList<>();

        inventory.add(new Item<>(1, "Laptop", "Electronics", 60000.0, 5));
        inventory.add(new Item<>(2, "Mouse", "Electronics", 500.0, 0));
        inventory.add(new Item<>(3, "Chair", "Furniture", 2500.0, 10));
        inventory.add(new Item<>(4, "Table", "Furniture", 7000.0, 2));
        inventory.add(new Item<>(5, "Pen", "Stationery", 20.0, 100));

        System.out.println("All Items:");
        displayItems(inventory);

        System.out.println("Items In Stock:");
        displayItems(filterInStock(inventory));

        System.out.println("Electronics Category:");
        displayItems(filterByCategory(inventory, "Electronics"));

        System.out.println("Category Totals:");
        Map<String, Double> totals = computeCategoryTotals(inventory);
        for (String category : totals.keySet()) {
            System.out.println(category + " -> " + totals.get(category));
        }
    }
}
