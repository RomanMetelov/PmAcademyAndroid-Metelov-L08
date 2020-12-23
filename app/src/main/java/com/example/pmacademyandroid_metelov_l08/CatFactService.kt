package com.example.pmacademyandroid_metelov_l08

import retrofit2.Call
import retrofit2.http.GET

interface CatFactService {
    @GET("/facts")
    fun getCatFactData(): Call<CatFactResponse>
}