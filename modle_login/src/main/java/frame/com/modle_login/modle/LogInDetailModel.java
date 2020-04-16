package frame.com.modle_login.modle;

import android.content.Context;

import frame.com.libcommon.mvp.BaseModel;
import frame.com.modle_login.bean.LogInDetailBean;
import frame.com.modle_login.contract.LogInDetailContract;

/**
 * 负责网络请求的实体封装
 */
public class LogInDetailModel extends BaseModel implements LogInDetailContract.IModel {
    public LogInDetailModel(Context context) {
        super(context);
    }

    /**
     * 网络请求
     * @param account
     * @param pwd
     * @return
     */
    @Override
    public LogInDetailBean getLogInResult(String account, String pwd) {
        return new LogInDetailBean("yuanye", "30");
    }
}
