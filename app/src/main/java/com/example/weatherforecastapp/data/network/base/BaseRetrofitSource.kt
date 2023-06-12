package com.example.weatherforecastapp.data.network.base

import com.example.weatherforecastapp.domain.common.BackendException
import com.example.weatherforecastapp.domain.common.ConnectionException
import com.example.weatherforecastapp.domain.common.ParseBackendResponseException
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonEncodingException
import okio.IOException
import retrofit2.HttpException


open class BaseRetrofitSource(
    retrofitConfig: RetrofitConfig
) {

    val retrofit = retrofitConfig.retrofit

    suspend fun <T> wrapRetrofitExceptions(block: suspend () -> T): T {
        return try {
            block()
        } catch (e: JsonDataException){
            throw ParseBackendResponseException(e)
        } catch (e: JsonEncodingException){
            throw ParseBackendResponseException(e)
        } catch (e: HttpException) {
            throw BackendException(e.code())
        } catch (e: IOException) {
            throw ConnectionException(e)
        }
    }

}