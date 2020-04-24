package frame.com.libcommon.manager.img;

import android.content.Context;
import android.widget.ImageView;

/**
 *  下载图片
 */
public interface ILoaderImg {

    void loadImg(Context context , String url , ImageView imageView) ;
}
