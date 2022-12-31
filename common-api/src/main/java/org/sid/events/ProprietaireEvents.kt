package org.sid.events

import java.util.Date

data class ProprietaireCreatedEvent(
        override val id :String,
        val nom :String,
        val prenom :String,
        val email :String,
        val tel :String,
        val date_naissance :Date,
):BaseEvent<String>(id)


data class ProprietaireUpdatedEvent(
        override val id :String,
        val nom :String,
        val prenom :String,
        val email :String,
        val tel :String,
        val date_naissance :Date,
):BaseEvent<String>(id)


data class ProprietaireDeletedEvent(
        override val id : String,
):BaseEvent<String>(id)