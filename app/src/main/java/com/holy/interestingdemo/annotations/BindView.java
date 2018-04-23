package com.holy.interestingdemo.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Created by DR on 2018/4/23.
 * 绑定控件的注解
 */
@Target({METHOD, TYPE, PARAMETER,FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BindView {
    int id();
}
