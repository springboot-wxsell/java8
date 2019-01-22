package com.ww.java8.test;

import com.ww.java8.utils.MyAnnotation;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author WangWei
 * @Title: TestAnnotation
 * @ProjectName java8
 * @date 2019/1/22 16:14
 * @description: 重复注解与类型注解
 */
public class TestAnnotation {

    @Test
    public void test1() throws NoSuchMethodException {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method m1 = clazz.getMethod("show", String.class);
        MyAnnotation[] annotationsByType = m1.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation : annotationsByType) {
            System.out.println(myAnnotation.value());
        }
    }

    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show(@MyAnnotation("abc") String str) {

    }
}
