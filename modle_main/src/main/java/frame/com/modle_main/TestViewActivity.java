package frame.com.modle_main;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;

import frame.com.libcommon.BaseApplication;


public class TestViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( LayoutInflater.from(this).inflate(R.layout.activity_modle_main_test, null));
    }
}
