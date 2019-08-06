package com.mayumi.loterica.service

import com.mayumi.loterica.model.*
import retrofit2.Call
import retrofit2.http.GET

interface WebAPI {

    @GET("?loteria=megasena&token=g3VTwTAWMNuQR0C")
    fun resultMega(): Call<Mega>

    @GET("?loteria=quina&token=g3VTwTAWMNuQR0C")
    fun resultQuina(): Call<Quina>

    @GET("?loteria=lotofacil&token=g3VTwTAWMNuQR0C")
    fun resultFacil(): Call<Facil>

    @GET("?loteria=lotomania&token=g3VTwTAWMNuQR0C")
    fun resultMania(): Call<Mania>

    @GET ("?loteria=duplasena&token=g3VTwTAWMNuQR0C")
    fun resultDupla(): Call<Dupla>

    @GET("?loteria=timemania&token=g3VTwTAWMNuQR0C")
    fun resultTime(): Call<Time>

    @GET("?loteria=diadesorte&token=g3VTwTAWMNuQR0C")
    fun resultDia(): Call<Dia>
}