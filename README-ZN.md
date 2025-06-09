# MultiplatformDateTimePlus 库文档

## 简介
`MultiplatformDateTimePlus` 是一个提供 `kotlinx-datetime` 扩展函数的 Kotlin Multiplatform 库，可帮助开发者更便捷地处理日期和时间。

## 资源链接
- **英文文档**：[https://github.com/cjfsss/MultiplatformDateTimePlus](https://github.com/cjfsss/MultiplatformDateTimePlus)
- **中文文档**：[https://github.com/cjfsss/MultiplatformDateTimePlus/blob/master/README-ZN.md](https://github.com/cjfsss/MultiplatformDateTimePlus/blob/master/README-ZN.md)
- **GitHub 仓库**：[https://github.com/cjfsss/MultiplatformDateTimePlus](https://github.com/cjfsss/MultiplatformDateTimePlus)

## 兼容性
`minSdk` 为 26。

## 依赖引入
在项目中引入以下依赖：
```kotlin
implementation("io.github.cjfsss:hos-datetime:1.0.1")
implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.2")
```

## 测试示例
- **DateTime 测试**：[DateTimeTest](https://github.com/cjfsss/MultiplatformDateTimePlus/blob/master/shared/src/commonTest/kotlin/DateTimeTest.kt)
- **DateTimeFormats 测试**：[DateTimeFormatsTest](https://github.com/cjfsss/MultiplatformDateTimePlus/blob/master/shared/src/commonTest/kotlin/DateTimeFormatsTest.kt)
- **LocalDateTimePlus 测试**：[LocalDateTimePlusTest](https://github.com/cjfsss/MultiplatformDateTimePlus/blob/master/shared/src/commonTest/kotlin/LocalDateTimePlusTest.kt)

## 🔧 DateTime 类详细说明

### 构造函数
| 方法名 | 参数 | 描述 |
| --- | --- | --- |
| `DateTime(localDateTime: LocalDateTime, timeZone: TimeZone = TimeZone.currentSystemDefault())` | `localDateTime`：`LocalDateTime` 类型；`timeZone`：`TimeZone` 类型，默认为系统默认时区 | 私有构造函数，使用 `LocalDateTime` 和时区创建 `DateTime` 对象 |
| `DateTime(year: Int, month: Month, dayOfMonth: Int, hour: Int, minute: Int, second: Int = 0, nanosecond: Int = 0, timeZone: TimeZone = TimeZone.currentSystemDefault())` | `year`：年份；`month`：月份；`dayOfMonth`：日期；`hour`：小时；`minute`：分钟；`second`：秒，默认为 0；`nanosecond`：纳秒，默认为 0；`timeZone`：时区，默认为系统默认时区 | 使用年、月、日、时、分、秒、纳秒和时区创建 `DateTime` 对象 |
| `DateTime(millis: Long = 0, timeZone: TimeZone = TimeZone.currentSystemDefault())` | `millis`：毫秒数，默认为 0；`timeZone`：时区，默认为系统默认时区 | 使用毫秒数和时区创建 `DateTime` 对象 |

### 实例方法
| 方法名 | 参数 | 返回值 | 描述 |
| --- | --- | --- | --- |
| `setYearMonthDay(year: Int, month: Int = 1, dayOfMonth: Int = 1)` | `year`：年份；`month`：月份，默认为 1 月；`dayOfMonth`：日期，默认为 1 日 | `DateTime` 对象 | 设置年月日 |
| `setHourMinuteSecond(hour: Int, minute: Int = 0, second: Int = 0)` | `hour`：小时；`minute`：分钟，默认为 0 分；`second`：秒，默认为 0 秒 | `DateTime` 对象 | 设置时分秒 |
| `set(value: Int, unit: DateTimeUnit)` | `value`：时间值；`unit`：时间单位 | `DateTime` 对象 | 设置指定时间单位的值 |
| `add(value: Int, unit: DateTimeUnit)` | `value`：时间值；`unit`：时间单位 | `DateTime` 对象 | 增加指定时间单位的值 |
| `subtract(value: Int, unit: DateTimeUnit)` | `value`：时间值；`unit`：时间单位 | `DateTime` 对象 | 减少指定时间单位的值 |
| `toEpochMilliseconds(timeZone: TimeZone = this.timeZone)` | `timeZone`：时区，默认使用当前对象的时区 | `Long` 类型 | 转换为 Epoch 毫秒数 |
| `year()` | 无 | `Int` 类型 | 获取年份 |
| `monthNumber()` | 无 | `Int` 类型 | 获取月份编号 |
| `month()` | 无 | `Month` 类型 | 获取月份枚举 |
| `day()` | 无 | `Int` 类型 | 获取日期 |
| `dayOfWeek()` | 无 | `DayOfWeek` 类型 | 获取星期几 |
| `dayOfYear()` | 无 | `Int` 类型 | 获取一年中的第几天 |
| `hour()` | 无 | `Int` 类型 | 获取小时 |
| `minute()` | 无 | `Int` 类型 | 获取分钟 |
| `second()` | 无 | `Int` 类型 | 获取秒 |
| `countMondaysInMonth()` | 无 | `Int` 类型 | 计算当月的星期一数量 |
| `countWeeksInMonth()` | 无 | `Int` 类型 | 计算当月的周数 |
| `countWeeksMondayInMonth()` | 无 | `Int` 类型 | 计算当月以星期一开始的周数 |
| `getWeekFirstDayInMonth()` | 无 | `MutableList<DateTime>` 类型 | 获取每个月的第一个星期日 |
| `startYear()` | 无 | `DateTime` 对象 | 设置为当年的开始时间 |
| `endYear()` | 无 | `DateTime` 对象 | 设置为当年的结束时间 |
| `startMonth()` | 无 | `DateTime` 对象 | 设置为当月的开始时间 |
| `endMonth()` | 无 | `DateTime` 对象 | 设置为当月的结束时间 |
| `startWeek()` | 无 | `DateTime` 对象 | 设置为当周的开始时间 |
| `endWeek()` | 无 | `DateTime` 对象 | 设置为当周的结束时间 |
| `startDay()` | 无 | `DateTime` 对象 | 设置为当天的开始时间 |
| `endDay()` | 无 | `DateTime` 对象 | 设置为当天的结束时间 |
| `yesterday()` | 无 | `DateTime` 对象 | 获取昨天的时间 |
| `yesterdayBefore()` | 无 | `DateTime` 对象 | 获取前天的时间 |
| `tomorrow()` | 无 | `DateTime` 对象 | 获取明天的时间 |
| `tomorrowAfter()` | 无 | `DateTime` 对象 | 获取后天的时间 |
| `subtractYear(time: Int)` | `time`：年数 | `DateTime` 对象 | 减少指定年数 |
| `subtractMonth(time: Int)` | `time`：月数 | `DateTime` 对象 | 减少指定月数 |
| `subtractDay(time: Int)` | `time`：天数 | `DateTime` 对象 | 减少指定天数 |
| `subtractHour(time: Int)` | `time`：小时数 | `DateTime` 对象 | 减少指定小时数 |
| `subtractMinute(time: Int)` | `time`：分钟数 | `DateTime` 对象 | 减少指定分钟数 |
| `subtractSecond(time: Int)` | `time`：秒数 | `DateTime` 对象 | 减少指定秒数 |
| `subtractHour1()` | 无 | `DateTime` 对象 | 减少 1 小时 |
| `subtractMinute30()` | 无 | `DateTime` 对象 | 减少 30 分钟 |
| `subtractDay30()` | 无 | `DateTime` 对象 | 减少 30 天 |
| `subtractDay7()` | 无 | `DateTime` 对象 | 减少 7 天 |
| `addYear(time: Int)` | `time`：年数 | `DateTime` 对象 | 增加指定年数 |
| `addMonth(time: Int)` | `time`：月数 | `DateTime` 对象 | 增加指定月数 |
| `addDay(time: Int)` | `time`：天数 | `DateTime` 对象 | 增加指定天数 |
| `addHour(time: Int)` | `time`：小时数 | `DateTime` 对象 | 增加指定小时数 |
| `addMinute(time: Int)` | `time`：分钟数 | `DateTime` 对象 | 增加指定分钟数 |
| `addSecond(time: Int)` | `time`：秒数 | `DateTime` 对象 | 增加指定秒数 |
| `isSame(dateTime: DateTime)` | `dateTime`：另一个 `DateTime` 对象 | `Boolean` 类型 | 判断两个时间是否相同 |
| `isBefore(end: DateTime)` | `end`：指定的 `DateTime` 对象 | `Boolean` 类型 | 判断当前时间是否在指定时间之前 |
| `isAfter(start: DateTime)` | `start`：指定的 `DateTime` 对象 | `Boolean` 类型 | 判断当前时间是否在指定时间之后 |
| `monthSize()` | 无 | `Int` 类型 | 获取当月的天数 |
| `formatString(pattern: DateTimeFormats.Format = DateTimeFormats.Format.FULL)` | `pattern`：时间格式，默认为完整格式 | `String` 类型 | 格式化时间为字符串 |
| `format(pattern: DateTimeFormats.Format = DateTimeFormats.Format.FULL)` | `pattern`：时间格式，默认为完整格式 | `String` 类型 | 格式化时间为字符串 |

### 静态方法
| 方法名 | 参数 | 返回值 | 描述 |
| --- | --- | --- | --- |
| `now(millis: Long = 0, timeZone: TimeZone = TimeZone.currentSystemDefault())` | `millis`：毫秒数，默认为 0；`timeZone`：时区，默认为系统默认时区 | `DateTime` 对象 | 使用给定的毫秒数和时区创建 `DateTime` 对象 |
| `now(year: Int, month: Month, dayOfMonth: Int, hour: Int, minute: Int, second: Int = 0, nanosecond: Int = 0, timeZone: TimeZone = TimeZone.currentSystemDefault())` | `year`：年份；`month`：月份；`dayOfMonth`：日期；`hour`：小时；`minute`：分钟；`second`：秒，默认为 0；`nanosecond`：纳秒，默认为 0；`timeZone`：时区，默认为系统默认时区 | `DateTime` 对象 | 使用给定的日期和时间参数创建 `DateTime` 对象 |
| `parse(time: String, pattern: DateTimeFormats.Format? = DateTimeFormats.Format.getFormatString(time), value: String = "")` | `time`：时间字符串；`pattern`：时间格式，如果未提供，将根据时间字符串自动确定；`value`：用于解析的附加字符串，默认为空 | `DateTime` 对象 | 使用给定的时间字符串和格式解析一个 `DateTime` 对象 |
| `parse2Millis(time: String, pattern: DateTimeFormats.Format? = DateTimeFormats.Format.getFormatString(time), value: String = "")` | `time`：时间字符串；`pattern`：时间格式，如果未提供，将根据时间字符串自动确定；`value`：用于解析的附加字符串，默认为空 | `Long` 类型 | 将时间字符串转换为毫秒时间戳 |
| `parseConvert(time: String, from: DateTimeFormats.Format? = DateTimeFormats.Format.getFormatString(time), to: DateTimeFormats.Format = DateTimeFormats.Format.FULL)` | `time`：时间字符串；`from`：用于解析时间字符串的源格式模式；`to`：目标格式模式，默认为完整的日期和时间格式 | `String` 类型 | 时间格式转换 |
| `getNowMills(timeZone: TimeZone = TimeZone.currentSystemDefault())` | `timeZone`：指定时区，默认为系统默认时区 | `Long` 类型 | 获取当前时间的毫秒数 |
| `isLeapYear(year: Int)` | `year`：年份 | `Boolean` 类型 | 判断指定的年份是否为闰年 |
| `getContent(millis: Long = 0, timeZone: TimeZone = TimeZone.currentSystemDefault(), content: DateTime.() -> T)` | `millis`：时间毫秒数，默认为 0，表示当前时间；`timeZone`：时区，默认为系统当前时区；`content`：时间日期的处理逻辑，返回任意类型 `T` | `T` 类型 | 根据指定的时间毫秒数和时区获取当前时间内容 |
| `setContent(millis: Long = 0, timeZone: TimeZone = TimeZone.currentSystemDefault(), content: DateTime.() -> T)` | `millis`：时间毫秒数，默认为 0，表示当前时间；`timeZone`：时区，默认为系统当前时区；`content`：时间日期的处理逻辑，无返回值 | 无 | 设置内容的时间戳 |
| `parseContent(time: String, pattern: DateTimeFormats.Format? = DateTimeFormats.Format.getFormatString(time), value: String = "", content: DateTime.() -> T)` | `time`：时间字符串；`pattern`：时间格式，如果未提供，将根据时间字符串自动获取；`value`：默认值，用于解析失败时返回；`content`：时间日期的处理逻辑，返回任意类型 `T` | `T` 类型 | 根据指定的时间字符串、格式和默认值解析内容 |


---

## 🧩 枚举类 `Format` 中支持的格式类型

| 名称             | 模式                          | 示例                          |
| ---------------- | ----------------------------- | ----------------------------- |
| `FULL_S`         | `yyyyMMddHHmmss`              | `20230101123045`              |
| `FULL`           | `yyyy-MM-dd HH:mm:ss`         | `2023-01-01 12:30:45`         |
| `Y_MO_D_H_M`     | `yyyy-MM-dd HH:mm`            | `2023-01-01 12:30`            |
| `Y_MO_D_H`       | `yyyy-MM-dd HH`               | `2023-01-01 12`               |
| `Y_MO_D`         | `yyyy-MM-dd`                  | `2023-01-01`                  |
| `Y_MO`           | `yyyy-MM`                     | `2023-01`                     |
| `Y`              | `yyyy`                        | `2023`                        |
| `IOS_FULL`       | `yyyy/MM/dd HH:mm:ss`         | `2023/01/01 12:30:45`         |
| `IOS_Y_MO_D_H_M` | `yyyy/MM/dd HH:mm`            | `2023/01/01 12:30`            |
| `IOS_Y_MO_D_H`   | `yyyy/MM/dd HH`               | `2023/01/01 12`               |
| `IOS_Y_MO_D`     | `yyyy/MM/dd`                  | `2023/01/01`                  |
| `IOS_Y_MO`       | `yyyy/MM`                     | `2023/01`                     |
| `ZH_FULL`        | `yyyy年MM月dd日 HH时mm分ss秒` | `2023年01月01日 12时30分45秒` |
| `ZH_Y_MO_D_H_M`  | `yyyy年MM月dd日 HH时mm分`     | `2023年01月01日 12时30分`     |
| `ZH_Y_MO_D_H`    | `yyyy年MM月dd日 HH时`         | `2023年01月01日 12时`         |
| `ZH_Y_MO_D`      | `yyyy年MM月dd日`              | `2023年01月01日`              |
| `ZH_Y_MO`        | `yyyy年MM月`                  | `2023年01月`                  |
| `ZH_Y`           | `yyyy年`                      | `2023年`                      |
| `MO_D`           | `MM-dd`                       | `01-01`                       |
| `MO_D_H_M`       | `MM-dd HH:mm`                 | `01-01 12:30`                 |
| `IOS_MO_D`       | `MM/dd`                       | `01/01`                       |
| `IOS_MO_D_H_M`   | `MM/dd HH:mm`                 | `01/01 12:30`                 |
| `ZH_MO_D`        | `MM月dd日`                    | `01月01日`                    |
| `ZH_MO_D_H_M`    | `MM月dd日 HH时mm分`           | `01月01日 12时30分`           |

---

## 许可证
```
Copyright 2017 Xiho

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```