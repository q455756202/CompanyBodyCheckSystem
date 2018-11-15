package team.yingyingmonster.ccbs.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 16:37 2018/11/14
 * -
 **/
public class AnnotationUtil {
    /**
     * 切面中获取方法上的注解。
     * @param point 切点
     * @param clazz 注解类型
     * @param <T> 注解类型
     * @return 注解对象
     */
    public static <T extends Annotation> T getMethodAnnotation(JoinPoint point, Class<T> clazz) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        return method.getAnnotation(clazz);
    }
}
