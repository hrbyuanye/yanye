package frame.com.modle_reader.provider;


import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;

import frame.com.libcommon.I.IRoutPath;
import frame.com.libcommon.provider.IJiaoCaiProvider;
import frame.com.modle_reader.fragment.JiaoCaiFragment;

@Route(path = IRoutPath.IProviderPath.JiaoCaiPath, name = IRoutPath.IProviderPath.JiaoCaiName)
public class JiaoCaiProvider implements IJiaoCaiProvider {
    @Override
    public Fragment getMainJiaoCaiFragment() {
        return JiaoCaiFragment.newInstance();
    }

    @Override
    public void init(Context context) {

    }
}
