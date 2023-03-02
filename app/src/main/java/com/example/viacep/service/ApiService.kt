package com.example.viacep.service

import com.example.viacep.model.CepModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    //Search by CEP
    @GET("{cepNumber}/json/")
    fun getCep(@Path("cepNumber")cepNumber: String): Call<CepModel>

    //Search by nome
    @GET("{uf}/{cidade}/{logradouro}/json/")
    fun getCeps(
        @Path("uf")uf: String, 
        @Path("cidade")cidade: String,
        @Path("logradouro")logradouro: String
    ): Call<List<CepModel>>


}