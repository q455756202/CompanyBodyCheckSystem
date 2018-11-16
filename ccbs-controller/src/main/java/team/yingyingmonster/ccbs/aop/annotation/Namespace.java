package team.yingyingmonster.ccbs.aop.annotation;

import team.yingyingmonster.ccbs.service.servicebean.Constant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface Namespace {
    String name();
    long premissionLevel() default 0;
}
