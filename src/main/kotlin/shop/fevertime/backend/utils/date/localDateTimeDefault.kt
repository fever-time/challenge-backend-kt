package shop.fevertime.backend.utils.date

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime


// https://code.luasoftware.com/tutorials/kotlin/localdatetime-to-timestamp-epoch-milliseconds/
fun LocalDateTime.toUTCUnixTime(zone: ZoneId = ZoneOffset.UTC) = atZone(zone).toEpochSecond()

fun LocalDateTime.toDefaultUnixTime(zone: ZoneId = ZoneId.systemDefault()) = atZone(zone).toEpochSecond()

fun LocalDateTime.nowAtZone(zone: ZoneId = ZoneId.systemDefault()): LocalDateTime =
    LocalDateTime.now().atZone(zone).toLocalDateTime()

fun ZonedDateTime.nowFromZone(zone: ZoneId = ZoneId.systemDefault()): ZonedDateTime = ZonedDateTime.now(zone)

fun localDateTimeDefault(): LocalDateTime = LocalDateTime.of(1970, 1, 1, 0, 0, 1)

fun zonedDateTimeDefault(): ZonedDateTime = ZonedDateTime.of(LocalDateTime.of(1970, 1, 1, 0, 0, 1), ZoneOffset.UTC)