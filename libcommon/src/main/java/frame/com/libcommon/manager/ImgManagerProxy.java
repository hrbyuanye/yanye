package frame.com.libcommon.manager;

import android.content.Context;
import android.widget.ImageView;

import frame.com.libcommon.manager.img.ILoaderImg;

/**
 * 下载图片
 */
public class ImgManagerProxy  implements ILoaderImg {

    private static volatile ImgManagerProxy instance ;
    private ILoaderImg downLoader ;

    public static  ImgManagerProxy getInstance(){

        if (instance == null){

            synchronized (ImgManagerProxy.class){
                if (instance == null){
                    instance = new ImgManagerProxy() ;
                }
            }
        }
        return  instance ;
    }

    public void init(ILoaderImg downLoader){
        this.downLoader = downLoader ;
    }

    @Override
    public void loadImg(Context context, String url, ImageView imageView) {
        downLoader.loadImg(context ,url ,imageView);
    }
}
