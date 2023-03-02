package com.example.viacep.model

import com.google.gson.annotations.SerializedName

data class CepModel(
    var cep: String,
    var logradouro: String,
    var uf: String,
    var complemento: String,
    @SerializedName("localidade") var cidade: String
)