# MultiplatformDateTimePlus Library Documentation

## Introduction
`MultiplatformDateTimePlus` is a Kotlin Multiplatform library that provides extension functions for `kotlinx-datetime`, helping developers handle dates and times more conveniently.

## Resource Links
- **English Documentation**: [https://github.com/cjfsss/MultiplatformDateTimePlus](https://github.com/cjfsss/MultiplatformDateTimePlus)
- **Chinese Documentation**: [https://github.com/cjfsss/MultiplatformDateTimePlus/blob/master/README-ZN.md](https://github.com/cjfsss/MultiplatformDateTimePlus/blob/master/README-ZN.md)
- **GitHub Repository**: [https://github.com/cjfsss/MultiplatformDateTimePlus](https://github.com/cjfsss/MultiplatformDateTimePlus)

## Compatibility
The `minSdk` is 26.

## Dependency Introduction
Add the following dependencies to your project:
```kotlin
implementation("io.github.cjfsss:hos-datetime:1.0.1")
implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.2")
```

## Test Examples
- **DateTime Test**: [DateTimeTest](https://github.com/cjfsss/MultiplatformDateTimePlus/blob/master/shared/src/commonTest/kotlin/DateTimeTest.kt)
- **DateTimeFormats Test**: [DateTimeFormatsTest](https://github.com/cjfsss/MultiplatformDateTimePlus/blob/master/shared/src/commonTest/kotlin/DateTimeFormatsTest.kt)
- **LocalDateTimePlus Test**: [LocalDateTimePlusTest](https://github.com/cjfsss/MultiplatformDateTimePlus/blob/master/shared/src/commonTest/kotlin/LocalDateTimePlusTest.kt)

## 🔧 Detailed Explanation of the DateTime Class

### Constructors
| Method Name | Parameters | Description |
| --- | --- | --- |
| `DateTime(localDateTime: LocalDateTime, timeZone: TimeZone = TimeZone.currentSystemDefault())` | `localDateTime`: of type `LocalDateTime`; `timeZone`: of type `TimeZone`, defaulting to the system's default time zone | A private constructor that creates a `DateTime` object using `LocalDateTime` and a time zone |
| `DateTime(year: Int, month: Month, dayOfMonth: Int, hour: Int, minute: Int, second: Int = 0, nanosecond: Int = 0, timeZone: TimeZone = TimeZone.currentSystemDefault())` | `year`: year; `month`: month; `dayOfMonth`: day; `hour`: hour; `minute`: minute; `second`: second, defaulting to 0; `nanosecond`: nanosecond, defaulting to 0; `timeZone`: time zone, defaulting to the system's default time zone | Creates a `DateTime` object using year, month, day, hour, minute, second, nanosecond, and time zone |
| `DateTime(millis: Long = 0, timeZone: TimeZone = TimeZone.currentSystemDefault())` | `millis`: number of milliseconds, defaulting to 0; `timeZone`: time zone, defaulting to the system's default time zone | Creates a `DateTime` object using the number of milliseconds and a time zone |

### Instance Methods
| Method Name | Parameters | Return Type | Description |
| --- | --- | --- | --- |
| `setYearMonthDay(year: Int, month: Int = 1, dayOfMonth: Int = 1)` | `year`: year; `month`: month, defaulting to January; `dayOfMonth`: day, defaulting to the 1st | A `DateTime` object | Sets the year, month, and day |
| `setHourMinuteSecond(hour: Int, minute: Int = 0, second: Int = 0)` | `hour`: hour; `minute`: minute, defaulting to 0; `second`: second, defaulting to 0 | A `DateTime` object | Sets the hour, minute, and second |
| `set(value: Int, unit: DateTimeUnit)` | `value`: time value; `unit`: time unit | A `DateTime` object | Sets the value of the specified time unit |
| `add(value: Int, unit: DateTimeUnit)` | `value`: time value; `unit`: time unit | A `DateTime` object | Increases the value of the specified time unit |
| `subtract(value: Int, unit: DateTimeUnit)` | `value`: time value; `unit`: time unit | A `DateTime` object | Decreases the value of the specified time unit |
| `toEpochMilliseconds(timeZone: TimeZone = this.timeZone)` | `timeZone`: time zone, defaulting to the current object's time zone | A `Long` type | Converts to Epoch milliseconds |
| `year()` | None | An `Int` type | Gets the year |
| `monthNumber()` | None | An `Int` type | Gets the month number |
| `month()` | None | A `Month` type | Gets the month enum |
| `day()` | None | An `Int` type | Gets the day |
| `dayOfWeek()` | None | A `DayOfWeek` type | Gets the day of the week |
| `dayOfYear()` | None | An `Int` type | Gets the day of the year |
| `hour()` | None | An `Int` type | Gets the hour |
| `minute()` | None | An `Int` type | Gets the minute |
| `second()` | None | An `Int` type | Gets the second |
| `countMondaysInMonth()` | None | An `Int` type | Calculates the number of Mondays in the current month |
| `countWeeksInMonth()` | None | An `Int` type | Calculates the number of weeks in the current month |
| `countWeeksMondayInMonth()` | None | An `Int` type | Calculates the number of weeks starting on a Monday in the current month |
| `getWeekFirstDayInMonth()` | None | A `MutableList<DateTime>` type | Gets the first Sunday of each month |
| `startYear()` | None | A `DateTime` object | Sets to the start time of the current year |
| `endYear()` | None | A `DateTime` object | Sets to the end time of the current year |
| `startMonth()` | None | A `DateTime` object | Sets to the start time of the current month |
| `endMonth()` | None | A `DateTime` object | Sets to the end time of the current month |
| `startWeek()` | None | A `DateTime` object | Sets to the start time of the current week |
| `endWeek()` | None | A `DateTime` object | Sets to the end time of the current week |
| `startDay()` | None | A `DateTime` object | Sets to the start time of the current day |
| `endDay()` | None | A `DateTime` object | Sets to the end time of the current day |
| `yesterday()` | None | A `DateTime` object | Gets the time of yesterday |
| `yesterdayBefore()` | None | A `DateTime` object | Gets the time of the day before yesterday |
| `tomorrow()` | None | A `DateTime` object | Gets the time of tomorrow |
| `tomorrowAfter()` | None | A `DateTime` object | Gets the time of the day after tomorrow |
| `subtractYear(time: Int)` | `time`: number of years | A `DateTime` object | Decreases the specified number of years |
| `subtractMonth(time: Int)` | `time`: number of months | A `DateTime` object | Decreases the specified number of months |
| `subtractDay(time: Int)` | `time`: number of days | A `DateTime` object | Decreases the specified number of days |
| `subtractHour(time: Int)` | `time`: number of hours | A `DateTime` object | Decreases the specified number of hours |
| `subtractMinute(time: Int)` | `time`: number of minutes | A `DateTime` object | Decreases the specified number of minutes |
| `subtractSecond(time: Int)` | `time`: number of seconds | A `DateTime` object | Decreases the specified number of seconds |
| `subtractHour1()` | None | A `DateTime` object | Decreases by 1 hour |
| `subtractMinute30()` | None | A `DateTime` object | Decreases by 30 minutes |
| `subtractDay30()` | None | A `DateTime` object | Decreases by 30 days |
| `subtractDay7()` | None | A `DateTime` object | Decreases by 7 days |
| `addYear(time: Int)` | `time`: number of years | A `DateTime` object | Increases the specified number of years |
| `addMonth(time: Int)` | `time`: number of months | A `DateTime` object | Increases the specified number of months |
| `addDay(time: Int)` | `time`: number of days | A `DateTime` object | Increases the specified number of days |
| `addHour(time: Int)` | `time`: number of hours | A `DateTime` object | Increases the specified number of hours |
| `addMinute(time: Int)` | `time`: number of minutes | A `DateTime` object | Increases the specified number of minutes |
| `addSecond(time: Int)` | `time`: number of seconds | A `DateTime` object | Increases the specified number of seconds |
| `isSame(dateTime: DateTime)` | `dateTime`: another `DateTime` object | A `Boolean` type | Checks if two times are the same |
| `isBefore(end: DateTime)` | `end`: a specified `DateTime` object | A `Boolean` type | Checks if the current time is before the specified time |
| `isAfter(start: DateTime)` | `start`: a specified `DateTime` object | A `Boolean` type | Checks if the current time is after the specified time |
| `monthSize()` | None | An `Int` type | Gets the number of days in the current month |
| `formatString(pattern: DateTimeFormats.Format = DateTimeFormats.Format.FULL)` | `pattern`: time format, defaulting to the full format | A `String` type | Formats the time as a string |
| `format(pattern: DateTimeFormats.Format = DateTimeFormats.Format.FULL)` | `pattern`: time format, defaulting to the full format | A `String` type | Formats the time as a string |

### Static Methods
| Method Name | Parameters | Return Type | Description |
| --- | --- | --- | --- |
| `now(millis: Long = 0, timeZone: TimeZone = TimeZone.currentSystemDefault())` | `millis`: number of milliseconds, defaulting to 0; `timeZone`: time zone, defaulting to the system's default time zone | A `DateTime` object | Creates a `DateTime` object using the given number of milliseconds and time zone |
| `now(year: Int, month: Month, dayOfMonth: Int, hour: Int, minute: Int, second: Int = 0, nanosecond: Int = 0, timeZone: TimeZone = TimeZone.currentSystemDefault())` | `year`: year; `month`: month; `dayOfMonth`: day; `hour`: hour; `minute`: minute; `second`: second, defaulting to 0; `nanosecond`: nanosecond, defaulting to 0; `timeZone`: time zone, defaulting to the system's default time zone | A `DateTime` object | Creates a `DateTime` object using the given date and time parameters |
| `parse(time: String, pattern: DateTimeFormats.Format? = DateTimeFormats.Format.getFormatString(time), value: String = "")` | `time`: time string; `pattern`: time format, if not provided, it will be automatically determined based on the time string; `value`: additional string for parsing, defaulting to an empty string | A `DateTime` object | Parses a `DateTime` object using the given time string and format |
| `parse2Millis(time: String, pattern: DateTimeFormats.Format? = DateTimeFormats.Format.getFormatString(time), value: String = "")` | `time`: time string; `pattern`: time format, if not provided, it will be automatically determined based on the time string; `value`: additional string for parsing, defaulting to an empty string | A `Long` type | Converts the time string to a millisecond timestamp |
| `parseConvert(time: String, from: DateTimeFormats.Format? = DateTimeFormats.Format.getFormatString(time), to: DateTimeFormats.Format = DateTimeFormats.Format.FULL)` | `time`: time string; `from`: source format pattern for parsing the time string; `to`: target format pattern, defaulting to the full date and time format | A `String` type | Converts the time format |
| `getNowMills(timeZone: TimeZone = TimeZone.currentSystemDefault())` | `timeZone`: specified time zone, defaulting to the system's default time zone | A `Long` type | Gets the number of milliseconds of the current time |
| `isLeapYear(year: Int)` | `year`: year | A `Boolean` type | Checks if the specified year is a leap year |
| `getContent(millis: Long = 0, timeZone: TimeZone = TimeZone.currentSystemDefault(), content: DateTime.() -> T)` | `millis`: number of milliseconds of time, defaulting to 0, representing the current time; `timeZone`: time zone, defaulting to the system's current time zone; `content`: processing logic for the date and time, returning any type `T` | A `T` type | Gets the current time content based on the specified number of milliseconds of time and time zone |
| `setContent(millis: Long = 0, timeZone: TimeZone = TimeZone.currentSystemDefault(), content: DateTime.() -> T)` | `millis`: number of milliseconds of time, defaulting to 0, representing the current time; `timeZone`: time zone, defaulting to the system's current time zone; `content`: processing logic for the date and time, with no return value | None | Sets the timestamp of the content |
| `parseContent(time: String, pattern: DateTimeFormats.Format? = DateTimeFormats.Format.getFormatString(time), value: String = "", content: DateTime.() -> T)` | `time`: time string; `pattern`: time format, if not provided, it will be automatically obtained based on the time string; `value`: default value, used when parsing fails; `content`: processing logic for the date and time, returning any type `T` | A `T` type | Parses the content based on the specified time string, format, and default value |

---

## 🧩 Supported format types in the enumeration class `Format`

| Name             | Pattern                       | Example                       |
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

## License
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