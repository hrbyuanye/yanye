package com.yuanye.ioc.annotation;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@BaseListener(setListener = "setOnClickListener"
        , listenerType = View.OnClickListener.class
        , callMethod = "onClick")

public @interface OnClick {

    int[] value() default -1;
}
