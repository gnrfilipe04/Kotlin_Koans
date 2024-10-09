import TimeInterval.*
import java.sql.Time

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

data class RepeatedTimeInterval(val timeInterval: TimeInterval, val amount: Int)

operator fun TimeInterval.times(times: Int): RepeatedTimeInterval {
    return RepeatedTimeInterval(this, times)
}

operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval): MyDate {
    return this.addTimeIntervals(repeatedTimeInterval.timeInterval, repeatedTimeInterval.amount)

}

fun task1(today: MyDate): MyDate {
    return today + YEAR * 1 + WEEK * 1
}

fun task2(today: MyDate): MyDate {

    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
