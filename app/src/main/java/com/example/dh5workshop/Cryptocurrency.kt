package com.example.dh5workshop

import com.google.gson.annotations.SerializedName

data class Cryptocurrency (
    @SerializedName("rate") val rate: Double,
    @SerializedName("volume") val volume: Double,
    @SerializedName("sell") val sell: Double,
    @SerializedName("buy") val buy: Double
)
