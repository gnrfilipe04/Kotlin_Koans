// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? {
    val productsDelivered = customer.getOrderedProducts()
    return productsDelivered.maxByOrNull { it.price }
}

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers
        .flatMap { it.orders }.count { it.products.any { pdc -> pdc == product } }
}

fun Customer.getOrderedProducts(): List<Product> =
        orders.filter { it.isDelivered }.flatMap { it.products }
