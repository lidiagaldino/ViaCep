package com.example.viacep.service

import com.example.viacep.model.CepModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun BuscarCep(cep: String, onComplete: (String, Int) -> Unit) {
    var logradouro = ""

    val call = RetrofitFactory().getApi().getCep(cep)

    call.enqueue(object : Callback<CepModel> {
        override fun onResponse(call: Call<CepModel>, response: Response<CepModel>) {
            logradouro = response.body()!!.logradouro ?: "Cep não encontrado"
            onComplete.invoke(logradouro, 100)
        }

        override fun onFailure(call: Call<CepModel>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })

}