package com.project.segunfrancis.remote.api

import com.project.segunfrancis.remote.model.BaseResponse
import retrofit2.http.GET

/**
 * Created by SegunFrancis
 */

interface CoinsApi {
    @GET("coins")
    suspend fun getCoins(): BaseResponse
}