package shop.fevertime.backend.utils.jpa.converter

import shop.fevertime.backend.utils.date.localDateTimeDefault
import java.sql.Timestamp
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import javax.persistence.AttributeConverter
import javax.persistence.Converter

//https://gist.github.com/user454322/8bdd359556629ec294cb9b41cbc6ff3b
//https://gist.github.com/elviejokike/47e18e0836a86fb789e7c00b69e22847
@Converter(autoApply = false)
class ZonedDateTimeAttributeConverter : AttributeConverter<ZonedDateTime, Timestamp> {

    private val utcZoneId: ZoneId = ZoneId.of("UTC")
    private val defaultZoneId: ZoneId = ZoneId.systemDefault()

    override fun convertToDatabaseColumn(zonedDateTime: ZonedDateTime?): Timestamp {
        // Store always in UTC
        return if (zonedDateTime == null)
            Timestamp.valueOf(localDateTimeDefault())
        else
            Timestamp.valueOf(toUtcZoneId(zonedDateTime).toLocalDateTime())
    }

    override fun convertToEntityAttribute(sqlTimestamp: Timestamp?): ZonedDateTime {
        // Read from database (stored in UTC) and return with the system default.
        return if (sqlTimestamp == null)
            ZonedDateTime.of(localDateTimeDefault(), ZoneOffset.UTC)
        else
            toDefaultZoneId(sqlTimestamp.toLocalDateTime().atZone(ZoneId.of("UTC")))
    }

    private fun toUtcZoneId(zonedDateTime: ZonedDateTime): ZonedDateTime {
        return zonedDateTime.withZoneSameInstant(utcZoneId)
    }

    private fun toDefaultZoneId(zonedDateTime: ZonedDateTime): ZonedDateTime {
        return zonedDateTime.withZoneSameInstant(defaultZoneId)
    }
}