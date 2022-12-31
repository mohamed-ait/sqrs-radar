package org.sid.commands

data class CreateVehiculeCommand(
        override val id :String,
        val marque :String,
        val matricule :String,
        val modele :String,
        val puissance :Int,
):BaseCommand<String>(id)


data class UpdateVehiculeCommand(
        override val id :String,
        val marque :String,
        val matricule :String,
        val modele :String,
        val puissance :Int,
):BaseCommand<String>(id)


data class DeleteVehiculeCommand(
        override val id :String,
):BaseCommand<String>(id)