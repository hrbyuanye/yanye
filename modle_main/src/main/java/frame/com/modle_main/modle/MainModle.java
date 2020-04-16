package frame.com.modle_main.modle;

import android.content.Context;

import frame.com.libcommon.mvp.BaseModel;
import frame.com.modle_main.contract.MainlContract;

public class MainModle extends BaseModel implements MainlContract.IModel {
    public MainModle(Context context) {
        super(context);
    }


    @Override
    public boolean downloadDb() {
        return false;
    }

    @Override
    public boolean uploadDb() {
        return false;
    }

    @Override
    public boolean logInMsg() {
        return false;
    }

    @Override
    public boolean logOutMsg() {
        return false;
    }
}
