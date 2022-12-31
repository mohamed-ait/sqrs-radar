package org.sid.events

import java.util.Date

data class InfractionCreatedEvent(
        override val id :String,
        val matricule :String,
        val maxVitesse :Float,
        val montant :Double,
        val vitesse :Float,
        val date :Date,
):BaseEvent<String>(id)


data class InfractionUpdatedEvent(
        override val id :String,
        val matricule :String,
        val maxVitesse :Float,
        val montant :Double,
        val vitesse :Float,
        val date :Date,
):BaseEvent<String>(id)


data class InfractionDeletedEvent(
        override val id : String,
):BaseEvent<String>(id)
