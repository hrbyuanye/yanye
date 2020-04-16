package frame.com.zuoye.provider;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;

import frame.com.libcommon.I.IRoutPath;
import frame.com.libcommon.provider.IZuoYeProvider;
import frame.com.zuoye.fragment.ZuoYeFragment;

@Route(path = IRoutPath.IProviderPath.ZuoYePath, name = IRoutPath.IProviderPath.ZuoYeName)
public class ZuoYeProvider implements IZuoYeProvider {
    @Override
    public Fragment getMainZuoYeFragment() {
        return ZuoYeFragment.newInstance();
    }

    @Override
    public void init(Context context) {

    }
}
