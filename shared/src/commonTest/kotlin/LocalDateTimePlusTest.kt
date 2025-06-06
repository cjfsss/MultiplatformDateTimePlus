import hos.datetime.*
import kotlinx.datetime.*
import kotlin.test.*

/**
 * <p>Title: LocalDateTimePlusTest </p>
 * <p>Description:  </p>
 * <p>Company: www.mapuni.com </p>
 *
 * @author : 蔡俊峰
 * @date : 2025-06-06 9:49
 * @version : 1.0
 */
class LocalDateTimePlusTest {

    @Test
    fun testAllLocalDateTimeExtensions() {
        val now = LocalDateTime.now()
        val timeZone = TimeZone.currentSystemDefault()

        // 1. set 方法
        val dtSetYear = now.set(2023, DateTimeUnit.YEAR)
        assertEquals(2023, dtSetYear.year)

        val dtSetMonth = now.set(5, DateTimeUnit.MONTH)
        assertEquals(5, dtSetMonth.monthNumber)

        val dtSetDay = now.set(10, DateTimeUnit.DAY)
        assertEquals(10, dtSetDay.dayOfMonth)

        val dtSetHour = now.set(14, DateTimeUnit.HOUR)
        assertEquals(14, dtSetHour.hour)

        val dtSetMinute = now.set(30, DateTimeUnit.MINUTE)
        assertEquals(30, dtSetMinute.minute)

        val dtSetSecond = now.set(45, DateTimeUnit.SECOND)
        assertEquals(45, dtSetSecond.second)

        // 2. add / subtract 方法
        val tomorrow = now.add(1, DateTimeUnit.DAY)
        assertEquals(now.dayOfMonth + 1, tomorrow.dayOfMonth)

        val yesterday = now.subtract(1, DateTimeUnit.DAY)
        assertEquals(now.dayOfMonth - 1, yesterday.dayOfMonth)

        val nextHour = now.add(1, DateTimeUnit.HOUR)
        assertEquals(now.hour + 1, nextHour.hour)

        val lastHour = now.subtract(1, DateTimeUnit.HOUR)
        assertEquals(now.hour - 1, lastHour.hour)

        val nextMonth = now.add(1, DateTimeUnit.MONTH)
        val expectedNextMonth = if (now.monthNumber == 12) 1 else now.monthNumber + 1
        assertEquals(expectedNextMonth, nextMonth.monthNumber)

        val lastMonth = now.subtract(1, DateTimeUnit.MONTH)
        val expectedLastMonth = if (now.monthNumber == 1) 12 else now.monthNumber - 1
        assertEquals(expectedLastMonth, lastMonth.monthNumber)

        // 3. toEpochMilliseconds
        val epochMillis = now.toEpochMilliseconds(timeZone)
        assertNotNull(epochMillis)

        // 4. day()
        assertEquals(now.day(), now.dayOfMonth)

        // 5. startDay / endDay
        val startOfDay = now.startDay()
        assertEquals(LocalTime(0, 0, 0), startOfDay.time)

        val endOfDay = now.endDay()
        assertEquals(LocalTime(23, 59, 59), endOfDay.time)

        // 6. startMonth / endMonth
        val startOfMonth = now.startMonth()
        assertEquals(1, startOfMonth.dayOfMonth)

        val endOfMonth = now.endMonth()
        assertTrue(endOfMonth.dayOfMonth >= 28 && endOfMonth.dayOfMonth <= 31)

        // 7. startYear / endYear
        val startOfYear = now.startYear()
        assertEquals(LocalDate(now.year, 1, 1), startOfYear.date)

        val endOfYear = now.endYear()
        assertEquals(LocalDate(now.year, 12, 31), endOfYear.date)

        // 8. startWeek / endWeek
        val startOfWeek = now.startWeek()
        assertEquals(DayOfWeek.MONDAY, startOfWeek.dayOfWeek)

        val endOfWeek = now.endWeek()
        assertEquals(DayOfWeek.SUNDAY, endOfWeek.dayOfWeek)

        // 9. yesterday / tomorrow
        val yesterday1 = now.yesterday()
        assertEquals(
            now.toEpochMilliseconds(timeZone) - 24 * 60 * 60 * 1000,
            yesterday1.toEpochMilliseconds(timeZone)
        )

        val tomorrow1 = now.tomorrow()
        assertEquals(
            now.toEpochMilliseconds(timeZone) + 24 * 60 * 60 * 1000,
            tomorrow1.toEpochMilliseconds(timeZone)
        )

        // 10. isSame / isBefore / isAfter
        val sameTime = now
        assertTrue(now.isSame(sameTime))

        val future = now.addDay(1)
        assertTrue(now.isBefore(future))

        val past = now.subtractDay(1)
        assertTrue(now.isAfter(past))

        // 11. monthSize
        val monthSize = now.monthSize()
        assertTrue(monthSize in 28..31)

        // 12. countMondaysInMonth
        val mondaysCount = now.countMondaysInMonth()
        assertTrue(mondaysCount in 4..5)

        // 13. getWeekFirstDayInMonth
        val firstMondays = now.getWeekFirstDayInMonth()
        assertTrue(firstMondays.isNotEmpty(), "当月应包含至少一个星期一")
        firstMondays.forEach { monday ->
            assertEquals(DayOfWeek.MONDAY, monday.dayOfWeek)
        }

        // 14. countWeeksInMonth
        val weeks = now.countWeeksInMonth()
        println("weeks:$weeks")
        assertTrue(weeks in 4..6)

        // 15. countWeeksMondayInMonth
        val weeksMonday = now.countWeeksMondayInMonth()
        println("weeksMonday:$weeksMonday")
        assertTrue(weeksMonday in 4..6)

        // 16. formatString / format
        val formatted = now.format(DateTimeFormats.Format.FULL)
        println("formatted:$formatted")
        assertNotNull(formatted)

        // 17. parse
        val parsed = LocalDateTime.parse(
            "2023-01-01T00:00:00",
            LocalDateTime.Format {
                year()
                chars("-")
                monthNumber()
                chars("-")
                dayOfMonth()
                chars("T")
                hour()
                chars(":")
                minute()
                chars(":")
                second()
            }
        )
        assertEquals(2023, parsed.year)
        assertEquals(1, parsed.monthNumber)
        assertEquals(1, parsed.dayOfMonth)

        // 18. addYear / addMonth / addDay 等
        val afterAddYear = now.addYear(1)
        assertEquals(now.year + 1, afterAddYear.year)

        val afterAddMonth = now.addMonth(1)
        val expectedMonth = if (now.monthNumber == 12) 1 else now.monthNumber + 1
        assertEquals(expectedMonth, afterAddMonth.monthNumber)

        val afterAddDay = now.addDay(1)
        assertEquals(now.dayOfMonth + 1, afterAddDay.dayOfMonth)

        val afterSubtractDay = now.subtractDay(1)
        assertEquals(now.dayOfMonth - 1, afterSubtractDay.dayOfMonth)

        // 19. yesterdayBefore / tomorrowAfter
        val yesterdayBefore = now.yesterdayBefore()
        assertEquals(
            now.toEpochMilliseconds(timeZone) - 2 * 24 * 60 * 60 * 1000,
            yesterdayBefore.toEpochMilliseconds(timeZone)
        )

        val tomorrowAfter = now.tomorrowAfter()
        assertEquals(
            now.toEpochMilliseconds(timeZone) + 2 * 24 * 60 * 60 * 1000,
            tomorrowAfter.toEpochMilliseconds(timeZone)
        )

        // 20. 其他减法操作
        val subYear = now.subtractYear(1)
        assertEquals(now.year - 1, subYear.year)

        val subMonth = now.subtractMonth(1)
        val expectedSubMonth = if (now.monthNumber == 1) 12 else now.monthNumber - 1
        assertEquals(expectedSubMonth, subMonth.monthNumber)

        val subDay = now.subtractDay(1)
        println("subDay:${subDay.dayOfMonth}")

        val subHour = now.subtractHour(1)
        println("subHour:${subHour.hour}")

        val subMin = now.subtractMinute(1)
        println("subMin:${subMin.minute}")

        val subSec = now.subtractSecond(1)
        println("subSec:${subSec.second}")

        // 21. 特定时间加减
        val subHour1 = now.subtractHour1()
        println("subHour1:${subHour1.hour}")

        val subMin30 = now.subtractMinute30()
        println("subMin30:${subMin30.minute}")

        val subDay30 = now.subtractDay30()
        println("subDay30:${subDay30.dayOfYear}")
        println("subDay30:${now.dayOfYear - 30}")
        assertEquals(now.dayOfYear - 30, subDay30.dayOfYear)

        val subDay7 = now.subtractDay7()
        assertEquals(now.dayOfYear - 7, subDay7.dayOfYear)

        // 22. 格式化与解析
        val formattedNow = LocalDateTime.formatNowString()
        assertNotNull(formattedNow)

        val formattedStart = LocalDateTime.formatNowStringStart()
        assertNotNull(formattedStart)

        val formattedEnd = LocalDateTime.formatNowStringEnd()
        assertNotNull(formattedEnd)

        // 23. 设置内容
        var contentExecuted = false
        LocalDateTime.setContent {
            contentExecuted = true
        }
        assertTrue(contentExecuted)

        // 24. 获取内容
        val result = LocalDateTime.getContent {
            this.year
        }
        assertEquals(now.year, result)

        // 25. 获取当前时间戳
        val currentMillis = LocalDateTime.getNowMills()
        assertNotNull(currentMillis)

        println("✅ 所有 LocalDateTimePlus 方法测试通过！")
    }
}