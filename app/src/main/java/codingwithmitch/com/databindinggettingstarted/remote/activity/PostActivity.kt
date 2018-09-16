package codingwithmitch.com.databindinggettingstarted.remote.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import codingwithmitch.com.databindinggettingstarted.R
import codingwithmitch.com.databindinggettingstarted.databinding.ActivityPostBinding
import codingwithmitch.com.databindinggettingstarted.listeners.HttpResponseListener
import codingwithmitch.com.databindinggettingstarted.models.Post
import codingwithmitch.com.databindinggettingstarted.remote.adapter.PostRecyclerAdapter
import codingwithmitch.com.databindinggettingstarted.remote.data.PostDataFetcher
import org.json.JSONArray
import org.json.JSONObject


class PostActivity : AppCompatActivity(), HttpResponseListener {

    private val TAG = "PostActivity"

    private lateinit var mBinding: ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_post)
        PostDataFetcher(listener = this).getData()
    }

    override fun responseReceived(response: String?) {
        Log.d(TAG, "Response : $response")
        val postList: MutableList<Post> = ArrayList()

        val array = JSONArray(response)

        for (i in 0..(array.length() - 1)) {
            val obj: JSONObject = array[i] as JSONObject
            val post = Post(obj.optString("title"), obj.optString("body"))
            postList.add(post)
        }
        val postRecyclerView = mBinding.postList
        postRecyclerView.layoutManager = LinearLayoutManager(this)
        postRecyclerView.setHasFixedSize(true)
        postRecyclerView.adapter = PostRecyclerAdapter(postList)
    }

}
