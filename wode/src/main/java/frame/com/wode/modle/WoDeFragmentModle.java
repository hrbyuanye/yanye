package frame.com.wode.modle;

import android.content.Context;
import android.content.Intent;

import frame.com.libcommon.base.AppManager;
import frame.com.libcommon.mvp.BaseModel;
import frame.com.libcommon.util.log.KLog;
import frame.com.wode.contract.WoDeFragmentContract;

public class WoDeFragmentModle extends BaseModel implements WoDeFragmentContract.IModel {

    public WoDeFragmentModle(Context context) {
        super(context);
    }

    @Override
    public void gotoWifi() {

        //判断设备类型进行跳转
    }

    @Override
    public void gotoTest(Class<?> clas) {
        KLog.e("gotoTest ..."+clas.getName());
        Intent intent = new Intent(AppManager.getAppManager().currentActivity(), clas);
        AppManager.getAppManager().currentActivity().startActivity(intent);
    }


    @Override
    public void gotoSetting() {
        //判断设备类型进行跳转
    }
}
