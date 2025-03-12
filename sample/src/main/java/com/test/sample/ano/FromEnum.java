package com.test.sample.ano;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 值 来自 哪个枚举类
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface FromEnum {
    /**
     * 值 来自 哪个枚举类
     */
    Class<?> value();
}
