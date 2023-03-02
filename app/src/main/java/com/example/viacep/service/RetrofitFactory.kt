package com.example.viacep.service

import com.example.viacep.service.constants.base_url
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

        val retrofit = Retrofit.Builder().baseUrl(base_url).addConverterFactory(
            GsonConverterFactory.create()).build()

        fun getApi(): ApiService {
            return retrofit.create(ApiService::class.java)
    }



}