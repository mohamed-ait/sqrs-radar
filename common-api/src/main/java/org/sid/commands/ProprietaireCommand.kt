package org.sid.commands

import java.util.Date

data class CreateProprietaireCommand(
        override val id :String,
        val nom :String,
        val prenom :String,
        val email :String,
        val tel :String,
        val date_naissance : Date
):BaseCommand<String>(id)

data class UpdateProprietaireCommand(
        override val id :String,
        val nom :String,
        val prenom :String,
        val email :String,
        val tel :String,
        val date_naissance : Date
):BaseCommand<String>(id)


data class DeleteProprietaireCommand(
        override val id :String,
):BaseCommand<String>(id)