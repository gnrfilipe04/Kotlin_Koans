class DateRange(val start: MyDate, val end: MyDate) {
    operator fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var current = start

            override fun hasNext(): Boolean {
                return current <= end
            }

            override fun next(): MyDate {
                val result = current
                current = current.followingDate()
                return result
            }
        }

    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}