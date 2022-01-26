package shop.fevertime.backend.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User() {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1
        protected set
}