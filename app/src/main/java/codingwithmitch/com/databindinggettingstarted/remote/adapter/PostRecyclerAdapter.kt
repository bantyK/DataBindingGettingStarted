package codingwithmitch.com.databindinggettingstarted.remote.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import codingwithmitch.com.databindinggettingstarted.databinding.PostListItemBinding
import codingwithmitch.com.databindinggettingstarted.models.Post

/**
 * Created by Banty on 17/09/18.
 */
class PostRecyclerAdapter(val postList: List<Post>) : RecyclerView.Adapter<PostRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PostListItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(postList[position])

    inner class ViewHolder(val binding: PostListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            with(binding) {
                postTitle.text = post.title
                postDescription.text = post.body
            }
        }

    }

}