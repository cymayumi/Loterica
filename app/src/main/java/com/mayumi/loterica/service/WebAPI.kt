package com.mayumi.loterica.service

import com.mayumi.loterica.model.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface WebAPI {

    @GET("resultado?loteria=megasena&token=g3VTwTAWMNuQR0C")
    suspend fun resultMega(): Response<Mega>

    @GET("resultado?loteria=quina&token=g3VTwTAWMNuQR0C")
    suspend fun resultQuina(): Response<Quina>

    @GET("resultado?loteria=lotofacil&token=g3VTwTAWMNuQR0C")
    suspend fun resultFacil(): Response<Facil>

    @GET("resultado?loteria=lotomania&token=g3VTwTAWMNuQR0C")
    suspend fun resultMania(): Response<Mania>

    @GET ("resultado?loteria=duplasena&token=g3VTwTAWMNuQR0C")
    suspend fun resultDupla(): Response<Dupla>

    @GET("resultado?loteria=timemania&token=g3VTwTAWMNuQR0C")
    suspend fun resultTime(): Response<Time>

    @GET("resultado?loteria=diadesorte&token=g3VTwTAWMNuQR0C")
    suspend fun resultDia(): Response<Dia>
}