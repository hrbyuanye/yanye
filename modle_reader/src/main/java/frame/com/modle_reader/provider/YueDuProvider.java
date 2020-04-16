package frame.com.modle_reader.provider;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;

import frame.com.libcommon.I.IRoutPath;
import frame.com.libcommon.provider.IYueDuProvider;
import frame.com.modle_reader.fragment.YueDuFragment;

@Route(path = IRoutPath.IProviderPath.YueDuPath, name = IRoutPath.IProviderPath.YueDuName)
public class YueDuProvider implements IYueDuProvider {
    @Override
    public Fragment getMainYueDuFragment() {
        return YueDuFragment.newInstance();
    }

    @Override
    public void init(Context context) {

    }
}
