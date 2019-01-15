package com.ww.java8.interfaces;

/**
 * @author WangWei
 * @Title: MyPredicate
 * @ProjectName java8
 * @date 2019/1/14 11:22
 * @description:
 */
@FunctionalInterface
public interface MyPredicate<T> {

    boolean compare(T t);
}
