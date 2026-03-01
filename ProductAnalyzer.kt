data class Product<T>(
    val id: Int,
    val name: String,
    val category: T,
    val price: Double
)

// Display products neatly
fun <T> displayProducts(products: List<Product<T>>) {
    println("-------------------------------------------------")
    for (product in products) {
        println("ID      : ${product.id}")
        println("Name    : ${product.name}")
        println("Category: ${product.category}")
        println("Price   : %.2f".format(product.price))
        println("-------------------------------------------------")
    }
}

// Apply dynamic discount using higher-order function
fun <T> applyDiscount(
    products: List<Product<T>>,
    discountFunction: (Double) -> Double
): List<Product<T>> {
    return products.map {
        it.copy(price = discountFunction(it.price))
    }
}

// Filter products based on condition
fun <T> filterProducts(
    products: List<Product<T>>,
    condition: (Product<T>) -> Boolean
): List<Product<T>> {
    return products.filter(condition)
}

fun main() {

    val products = listOf(
        Product(1, "Laptop", "Electronics", 60000.0),
        Product(2, "Headphones", "Electronics", 2000.0),
        Product(3, "Chair", "Furniture", 3000.0),
        Product(4, "Pen", "Stationery", 20.0)
    )

    println("Original Products:")
    displayProducts(products)

    // Apply 10% discount dynamically
    val discountedProducts = applyDiscount(products) { price ->
        price * 0.9
    }

    println("\nAfter 10% Discount:")
    displayProducts(discountedProducts)

    // Filter products above 5000
    val premiumProducts = filterProducts(products) { it.price > 5000 }

    println("\nPremium Products (Price > 5000):")
    displayProducts(premiumProducts)
}
