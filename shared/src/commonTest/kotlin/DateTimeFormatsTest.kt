import hos.datetime.DateTimeFormats
import hos.datetime.toEpochMilliseconds
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

/**
 * <p>Title: DateTimeFormatsTest </p>
 * <p>Description:  </p>
 * <p>Company: www.mapuni.com </p>
 *
 * @author : 蔡俊峰
 * @date : 2025-06-06 10:44
 * @version : 1.0
 */
class DateTimeFormatsTest {

    @Test
    fun testAllDateTimeFormats() {
        val input = "2023-01-01 12:30:45"
        val result = testDateTimeFormats(input)

        assertNotNull(result["components"])
        assertNotNull(result["localDateTime"])
        assertNotNull(result["convertedToFull"])
        assertTrue((result["millis"] as Long) > 0)
    }

    /**
     * 测试所有 DateTimeFormats 的功能，并输出结果
     *
     * @param time 输入的时间字符串
     * @param pattern 可选参数，指定用于解析的格式，默认自动识别
     * @return 包含解析后信息的 Map
     */
    fun testDateTimeFormats(
        time: String,
        pattern: DateTimeFormats.Format? = null
    ): Map<String, Any?> {
        val results = mutableMapOf<String, Any?>()

        // 1. 自动识别或使用指定格式
        val inputPattern = pattern ?: DateTimeFormats.Format.getFormatString(time)
        results["inputPattern"] = inputPattern?.name

        if (inputPattern == null) {
            results["error"] = "无法识别时间格式"
            return results
        }

        // 2. 预处理时间字符串
        val formatted = DateTimeFormats.Format.format(time)
        results["formatted"] = formatted

        // 3. 解析为 DateTimeComponents
        try {
            val components = inputPattern.parseDateTimeComponents(time)
            results["components"] = components.toString()
        } catch (e: Exception) {
            results["components"] = null
            results["components_error"] = e.message
        }

        // 4. 解析为 LocalDateTime
        try {
            val localDateTime = inputPattern.parseLocalDateTime(time)
            results["localDateTime"] = localDateTime.toString()
            results["millis"] = localDateTime.toEpochMilliseconds()
        } catch (e: Exception) {
            results["localDateTime"] = null
            results["millis"] = -1L
            results["localDateTime_error"] = e.message
        }

        // 7. 时间格式转换
        try {
            val converted = DateTimeFormats.parseConvert(
                time,
                from = inputPattern,
                to = DateTimeFormats.Format.FULL
            )
            results["convertedToFull"] = converted
        } catch (e: Exception) {
            results["convertedToFull"] = null
            results["conversion_error"] = e.message
        }

        // 8. 转换为时间戳
        try {
            val millis = DateTimeFormats.parse2Millis(time, inputPattern)
            results["millis"] = millis
        } catch (e: Exception) {
            results["millis"] = -1L
            results["millis_error"] = e.message
        }

        return results
    }

}