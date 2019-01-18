package com.ww.java8.interfaces;

/**
 * @author WangWei
 * @Title: MyFun
 * @ProjectName java8
 * @date 2019/1/18 16:16
 * @description:
 */
public interface MyFun {

    default String getName() {
        return "哈哈哈";
    }
}
