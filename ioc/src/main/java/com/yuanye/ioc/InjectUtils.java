package com.yuanye.ioc;

import android.view.View;

import com.yuanye.ioc.annotation.ContontView;
import com.yuanye.ioc.annotation.ViewInject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class InjectUtils {

    /**
     * setConteView
     *
     * @param activity
     */
    public static void initLayout(Object activity) {
        //1. 获取注解
        Class<?> aClass = activity.getClass();
        ContontView contontView = aClass.getAnnotation(ContontView.class);
        int layoutId = contontView.value();
        //2 setContentView(R.layout.activity_main);
        try {
            // Method method = activity.getClass().getDeclaredMethod("setContentView" ,int.class) ;
            Method method = aClass.getMethod("setContentView", int.class);

            method.invoke(activity, layoutId); //执行setContView
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射findViewById
     *
     * @param activity
     */
    public static void initView(Object activity) {

        //1.获取所有字段
        Class<?> aClass = activity.getClass();
        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            ViewInject viewInject = field.getAnnotation(ViewInject.class);
            if (viewInject == null) {
                continue;
            }

            int viewId = viewInject.value();
            //2. findViewById
            try {
                Method method = aClass.getMethod("findViewById", int.class);
                View view = (View) method.invoke(activity, viewId);
                //3.设置值

                field.setAccessible(true);
                field.set(activity, view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * setClick
     */
    public static void intClick(Object activity) {
//        1. 获取所有方法

        Class<?> aClass = activity.getClass();
        Method [] methods = aClass.getDeclaredMethods();
//        2.查找当前的 方法是否包含 事件的 注解 --》BaseListener
        for (Method method : methods){


        }

    }

}
