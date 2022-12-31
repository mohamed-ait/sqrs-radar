package org.sid.dtos

data class CreateVehiculeRequestDTO(
        val marque :String,
        val matricule :String,
        val modele :String,
        val puissance :Int,
)

data class VehiculeResponseDTO(
        val id :String,
        val marque :String,
        val matricule :String,
        val modele :String,
        val puissance :Int,
)

data class UpdateVehiculeRequestDTO(
        val marque :String,
        val matricule :String,
        val modele :String,
        val puissance :Int,
)


data class ShortVehiculDTO (
        val id :String,
        val marque :String,
        val matricule :String,
        val modele :String,
        val puissance :Int
)