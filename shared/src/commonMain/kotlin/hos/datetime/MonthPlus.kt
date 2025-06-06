package hos.datetime

import kotlinx.datetime.Month

/**
 * <p>Title: MonthPlus </p>
 * <p>Description:  </p>
 *
 * @author : 蔡俊峰
 * @date : 2025-06-03 8:51
 * @version : 1.0
 */

fun Month.daysInMonth(year: Int): Int {
    return when (this) {
        Month.JANUARY -> 31
        Month.FEBRUARY -> if (DateTime.isLeapYear(year)) 29 else 28
        Month.MARCH -> 31
        Month.APRIL -> 30
        Month.MAY -> 31
        Month.JUNE -> 30
        Month.JULY -> 31
        Month.AUGUST -> 31
        Month.SEPTEMBER -> 30
        Month.OCTOBER -> 31
        Month.NOVEMBER -> 30
        Month.DECEMBER -> 31
        else -> 31
    }
}

fun Month.milliseconds(year: Int): Long {
    return daysInMonth(year) * 24 * 60 * 60 * 1000L
}

fun Month.microsecond(year: Int): Long {
    return daysInMonth(year) * 24 * 60 * 60 * 1000L * 1000L
}

fun Month.nanosecond(year: Int): Long {
    return daysInMonth(year) * 24 * 60 * 60 * 1000L * 1000L * 1000L
}
