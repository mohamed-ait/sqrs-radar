package org.sid.commands

import java.util.Date

data class CreateInfractionCommand(
        override val id :String,
        val matricule :String,
        val maxVitesse :Float,
        val montant :Double,
        val vitesse :Float,
        val date : Date,
):BaseCommand<String>(id)


data class UpdateInfractionCommand(
        override val id :String,
        val matricule :String,
        val maxVitesse :Float,
        val montant :Double,
        val vitesse :Float,
        val date : Date,
):BaseCommand<String>(id)


data class DeleteInfractionCommand(
        override val id :String,
):BaseCommand<String>(id)