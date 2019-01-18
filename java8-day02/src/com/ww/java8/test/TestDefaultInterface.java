package com.ww.java8.test;

import com.ww.java8.interfaces.MyInterface;
import com.ww.java8.interfaces.SubClass;

/**
 * @author WangWei
 * @Title: TestDefault
 * @ProjectName java8
 * @date 2019/1/18 17:55
 * @description:
 */
public class TestDefaultInterface {

    // 接口默认的方法: "类优先" 原则
    public static void main(String[] args) {
        SubClass sc = new SubClass();
        System.out.println(sc.getName());

        MyInterface.show();
    }


}
