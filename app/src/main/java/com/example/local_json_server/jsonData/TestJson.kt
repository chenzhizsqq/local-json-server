package com.json.server.jsonData

import android.util.Log
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.json.JSONObject

class TestJson {
    val TAG: String = javaClass.simpleName

    fun post(): String {
        var status:String = "-1"
        val client: OkHttpClient = OkHttpClient()

        //因为如果用localhost时，就会java.net.ConnectException: Failed to connect to localhost/127.0.0.1:3000
        //所以这里就用http://10.0.2.2来代替了
        val url:String = "http://10.0.2.2:3000/posts"

        try {
            val jsonObject = JSONObject()
            jsonObject.put("test ok?", "yes,ok !!!")
            val body = jsonObject.toString()
                .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())

            val request = Request.Builder().url(url).post(body).build()
            val response: Response = client.newCall(request).execute();
            if (response.isSuccessful) {

                val json:String = response.body!!.string()
                val mJsonResult = JSONObject(json)
                Log.e(TAG, "!!!! $TAG:$mJsonResult")

                return status
            }else{
                Log.e(TAG, "!!!! $TAG postRequest: false code:" +response.code  )
            }
        }catch (e: Exception){
            Log.e(TAG, e.toString())
        }
        return status
    }
}

