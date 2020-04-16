package frame.com.modle_reader.provider;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;

import frame.com.libcommon.I.IRoutPath;
import frame.com.libcommon.provider.IBijiProvider;
import frame.com.modle_reader.fragment.BiJiFragment;

@Route(path = IRoutPath.IProviderPath.BiJiPath,name =  IRoutPath.IProviderPath.BiJiName)
public class BiJiProvider implements IBijiProvider {
    @Override
    public Fragment getMainBiJiFragment() {
        return BiJiFragment.newInstance();
    }

    @Override
    public void init(Context context) {

    }
}
