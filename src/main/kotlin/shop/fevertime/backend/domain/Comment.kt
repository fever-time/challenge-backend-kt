package shop.fevertime.backend.domain

import shop.fevertime.backend.utils.jpa.BaseEntityId
import javax.persistence.*

@Entity
class Comment(

    @Column(nullable = false)
    var contents: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", referencedColumnName = "id", nullable = false)
    val feed: Feed

) : BaseEntityId() {
}