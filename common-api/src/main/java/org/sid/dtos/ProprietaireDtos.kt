package org.sid.dtos

import java.util.Date

data class CreateProprietaireRequestDTO(
        val nom :String,
        val prenom :String,
        val email :String,
        val tel :String,
        val date_naissance : Date
)

data class ProprietaireResponseDTO(
        val id :String,
        val nom :String,
        val prenom :String,
        val email :String,
        val tel :String,
        val date_naissance : Date
)

data class UpdateProprietaireRequestDTO(
        val nom :String,
        val prenom :String,
        val email :String,
        val tel :String,
        val date_naissance : Date
)


data class ShortProprietaireDTO (
        val nom :String,
        val prenom :String,
        val email :String,
        val tel :String,
        val date_naissance : Date
)