**一个提供 `kotlinx-datetime` 扩展函数的 Kotlin Multiplatform 库。**

### Minimum SDk 最小 SDk



- minSdk is 26 minSdk 为 26

### Implementation

```kotlin
implementation("")
```


## DateTime 方法说明
---

### 🔧 方法清单及功能描述

| 编号 | 功能             | 方法/函数                                                                 |
| ---- | ---------------- | -------------------------------------------------------------------------- |
| 1    | 设置年份         | set(year, DateTimeUnit.YEAR)                                               |
| 2    | 时间加减         | add(value, unit), subtract(value, unit)                                    |
| 3    | 获取 Unix 时间戳 | toEpochMilliseconds()                                                      |
| 4    | 获取年、月、日   | year(), monthNumber(), day()                                               |
| 5    | 获取时、分、秒   | hour(), minute(), second()                                                 |
| 6    | 获取年份起始时间 | startYear()                                                                |
| 7    | 获取月份起始时间 | startMonth()                                                               |
| 8    | 获取周起始时间   | startWeek()                                                                |
| 9    | 获取天起始时间   | startDay()                                                                 |
| 10   | 获取昨天/明天    | yesterday(), tomorrow()                                                    |
| 11   | 时间比较         | isBefore(other), isAfter(other)                                            |
| 12   | 时间格式化与解析 | format(pattern), parse(str, pattern)                                       |
| 13   | 字符串转时间戳   | parse2Millis(str, pattern)                                                 |
| 14   | 判断闰年         | isLeapYear(year)                                                           |

## LocalDateTime 方法说明

---




| 序号 | 方法名               | 功能描述                     |
|------|----------------------|------------------------------|
| 1    | set(value, unit)     | 设置年、月、日、时、分、秒等单位值 |
| 2    | add(value, unit)     | 添加时间单位                 |
| 3    | subtract(value, unit)| 减去时间单位                 |
| 4    | toEpochMilliseconds()| 转换为 Unix 时间戳           |
| 5    | day()                | 获取日期中的“天”             |
| 6    | startDay()           | 设置为当天开始时间           |
| 7    | endDay()             | 设置为当天结束时间           |
| 8    | startMonth()         | 设置为当月第一天             |
| 9    | endMonth()           | 设置为当月最后一天           |
| 10   | startYear()          | 设置为当年第一天             |
| 11   | endYear()            | 设置为当年最后一天           |
| 12   | startWeek()          | 设置为当周第一天（周一）     |
| 13   | endWeek()            | 设置为当周最后一天（周日）   |
| 14   | yesterday()          | 获取昨天的时间               |
| 15   | tomorrow()           | 获取明天的时间               |
| 16   | isSame(other)        | 判断两个时间是否相同         |
| 17   | isBefore(other)      | 判断当前时间是否在指定时间之前 |
| 18   | isAfter(other)       | 判断当前时间是否在指定时间之后 |
| 19   | monthSize()          | 获取当月总天数               |
| 20   | countMondaysInMonth()| 获取当月星期一数量           |
| 21   | getWeekFirstDayInMonth() | 获取当月每周的第一个星期一   |
| 22   | countWeeksInMonth()   | 计算当月的完整周数           |
| 23   | countWeeksMondayInMonth() | 计算以周一开头的周数       |
| 24   | format(pattern)      | 使用指定格式格式化时间       |
| 25   | formatString(pattern)| 同上                         |
| 26   | parse2Millis(...)    | 将字符串转为时间戳           |
| 27   | parseConvert(...)    | 时间格式转换                 |
| 28   | isLeapYear(year)     | 判断是否为闰年               |
| 29   | setContent(...)      | 在特定时间执行内容块         |
| 30   | getContent(...)      | 获取特定时间上下文下的结果   |
| 31   | getNowMills(...)     | 获取当前时间戳               |


## DateTimeFormats 方法说明

---


| 序号 | 方法名                          | 功能描述                                      |
|------|-------------------------------|---------------------------------------------|
| 1    | getFormatString(time: String)  | 根据输入字符串自动识别日期格式模式            |
| 2    | `format(time: String?, value: String = "")` | 对时间字符串进行预处理（去特殊字符、替换等）  |
| 3    | parseDateTimeComponents(...)    | 使用当前格式解析为 `DateTimeComponents`       |
| 4    | parseLocalDateTime(...)         | 使用当前格式解析为 `LocalDateTime`            |
| 5    | toEpochMilliseconds()           | 将 `LocalDateTime` 转换为 Unix 时间戳（毫秒） |
| 6    | parseConvert(...)               | 在不同格式之间转换时间字符串                  |
| 7    | parse2Millis(...)               | 解析时间字符串并返回其对应的时间戳            |

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

