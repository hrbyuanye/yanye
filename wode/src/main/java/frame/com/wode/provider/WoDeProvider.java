package frame.com.wode.provider;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;

import frame.com.libcommon.I.IRoutPath;
import frame.com.libcommon.provider.IWoDeProvider;
import frame.com.wode.fragment.WoDeFragment;

@Route(path = IRoutPath.IProviderPath.WoDePath, name = IRoutPath.IProviderPath.WoDeName)
public class WoDeProvider implements IWoDeProvider {
    @Override
    public Fragment getMainWoDeFragment() {
        return WoDeFragment.newInstance();
    }

    @Override
    public void init(Context context) {

    }
}
