package com.example.dh5workshop

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CurrencyAPI {

    @GET("info")
    fun getCurrencies(): Observable<Map<String, Cryptocurrency>>

    companion object {

        fun create(): CurrencyAPI {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.quadrigacx.com/public/")
                .build()

            return retrofit.create(CurrencyAPI::class.java)
        }
    }
}
