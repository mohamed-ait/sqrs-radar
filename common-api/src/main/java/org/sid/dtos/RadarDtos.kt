package org.sid.dtos

data class CreateRadarRequestDTO(
        val latitude :Float,
        val longitude :Float,
        val vitesse_max :Float,
)

data class RadarResponseDTO(
        val id :String,
        val latitude :Float,
        val longitude :Float,
        val vitesse_max :Float,
)

data class UpdateRadarRequestDTO(
        val latitude :Float,
        val longitude :Float,
        val vitesse_max :Float,
)