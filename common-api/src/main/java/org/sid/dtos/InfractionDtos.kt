package org.sid.dtos

import java.util.*

data class CreateInfractionRequestDTO(
        val matricule :String,
        val maxVitesse :Float,
        val montant :Double,
        val vitesse :Float,
        val date : Date,
)

data class InfractionResponseDTO(
        val id :String,
        val matricule :String,
        val maxVitesse :Float,
        val montant :Double,
        val vitesse :Float,
        val date : Date,
)

data class UpdateInfractionRequestDTO(
        val matricule :String,
        val maxVitesse :Float,
        val montant :Double,
        val vitesse :Float,
        val date : Date,
)


data class ShortInfractionDTO (
        val id :String,
        val matricule :String,
        val maxVitesse :Float,
        val montant :Double,
        val vitesse :Float,
        val date : Date,
)