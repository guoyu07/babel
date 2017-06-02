package com.babel.web.common.annotation;

import com.babel.web.common.ResourceTypeEnum;

import java.lang.annotation.*;

/**
 * Created by allen on 2017/6/2.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResourceType {
  ResourceTypeEnum value() default ResourceTypeEnum.ACTION;
}
