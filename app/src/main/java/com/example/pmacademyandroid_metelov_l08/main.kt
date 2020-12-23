package com.example.pmacademyandroid_metelov_l08

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.logging.Logger

fun main() {
    val baseUrl = "https://cat-fact.herokuapp.com/"
    var catFactsDataCollection = requestDataFrom(baseUrl)

    val log = Logger.getLogger(catFactsDataCollection?.javaClass?.name)
    log.info(catFactsDataCollection.toString())

}

fun requestDataFrom(baseUrl: String): CatFactResponse? {
    var dataReturn: CatFactResponse? = null

    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(CatFactService::class.java)
    val call = service.getCatFactData()

    call.enqueue(object : Callback<CatFactResponse> {
        override fun onResponse(call: Call<CatFactResponse>, response: Response<CatFactResponse>) {
            if (response.isSuccessful) {
                dataReturn = response.body()
            }
        }

        override fun onFailure(call: Call<CatFactResponse>, t: Throwable) {
            println(t.message)
        }
    })

    while (dataReturn == null) {
        println("uploading data...")
        Thread.sleep(300)
    }

    return dataReturn
}

