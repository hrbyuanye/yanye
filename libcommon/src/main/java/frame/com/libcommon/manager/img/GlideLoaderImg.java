package frame.com.libcommon.manager.img;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import frame.com.libcommon.R;

/**
 * glide 加载图片
 */
public class GlideLoaderImg implements ILoaderImg {

    @Override
    public void loadImg(Context context, String url, ImageView imageView) {

                Glide.with(imageView.getContext())
                .load(url)
                .apply(new RequestOptions().
                        centerCrop().
                        placeholder(R.drawable.ic_launcher_background).
                        error(R.drawable.ic_launcher_background).
                        diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(imageView);

    }
}
