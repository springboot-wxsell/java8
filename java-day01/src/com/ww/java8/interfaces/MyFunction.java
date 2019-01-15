package com.ww.java8.interfaces;

/**
 * @author WangWei
 * @Title: MyFuncation
 * @ProjectName java8
 * @date 2019/1/14 15:49
 * @description:
 */
@FunctionalInterface
public interface MyFunction<T> {

    Integer getValue(Integer value);
}
