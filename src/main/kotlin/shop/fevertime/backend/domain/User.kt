package shop.fevertime.backend.domain

import javax.persistence.*

@Entity
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(insertable = false, updatable = false, nullable = false)
    val id: Long,

    @Column(nullable = false)
    var username: String,

    @Column(nullable = false)
    var email: String,

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    var role: UserRole,

    @Column(nullable = false)
    var kakaoId: String,

    @Column(nullable = false)
    var imgUrl: String
) {

}