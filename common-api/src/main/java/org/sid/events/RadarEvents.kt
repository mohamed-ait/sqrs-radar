package org.sid.events

data class RadarCreatedEvent(
        override val id : String,
        val latitude : Float,
        val longitude : Float,
        val vitesse_max : Float,
):BaseEvent<String>(id)


data class RadarUpdatedEvent(
        override val id : String,
        val latitude : Float,
        val longitude : Float,
        val vitesse_max : Float,
):BaseEvent<String>(id)


data class RadarDeletedEvent(
        override val id : String,
):BaseEvent<String>(id)