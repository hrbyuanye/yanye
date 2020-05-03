package com.yuanye.ioc;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yuanye.ioc.annotation.ContontView;
import com.yuanye.ioc.annotation.OnClick;
import com.yuanye.ioc.annotation.ViewInject;

@ContontView(R.layout.activity_main)
public class MainActivity extends Activity {

    @ViewInject(R.id.tv_title)
    private Button textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InjectUtils.initLayout(this);
        InjectUtils.initView(this);
        InjectUtils.intClick(this);
//       setContentView(R.layout.activity_main);
        textView.setText("IOC。。hello");
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }



    @OnClick({R.id.tv_title})
    public void myClick(View view){

        Toast.makeText(MainActivity.this,"myClick" ,Toast.LENGTH_LONG) .show();
    }
}
