package frame.com.wode.presenter;

import android.content.Context;

import frame.com.libcommon.mvp.BasePresenter;
import frame.com.wode.contract.WoDeNetTestContract;
import frame.com.wode.modle.WoDeTestNetAcrivityModle;

public class WodeNetTestActivityPresenter  extends BasePresenter<WoDeTestNetAcrivityModle ,WoDeNetTestContract.IView>  implements WoDeNetTestContract.IPresenter{
    public WodeNetTestActivityPresenter(Context context) {
        super(context);
    }

    @Override
    public WoDeTestNetAcrivityModle initModel() {
        return new WoDeTestNetAcrivityModle(mContext);
    }

    @Override
    public void isDeviceBind(String deviceId) {
        mModel.isDeviceBind(deviceId);
    }
}
