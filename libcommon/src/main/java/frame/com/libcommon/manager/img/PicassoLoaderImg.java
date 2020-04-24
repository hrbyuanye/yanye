package frame.com.libcommon.manager.img;


import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import frame.com.libcommon.R;

public class PicassoLoaderImg implements ILoaderImg {
    @Override
    public void loadImg(Context context, String url, ImageView imageView) {

        Picasso.with(context).load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);

    }
}
