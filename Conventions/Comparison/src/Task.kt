data class MyDate(
    val year: Int,
    val month: Int,
    val dayOfMonth: Int) : Comparable<MyDate> {

    override fun compareTo(other: MyDate): Int {
        return when {
            year != other.year -> this.year - other.year
            month != other.month -> this.month - other.month
            else -> dayOfMonth - other.dayOfMonth
        }

    }
}

fun test(date1: MyDate, date2: MyDate) {
    // this code should compile:
    println(date1 < date2)
}
