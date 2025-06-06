import hos.datetime.DateTime
import hos.datetime.DateTimeFormats
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.DayOfWeek
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * <p>Title: DateTimeTest </p>
 * <p>Description:  </p>
 * <p>Company: www.mapuni.com </p>
 *
 * @author : 蔡俊峰
 * @date : 2025-06-03 20:04
 * @version : 1.0
 */

class DateTimeTest {

    @Test
    fun testDateTimeAllFeatures() {
        // 1. 设置和获取年份
        val dt = DateTime.now().set(2023, DateTimeUnit.YEAR)
        assertEquals(2023, dt.year())

        // 2. 添加和减去日期单位
        val today = DateTime.now()
        val tomorrow = today.add(1, DateTimeUnit.DAY)
        assertEquals(today.addDay(1).day(), tomorrow.day())

        // 3. 转换为Unix时间戳毫秒值
        val dtTimestamp = DateTime(1620000000000L) // 2021-05-01T00:00:00 UTC
        assertEquals(1620000000000L, dtTimestamp.toEpochMilliseconds())

        // 4. 获取年、月、日
        val dtNow = DateTime.now()
        assertEquals(dtNow.year(), dtNow.year())
        assertEquals(dtNow.monthNumber(), dtNow.monthNumber())
        assertEquals(dtNow.day(), dtNow.day())

        // 5. 获取小时、分钟、秒
        assertEquals(dtNow.hour(), dtNow.hour())
        assertEquals(dtNow.minute(), dtNow.minute())
        assertEquals(dtNow.second(), dtNow.second())

        // 6. 获取年份开始日期（1月1日）
        val dtStartYear = dtNow.startYear()
        assertEquals(1, dtStartYear.monthNumber())
        assertEquals(1, dtStartYear.day())

        // 7. 获取月份开始日期（1号）
        val dtStartMonth = dtNow.startMonth()
        assertEquals(1, dtStartMonth.day())

        // 8. 获取星期开始日期（星期一）
        val dtStartWeek = dtNow.startWeek()
        assertEquals(DayOfWeek.MONDAY, dtStartWeek.dayOfWeek())

        // 9. 获取日期开始时间（00:00:00）
        val dtStartDay = dtNow.startDay()
        assertEquals(0, dtStartDay.hour())
        assertEquals(0, dtStartDay.minute())
        assertEquals(0, dtStartDay.second())

        // 10. 获取昨天和明天的日期并验证
        val fixedTime = DateTime.now(1749173037427)
        val yesterday = DateTime.now(1749173037427).yesterday()
        val tomorrowObj = DateTime.now(1749173037427).tomorrow()
//        println("fixedTime:"+yesterday.addDay(1).toEpochMilliseconds())
//        println("tomorrowObj:"+yesterday.addDay(1).toEpochMilliseconds())
        assertEquals(fixedTime.toEpochMilliseconds(), yesterday.addDay(1).toEpochMilliseconds())
        assertEquals(fixedTime.toEpochMilliseconds(), tomorrowObj.subtractDay(1).toEpochMilliseconds())

        // 11. 比较两个时间是否在前后
        val dt1 = DateTime.now()
        val dt2 =  DateTime.now().addDay(1)
        assertEquals(true, dt1.isBefore(dt2))
        assertEquals(true, dt2.isAfter(dt1))

        // 12. 格式化和解析日期
        val dtFormatted = DateTime.now()
        val formatted = dtFormatted.format(DateTimeFormats.Format.FULL)
        val parsed = DateTime.parse(formatted, DateTimeFormats.Format.FULL)
        assertEquals(dtFormatted.year(), parsed.year())
        assertEquals(dtFormatted.monthNumber(), parsed.monthNumber())
        assertEquals(dtFormatted.day(), parsed.day())

        // 13. 将字符串解析为Unix时间戳毫秒值
        val timeStr = "2023-01-01 00:00:00"
        val millis = DateTime.parse2Millis(timeStr, DateTimeFormats.Format.FULL)
        assertEquals(1672502400000L, millis)

        // 14. 判断闰年
        assertEquals(true, DateTime.isLeapYear(2020))
        assertEquals(false, DateTime.isLeapYear(1900))
        assertEquals(true, DateTime.isLeapYear(2000))
    }

    /**
     * 测试设置和获取年份功能
     * 验证在设置特定年份后，DateTime对象的年份是否正确
     */
    @Test
    fun testSetAndGet() {
        val dt = DateTime.now().set(2023, DateTimeUnit.YEAR)
        assertEquals(2023, dt.year())
    }

