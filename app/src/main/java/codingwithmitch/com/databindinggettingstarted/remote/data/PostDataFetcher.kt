package codingwithmitch.com.databindinggettingstarted.remote.data

import android.os.Handler
import android.os.Looper
import codingwithmitch.com.databindinggettingstarted.listeners.HttpResponseListener
import okhttp3.*
import java.io.IOException

/**
 * Created by Banty on 16/09/18.
 */
class PostDataFetcher(val listener: HttpResponseListener) {

    fun getData() {
        val client = OkHttpClient()

        val request : Request = Request.Builder()
                .url("http://jsonplaceholder.typicode.com/posts")
                .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                call.cancel()
            }

            override fun onResponse(call: Call, response: Response) {
                val response: String? = response.body()?.string()
                val handler = Handler(Looper.getMainLooper())
                Handler(Looper.getMainLooper()).post {
                    listener.responseReceived(response)
                }
            }
        })

    }
}