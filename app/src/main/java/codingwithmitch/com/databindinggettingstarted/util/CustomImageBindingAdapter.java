package codingwithmitch.com.databindinggettingstarted.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import codingwithmitch.com.databindinggettingstarted.R;

/**
 * Created by Banty on 16/09/18.
 */
public class CustomImageBindingAdapter {

    @BindingAdapter("imageUrl")
    public static void setImage(ImageView image, int resId) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        Glide.with(image.getContext())
                .setDefaultRequestOptions(options)
                .load(resId)
                .into(image);
    }
}
