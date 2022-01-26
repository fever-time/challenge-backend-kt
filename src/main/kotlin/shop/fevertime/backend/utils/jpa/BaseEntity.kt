package shop.fevertime.backend.utils.jpa

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import shop.fevertime.backend.utils.jpa.converter.ZonedDateTimeAttributeConverter
import java.io.Serializable
import java.time.ZonedDateTime
import javax.persistence.*

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
abstract class BaseEntity : Serializable {

    @CreationTimestamp
    @Convert(converter = ZonedDateTimeAttributeConverter::class)
    @Column(name = "created_At", nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    lateinit var createdAt: ZonedDateTime
        protected set

    @UpdateTimestamp
    @Convert(converter = ZonedDateTimeAttributeConverter::class)
    @Column(name = "updated_At", nullable = false, columnDefinition = "TIMESTAMP")
    lateinit var updatedAt: ZonedDateTime
        protected set
}

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
abstract class BaseEntityId : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false, nullable = false)
    var id: Long = -1
        protected set

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BaseEntityId

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}