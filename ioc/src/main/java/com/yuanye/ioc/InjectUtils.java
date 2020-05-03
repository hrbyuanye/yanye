package com.yuanye.ioc;

import android.view.View;

import com.yuanye.ioc.annotation.BaseListener;
import com.yuanye.ioc.annotation.ContontView;
import com.yuanye.ioc.annotation.ViewInject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
    public static void intClick(final Object activity) {
//        1. 获取所有方法

        Class<?> aClass = activity.getClass();
        Method[] methods = aClass.getDeclaredMethods();
//        2.查找当前的 方法是否包含 事件的 注解 --》BaseListener
        for (final Method acMethod : methods) {

            Annotation[] annotations = acMethod.getAnnotations(); //获取方法上的注解
            for (Annotation annotation : annotations) {

//                3. 获取注解字节码 判断是否有BaseListener的注解
//                 Class<?> annotationClass = annotation.getClass();
                Class<?> annotationClass = annotation.annotationType();
                BaseListener baseListener = annotationClass.getAnnotation(BaseListener.class);

                if (baseListener == null) {
                    continue;
                }


//                4.设置 setClick事件
                String setListener = baseListener.setListener();
                Class<?> listenerType = baseListener.listenerType();
                String callMethod = baseListener.callMethod();

//                5. 获取注解上的values
                //子类注解 可以认为是个普通类
                try {
                    Method methodVaule = annotationClass.getDeclaredMethod("value");
                    int[] viewIds = (int[]) methodVaule.invoke(annotation);

                    for (int id : viewIds) {
                        Method findViewById = aClass.getMethod("findViewById", int.class);

                        View view = (View) findViewById.invoke(activity, id);

                        Object proxyInstance = Proxy.newProxyInstance(listenerType.getClassLoader(), new Class[]{listenerType}, new InvocationHandler() {
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


                                System.out.println(" method.getName():"+ method.getName());
                                return acMethod.invoke(activity, args);
                            }
                        });

                        //设置 view .setOnclickListener
                       Method setClickMethod = view.getClass().getMethod(setListener ,listenerType) ;
                        setClickMethod.invoke(view ,proxyInstance) ;

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

    }

}
