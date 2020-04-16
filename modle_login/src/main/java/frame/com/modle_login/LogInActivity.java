package frame.com.modle_login;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import frame.com.libcommon.I.IRoutPath;
import frame.com.libcommon.base.BaseMvpActivity;
import frame.com.libcommon.event.BaseActivityEvent;
import frame.com.libcommon.util.log.KLog;
import frame.com.modle_login.bean.LogInDetailBean;
import frame.com.modle_login.contract.LogInDetailContract;
import frame.com.modle_login.modle.LogInDetailModel;
import frame.com.modle_login.presenter.LogInDetaiLPresenter;

@Route(path = IRoutPath.ILogInPath.ActivityLogInPath, name = IRoutPath.ILogInPath.ActivityLogInName)
public class LogInActivity extends BaseMvpActivity<LogInDetailModel, LogInDetailContract.IView, LogInDetaiLPresenter> implements LogInDetailContract.IView, View.OnClickListener {


    @Override
    public View bindLayout() {
        return inflate(R.layout.activity_login);
    }

    @Override
    public void initView() {
        this.findViewById(R.id.btn_login).setOnClickListener(this) ;

    }

    @Override
    public void loadData() {

    }

    @Override
    public LogInDetaiLPresenter initPresenter() {
        return new LogInDetaiLPresenter(this);
    }


    @Override
    public void showLogInDetail(LogInDetailBean logInDetail) {
        KLog.e("请求返回结果。。。logInDetail:"+logInDetail.toString());
        if (logInDetail!=null && logInDetail.getAge().equals("30")){
//            ARouter.getInstance().build("/Home/main").navigation();
            ARouter.getInstance().build(IRoutPath.IMainPath.ActivityModleMainPath).navigation();
        }
    }

    @Override
    public void showNoDataView() {

    }

    @Override
    public void showInitLoadView() {

    }

    @Override
    public void hideInitLoadView() {

    }

    @Override
    public void onClick(View v) {
        if (R.id.btn_login == v.getId()) {
            mPresenter.getLogInResult("袁野" ,"123");
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public <T> void onEvent(BaseActivityEvent<T> event) {
    }

}