    /**
     * 测试添加和减去日期单位的功能
     * 验证添加一天后的日期是否正确
     */
    @Test
    fun testAddAndSubtract() {
        val today = DateTime.now()
        val tomorrow = today.add(1, DateTimeUnit.DAY)
        assertEquals(today.addDay(1).day(), tomorrow.day())
    }

    /**
     * 测试转换为Unix时间戳毫秒值的功能
     * 验证特定DateTime对象的Unix时间戳是否正确
     */
    @Test
    fun testToEpochMilliseconds() {
        val dt = DateTime(1620000000000L) // 2021-05-01T00:00:00 UTC
        assertEquals(1620000000000L, dt.toEpochMilliseconds())
    }

    /**
     * 测试获取年、月、日的功能
     * 验证DateTime对象的年、月、日是否正确
     */
    @Test
    fun testYearMonthDay() {
        val dt = DateTime.now()
        assertEquals(dt.year(), dt.year())
        assertEquals(dt.monthNumber(), dt.monthNumber())
        assertEquals(dt.day(), dt.day())
    }

    /**
     * 测试获取小时、分钟、秒的功能
     * 验证DateTime对象的小时、分钟、秒是否正确
     */
    @Test
    fun testHourMinuteSecond() {
        val dt = DateTime.now()
        assertEquals(dt.hour(), dt.hour())
        assertEquals(dt.minute(), dt.minute())
        assertEquals(dt.second(), dt.second())
    }

    /**
     * 测试获取年份开始日期的功能
     * 验证年份开始日期是否为1月1日
     */
    @Test
    fun testStartOfYear() {
        val dt = DateTime.now().startYear()
        assertEquals(1, dt.monthNumber())
        assertEquals(1, dt.day())
    }

    /**
     * 测试获取月份开始日期的功能
     * 验证月份开始日期是否为1号
     */
    @Test
    fun testStartOfMonth() {
        val dt = DateTime.now().startMonth()
        assertEquals(1, dt.day())
    }

    /**
     * 测试获取星期开始日期的功能
     * 验证星期开始日期是否为星期一
     */
    @Test
    fun testStartOfWeek() {
        val dt = DateTime.now().startWeek()
        assertEquals(DayOfWeek.MONDAY, dt.dayOfWeek())
    }

    /**
     * 测试获取日期开始时间的功能
     * 验证日期开始时间是否为0点0分0秒
     */
    @Test
    fun testStartOfDay() {
        val dt = DateTime.now().startDay()
        assertEquals(0, dt.hour())
        assertEquals(0, dt.minute())
        assertEquals(0, dt.second())
    }

    /**
     * 测试获取昨天和明天的日期功能
     * 验证昨天和明天的日期是否正确
     */
    @Test
    fun testYesterdayTomorrow() {
        val today = DateTime.now(1749173037427)
        val yesterday = DateTime.now(1749173037427).yesterday()
        val tomorrow = DateTime.now(1749173037427).tomorrow()
        assertEquals(today.toEpochMilliseconds(), yesterday.addDay(1).toEpochMilliseconds())
        assertEquals(today.toEpochMilliseconds(), tomorrow.subtractDay(1).toEpochMilliseconds())
    }

    /**
     * 测试比较日期是否在某个日期之前或之后的功能
     * 验证日期的比较结果是否正确
     */
    @Test
    fun testIsBeforeAndAfter() {
        val dt1 = DateTime.now()
        val dt2 = DateTime.now().addDay(1)
        assertEquals(true, dt1.isBefore(dt2))
        assertEquals(true, dt2.isAfter(dt1))
    }

    /**
     * 测试格式化和解析日期的功能
     * 验证日期格式化和解析是否正确
     */
    @Test
    fun testFormatAndParse() {
        val dt = DateTime.now()
        val formatted = dt.format(DateTimeFormats.Format.FULL)
        val parsed = DateTime.parse(formatted, DateTimeFormats.Format.FULL)
        assertEquals(dt.year(), parsed.year())
        assertEquals(dt.monthNumber(), parsed.monthNumber())
        assertEquals(dt.day(), parsed.day())
    }

    /**
     * 测试将日期字符串解析为Unix时间戳毫秒值的功能
     * 验证解析结果是否正确
     */
    @Test
    fun testParse2Millis() {
        val timeStr = "2023-01-01 00:00:00"
        val millis = DateTime.parse2Millis(timeStr, DateTimeFormats.Format.FULL)
        assertEquals(1672502400000L, millis)
    }

    /**
     * 测试判断闰年功能
     * 验证指定年份是否为闰年
     */
    @Test
    fun testIsLeapYear() {
        assertEquals(true, DateTime.isLeapYear(2020))
        assertEquals(false, DateTime.isLeapYear(1900))
        assertEquals(true, DateTime.isLeapYear(2000))
    }
}
