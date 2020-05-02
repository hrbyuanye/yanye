package com.yuanye.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
/**
 * 设置 actvity ContenxtView
 */
public @interface ContontView {
    int value() ;
}
