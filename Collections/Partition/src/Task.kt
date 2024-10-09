// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer>{
    val (moreUndelivered, _) = this.customers.partition { customer ->
        val deliveredOrders = customer.orders.count { it.isDelivered }
        val undeliveredOrders = customer.orders.count { !it.isDelivered }

        undeliveredOrders > deliveredOrders
    }

    return moreUndelivered.toSet()
}
