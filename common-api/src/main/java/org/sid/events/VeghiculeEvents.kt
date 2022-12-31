package org.sid.events

data class VehiculeCreatedEvent(
        override val id :String,
        val marque :String,
        val matricule :String,
        val modele :String,
        val puissance :Int,
):BaseEvent<String>(id)


data class VehiculeUpdatedEvent(
        override val id :String,
        val marque :String,
        val matricule :String,
        val modele :String,
        val puissance :Int,
):BaseEvent<String>(id)


data class VehiculeDeletedEvent(
        override val id : String,
):BaseEvent<String>(id)