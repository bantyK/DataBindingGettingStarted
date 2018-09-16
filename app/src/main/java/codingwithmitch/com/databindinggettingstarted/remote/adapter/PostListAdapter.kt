package codingwithmitch.com.databindinggettingstarted.remote.adapter

import android.app.Activity
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import codingwithmitch.com.databindinggettingstarted.R
import codingwithmitch.com.databindinggettingstarted.databinding.PostListItemBinding
import codingwithmitch.com.databindinggettingstarted.models.Post

/**
 * Created by Banty on 16/09/18.
 */
class PostListAdapter(val postList: List<Post>, val context: Activity) : BaseAdapter() {

    private var binding: PostListItemBinding? = null

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.post_list_item, parent, false)
            binding = DataBindingUtil.bind(view)
            view?.tag = binding
        } else {
            binding = view?.tag as PostListItemBinding
        }

        binding?.post = getItem(position) as Post
        return binding?.root!!
    }

    override fun getItem(position: Int): Any {
        return postList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return postList.size
    }
}