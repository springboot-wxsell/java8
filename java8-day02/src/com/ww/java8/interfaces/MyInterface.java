package com.ww.java8.interfaces;

/**
 * @author WangWei
 * @Title: MyInterface
 * @ProjectName java8
 * @date 2019/1/18 19:33
 * @description:
 */
public interface MyInterface {

    default String getName() {
        return "呵呵呵";
    }

    static void show() {
        System.out.println("接口中的静态方法");
    }
}
