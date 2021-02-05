package id.phephen.toyotatest.network

import id.phephen.toyotatest.model.dataName
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by phephen on 05,February,2021
 * https://github.com/fendysaputro
 */
interface ApiService {
    @POST("centralapi/index.php/test")
    fun postData (@Body name: String) : Call<dataName>
}