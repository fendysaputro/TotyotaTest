package id.phephen.toyotatest.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by phephen on 05,February,2021
 * https://github.com/fendysaputro
 */
object RetrofitClient {
    private const val BASE_URL = "http://202.77.105.101:1003/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiInstance = retrofit.create(ApiService::class.java)
}