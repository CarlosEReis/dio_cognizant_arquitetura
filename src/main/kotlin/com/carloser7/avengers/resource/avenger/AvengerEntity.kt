package com.carloser7.avengers.resource.avenger

import com.carloser7.avengers.domain.avenger.Avenger
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class AvengerEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(nullable = false)
    val nick: String,
    @Column(nullable = false)
    val person: String,

    val description: String?,
    val history: String?
) {
    fun toAvenger() = Avenger(id, nick, person, description, history)

    companion object {
        fun from(avenger: Avenger) = AvengerEntity(
            id = avenger.id,
            nick = avenger.nick,
            description = avenger.description,
            history = avenger.history,
            person = avenger.person
        )
    }
}
