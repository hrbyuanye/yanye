package frame.com.modle_main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import frame.com.libcommon.I.IRoutPath;
import frame.com.libcommon.event.BaseActivityEvent;
import frame.com.libcommon.util.log.KLog;

public class ModleMainSplish extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modle_splish);
         this.findViewById(R.id.btn_splish).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 ARouter.getInstance().build(IRoutPath.ILogInPath.ActivityLogInPath).navigation();
             }
         });
    }

}
