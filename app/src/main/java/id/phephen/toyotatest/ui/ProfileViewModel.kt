package id.phephen.toyotatest.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.phephen.toyotatest.model.RequestData
import id.phephen.toyotatest.model.dataName
import id.phephen.toyotatest.network.RetrofitClient
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

/**
 * Created by phephen on 05,February,2021
 * https://github.com/fendysaputro
 */
class ProfileViewModel : ViewModel() {

    var onPostDataSuccess = MutableLiveData<dataName>()
    var onPostDataFailed = MutableLiveData<Map<Int, String>>()


    fun postData(name: String) {
        RetrofitClient.apiInstance.postData(name)
            .enqueue(object : Callback<dataName> {
                override fun onResponse(call: Call<dataName>, response: Response<dataName>) {
                    if (response.isSuccessful) {
                        onPostDataSuccess.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<dataName>, t: Throwable) {
                    Log.e("Error", t.message)
                }

            })
    }
}