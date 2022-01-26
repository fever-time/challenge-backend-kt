package shop.fevertime.backend.domain

import shop.fevertime.backend.utils.jpa.BaseEntityId
import javax.persistence.*

@Entity
class User(

    @Column(nullable = false)
    var username: String,

    @Column(nullable = false)
    var email: String,

    @Column(nullable = false)
    var kakaoId: String,

    @Column(nullable = false)
    var imgUrl: String
) : BaseEntityId() {

}