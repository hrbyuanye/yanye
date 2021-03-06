package com.yuanye.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 注解的 多态  使用到BaseListener 都是他的子类
 *  简单解释
 *  b exntend  a
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE) //作用域 注解身上
public @interface BaseListener {

    //        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    String  setListener() ; //设置View.setOnclickListener() ;发方法名称
    Class<?> listenerType() ;// 接口类型
    String  callMethod() ; // 接口方法
}
