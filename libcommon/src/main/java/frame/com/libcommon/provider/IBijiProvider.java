package frame.com.libcommon.provider;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface IBijiProvider extends IProvider {
    Fragment getMainBiJiFragment();
}
