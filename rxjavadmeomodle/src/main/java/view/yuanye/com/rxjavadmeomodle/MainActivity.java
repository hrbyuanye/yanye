package view.yuanye.com.rxjavadmeomodle;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import frame.com.libcommon.I.IRoutPath;
import frame.com.libcommon.base.BaseActivity;

@Route(path = IRoutPath.RxDemoPath.ActivityModleRxDemoMainPath, name = IRoutPath.RxDemoPath.ActivityModleMainRxDemoName)
public class MainActivity extends BaseActivity {


    @BindView(R2.id.btn_rx_demo_01)
    Button btnRxDemo01;
    @BindView(R2.id.btn_rx_demo_02)
    Button btnRxDemo02;

    @Override
    public View bindLayout() {
        return inflate(R.layout.activity_rxdemo);
    }

    @Override
    public void initView() {

    }

    @Override
    public void loadData() {

    }




    @OnClick({R2.id.btn_rx_demo_01, R2.id.btn_rx_demo_02})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.btn_rx_demo_01) {
            RxJavaDemos.demo_01_creat();

        } else if (i == R.id.btn_rx_demo_02) {
//            RxJavaDemos.demo_05_map();
//            RxJavaDemos.test_demo_flatMap();
            RxJavaDemos.test_demo_concatMap() ;
        }
    }
}
