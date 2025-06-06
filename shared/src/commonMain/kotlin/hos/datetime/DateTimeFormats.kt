package hos.datetime

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.DateTimeFormat

/**
 * <p>Title: DateTimeFormats </p>
 * <p>Description:  </p>
 *
 * @author : 蔡俊峰
 * @date : 2025-06-03 10:59
 * @version : 1.0
 */
enum class DateTimeFormats(
    val components: DateTimeFormat<DateTimeComponents>,
    val localDateTime: DateTimeFormat<LocalDateTime>,
    val localDate: DateTimeFormat<LocalDate>,
    val localTime: DateTimeFormat<LocalTime>,
) {
    FULL_S(DateTimeComponents.Format {
        year()
        monthNumber()
        dayOfMonth()
        hour()
        minute()
        second()
    }, LocalDateTime.Format {
        year()
        monthNumber()
        dayOfMonth()
        hour()
        minute()
        second()
    }, LocalDate.Format {
        year()
        monthNumber()
        dayOfMonth()
    }, LocalTime.Format {
        hour()
        minute()
        second()
    }),
    Android(DateTimeComponents.Format {
        year()
        chars("-")
        monthNumber()
        chars("-")
        dayOfMonth()
        chars(" ")
        hour()
        chars(":")
        minute()
        chars(":")
        second()
    }, LocalDateTime.Format {
        year()
        chars("-")
        monthNumber()
        chars("-")
        dayOfMonth()
        chars(" ")
        hour()
        chars(":")
        minute()
        chars(":")
        second()
    }, LocalDate.Format {
        year()
        chars("-")
        monthNumber()
        chars("-")
        dayOfMonth()
    }, LocalTime.Format {
        hour()
        chars(":")
        minute()
        chars(":")
        second()
    }),
    Ios(DateTimeComponents.Format {
        year()
        chars("/")
        monthNumber()
        chars("/")
        dayOfMonth()
        chars(" ")
        hour()
        chars(":")
        minute()
        chars(":")
        second()
    }, LocalDateTime.Format {
        year()
        chars("/")
        monthNumber()
        chars("/")
        dayOfMonth()
        chars(" ")
        hour()
        chars(":")
        minute()
        chars(":")
        second()
    }, LocalDate.Format {
        year()
        chars("/")
        monthNumber()
        chars("/")
        dayOfMonth()
    }, LocalTime.Format {
        hour()
        chars(":")
        minute()
        chars(":")
        second()
    }),
    ZH(DateTimeComponents.Format {
        year()
        chars("年")
        monthNumber()
        chars("月")
        dayOfMonth()
        chars("日 ")
        hour()
        chars("时")
        minute()
        chars("分")
        second()
        chars("秒")
    }, LocalDateTime.Format {
        year()
        chars("年")
        monthNumber()
        chars("月")
        dayOfMonth()
        chars("日 ")
        hour()
        chars("时")
        minute()
        chars("分")
        second()
        chars("秒")
    }, LocalDate.Format {
        year()
        chars("年")
        monthNumber()
        chars("月")
        dayOfMonth()
        chars("日")
    }, LocalTime.Format {
        hour()
        chars("时")
        minute()
        chars("分")
        second()
        chars("秒")
    });


    enum class Format(
        val pattern: String,
        val full: String
    ) {

        FULL_S("yyyyMMddHHmmss", ""),
        FULL("yyyy-MM-dd HH:mm:ss", ""),
        Y_MO_D_H_M("yyyy-MM-dd HH:mm", ":00"),
        Y_MO_D_H("yyyy-MM-dd HH", ":00:00"),
        Y_MO_D("yyyy-MM-dd", " 00:00:00"),
        Y_MO("yyyy-MM", "-01 00:00:00"),
        Y("yyyy", "-01-01 00:00:00"),

        // iOS 风格格式
        IOS_FULL("yyyy/MM/dd HH:mm:ss", ""),
        IOS_Y_MO_D_H_M("yyyy/MM/dd HH:mm", ":00"),
        IOS_Y_MO_D_H("yyyy/MM/dd HH", ":00:00"),
        IOS_Y_MO_D("yyyy/MM/dd", " 00:00:00"),
        IOS_Y_MO("yyyy/MM", "/01 00:00:00"),

        // 中文格式
        ZH_FULL("yyyy年MM月dd日 HH时mm分ss秒", ""),
        ZH_Y_MO_D_H_M("yyyy年MM月dd日 HH时mm分", "00秒"),
        ZH_Y_MO_D_H("yyyy年MM月dd日 HH时", "00分00秒"),
        ZH_Y_MO_D("yyyy年MM月dd日", " 00时00分00秒"),
        ZH_Y_MO("yyyy年MM月", "01日 00时00分00秒"),
        ZH_Y("yyyy年", "01月01日 00时00分00秒"),
        MO_D("MM-dd", ""),
        MO_D_H_M("MM-dd HH:mm", ""),
        IOS_MO_D("MM/dd", ""),
        IOS_MO_D_H_M("MM/dd HH:mm", ""),
        ZH_MO_D("MM月dd日", ""),
        ZH_MO_D_H_M("MM月dd日 HH时mm分", "");

        companion object {

            /**
             * 根据输入的时间字符串返回相应的日期格式
             * 此函数尝试根据输入字符串的特征匹配预定义的日期格式，并返回匹配的格式
             * 如果输入字符串不符合任何预定义的格式，则返回 null
             *
             * @param time 时间字符串，用于推断日期格式
             * @return 匹配的日期格式，如果无法匹配则返回 null
             */
            fun getFormatString(time: String): Format? {
                // 格式化输入时间字符串，移除某些字符并处理特殊情况
                val format = format(time)
                // 检查输入字符串是否为空或只包含空白字符，如果是，则返回 null
                if (format.isEmpty()) {
                    return null // 防御性处理：空白字符串直接返回 null
                }

                // 中文日期判断前置，避免符号判断覆盖
                // 检查字符串是否以中文日期单位结尾，如果是，则返回相应的中文日期格式
                if (format.endsWith("秒")) return ZH_FULL
                if (format.endsWith("分")) return ZH_Y_MO_D_H_M
                if (format.endsWith("时")) return ZH_Y_MO_D_H
                if (format.endsWith("日")) return ZH_Y_MO_D
                if (format.endsWith("月")) return ZH_Y_MO
                if (format.endsWith("年")) return ZH_Y

                // 检查字符串是否不包含空格，如果是，则根据包含的连字符或斜杠数量返回相应的日期格式
                if (!format.contains(" ")) {
                    // 检查字符串是否包含连字符，并根据连字符的数量返回相应的日期格式
                    if (format.contains("-")) {
                        val parts = format.split("-")
                        return when (parts.size) {
                            1 -> Y
                            2 -> Y_MO
                            3 -> Y_MO_D
                            else -> null
                        }
                    }

                    // 检查字符串是否包含斜杠，并根据斜杠的数量返回相应的日期格式
                    if (format.contains("/")) {
                        val parts = format.split("/")
                        return when (parts.size) {
                            1 -> Y
                            2 -> IOS_Y_MO
                            3 -> IOS_Y_MO_D
                            else -> null
                        }
                    }

                    // 如果字符串既不包含连字符也不包含斜杠，则返回完整的日期和时间格式
                    return Y
                }

                // 检查字符串是否包含冒号，如果是，则根据冒号的数量以及是否包含连字符或斜杠返回相应的日期和时间格式
                if (format.contains(":")) {
                    val parts = format.split(":")
                    return when (parts.size) {
                        3 -> {
                            if (format.contains("-")) FULL
                            else if (format.contains("/")) IOS_FULL
                            else null
                        }

                        2 -> {
                            if (format.contains("-")) Y_MO_D_H_M
                            else if (format.contains("/")) IOS_Y_MO_D_H_M
                            else null
                        }

                        1 -> {
                            if (format.contains("-")) Y_MO_D_H
                            else if (format.contains("/")) IOS_Y_MO_D_H
                            else null
                        }

                        else -> null
                    }
                }

                // 如果字符串包含连字符或斜杠，但不包含冒号，则返回相应的日期和时间格式
                if (format.contains("-")) return Y_MO_D_H
                if (format.contains("/")) return IOS_Y_MO_D_H

                // 如果字符串不符合任何预定义的格式，则返回 null
                return null
            }

            /**
             * 格式化时间字符串
             * 此函数处理输入的时间字符串，移除某些特殊字符，以便于后续的日期格式推断
             * 如果输入为空或"null"，则返回默认值
             *
             * @param time 时间字符串，可能包含特殊字符需要格式化
             * @param value 默认值，如果输入为空或"null"则返回该值
             * @return 格式化后的时间字符串，不包含特殊字符
             */
            fun format(time: String?, value: String = ""): String {
                // 检查输入是否为空或"null"，如果是，则返回默认值
                if (time.isNullOrBlank() || time.equals("null", true)) {
                    return value
                }
                var result = time
                // 移除或替换时间字符串中的特殊字符
                if (result.contains("T")) {
                    result = result.replace("T", " ")
                }
                if (result.contains("+")) {
                    result = result.substringBeforeLast("+")
                }
                if (result.contains(".")) {
                    result = result.substringBeforeLast(".")
                }
                return result
            }

        }


        /**
         * 根据当前格式类型判断应使用的日期时间格式。
         *
         * 此方法通过比对当前枚举值来决定使用哪种预定义的日期时间格式，
         * 主要识别三种格式：中文格式（ZH）、iOS 风格格式（Ios）和 Android 风格格式（Android）。
         *
         * @return 返回对应的 DateTimeFormats 枚举值。
         */
        fun getDateTimeFormat(): DateTimeFormats {
            if (this == ZH_FULL || this == ZH_Y_MO_D_H_M
                || this == ZH_Y_MO_D_H || this == ZH_Y_MO_D
                || this == ZH_Y_MO || this == ZH_Y || this == ZH_MO_D || this == ZH_MO_D_H_M
            ) {
                return DateTimeFormats.ZH
            }
            if (this == IOS_FULL || this == IOS_Y_MO_D_H_M
                || this == IOS_Y_MO_D_H || this == IOS_Y_MO_D
                || this == IOS_Y_MO || this == IOS_MO_D || this == IOS_MO_D_H_M
            ) {
                return DateTimeFormats.Ios
            }
            if (this == FULL_S){
                return DateTimeFormats.FULL_S
            }
            return DateTimeFormats.Android
        }

        /**
         * 将给定的时间字符串解析为 DateTimeComponents 对象。
         *
         * 此方法首先对输入的时间字符串进行格式化处理，
         * 然后根据当前格式对应的 DateTimeFormat 解析出 DateTimeComponents 实例。
         *
         * @param time 时间字符串。
         * @param value 默认值，当时间字符串为空时使用该值。
         * @return 返回解析后的 DateTimeComponents 对象。
         */
        fun parseDateTimeComponents(time: String, value: String = ""): DateTimeComponents {
            val formatted = format(time, value)
            return getDateTimeFormat().components.parse(formatted + this.full)
        }


        /**
         * 将给定的时间字符串解析为 LocalDateTime 对象。
         *
         * 此方法首先对输入的时间字符串进行格式化处理，
         * 然后根据当前格式对应的 DateTimeFormat 解析出 LocalDateTime 实例。
         *
         * @param time 时间字符串。
         * @param value 默认值，当时间字符串为空时使用该值。
         * @return 返回解析后的 LocalDateTime 对象。
         */
        fun parseLocalDateTime(time: String, value: String = ""): LocalDateTime {
            val formatted = format(time, value)
            return getDateTimeFormat().localDateTime.parse(formatted + this.full)
        }


    }

    companion object {
        /**
         * 解析日期时间组件。
         * 根据提供的模式解析给定时间字符串，并返回日期时间组件对象。
         * 如果未提供模式，将尝试根据时间字符串自动检测模式。
         *
         * @param time 代表日期和时间的字符串。
         * @param pattern 用于解析时间字符串的格式模式。
         * @param value 保留参数，目前未使用。
         * @return 解析后的DateTimeComponents对象。
         * @throws IllegalArgumentException 如果提供的模式为null。
         */
        fun parseDateTimeComponents(
            time: String, pattern: Format? = Format.getFormatString(time),
            value: String = ""
        ): DateTimeComponents {
            if (pattern == null) {
                throw IllegalArgumentException("pattern is not null")
            }
            // 根据输入和模式，获取完整的日期时间字符串。
            return pattern.parseDateTimeComponents(time, value)
        }

        /**
         * 解析本地日期时间。
         * 根据提供的模式解析给定时间字符串，并返回LocalDateTime对象。
         * 如果未提供模式，将尝试根据时间字符串自动检测模式。
         *
         * @param time 代表日期和时间的字符串。
         * @param pattern 用于解析时间字符串的格式模式。
         * @param value 保留参数，目前未使用。
         * @return 解析后的LocalDateTime对象。
         * @throws IllegalArgumentException 如果提供的模式为null。
         */
        fun parseLocalDateTime(
            time: String, pattern: Format? = Format.getFormatString(time),
            value: String = ""
        ): LocalDateTime {
            if (pattern == null) {
                throw IllegalArgumentException("pattern is not null")
            }
            return pattern.parseLocalDateTime(time, value)
        }

        /**
         * 将时间字符串转换为毫秒时间戳。
         * 将给定时间字符串解析为LocalDateTime对象，并将其转换为自1970年1月1日以来的毫秒数。
         * 如果转换过程中发生异常，则返回-1。
         *
         * @param time 代表日期和时间的字符串。
         * @param pattern 用于解析时间字符串的格式模式。
         * @param value 保留参数，目前未使用。
         * @return 自1970年1月1日以来的毫秒数，如果发生异常则为-1。
         */
        fun parse2Millis(
            time: String, pattern: Format? = Format.getFormatString(time),
            value: String = ""
        ): Long {
            try {
                return parseLocalDateTime(time, pattern, value).toEpochMilliseconds()
            } catch (e: Exception) {
                e.printStackTrace()
                return -1L
            }
        }

        /**
         * 时间格式转换。
         * 将给定时间字符串从一种格式转换为另一种格式。
         * 如果未提供源格式，将尝试根据时间字符串自动检测。
         * 目标格式默认为完整的日期和时间格式。
         *
         * @param time 代表日期和时间的字符串。
         * @param from 用于解析时间字符串的源格式模式。
         * @param to 目标格式模式，默认为完整的日期和时间格式。
         * @return 转换后的日期和时间字符串，如果发生异常则为空字符串。
         */
        fun parseConvert(
            time: String,
            from: Format? = Format.getFormatString(time),
            to: Format = Format.FULL
        ): String {
            return try {
                parseLocalDateTime(time, from).format(to)
            } catch (e: Exception) {
                e.printStackTrace()
                ""
            }
        }

    }
}

