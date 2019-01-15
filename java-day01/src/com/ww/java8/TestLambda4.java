package com.ww.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author WangWei
 * @Title: TestLambda4
 * @ProjectName java8
 * @date 2019/1/14 16:15
 * @description: java8 中内置的四大核心函数式接口
 *
 *                  Consumer<T>: 消费型接口
 *                      void acept(T t)
 *                  Supplier<T>: 供给型接口
 *                      T get()
 *                  Function<T, R>: 函数型接口
 *                      R apply(T t)
 *                  Predicate<T>: 断言型接口
 *                      boolean test(T t)
 *
 *
 */
public class TestLambda4 {

    // Predicate<T> 断言型接口:
    @Test
    public void test4() {
        List<String> list = Arrays.asList("hello", "world", "lambda", "wangwei", "ok", "www");
        filterStr(list, (x) -> x.length() > 3).forEach(System.out::println);
    }

    // 需求： 将满足条件的字符串，放入集合中
    public List<String> filterStr(List<String> strList, Predicate<String> predicate){
        List<String> list = new ArrayList<>();
        for (String str : strList) {
            if (predicate.test(str)) {
                list.add(str);
            }
        }
        return list;
    }

    // Function<T, R> 函数型接口:
    @Test
    public void test3() {
        System.out.println(strHandler("  a b c d e f ", (str) -> str.replace(" ", "")));
    }

    // 需求：用于处理字符串
    public String strHandler(String str, Function<String, String> fun) {
       return fun.apply(str);
    }

    // Supplier<T> 供给型接口:
    @Test
    public void test2() {
       getNumList(10, () -> (int) (Math.random() * 100)).forEach(System.out::println);
    }

    // 需求：产生指定个数整数，放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    // Consumer<T> 消费型接口：
    @Test
    public void test1() {
        happy(100, (x) -> System.out.println(x));
    }

    public void happy(double money, Consumer<Double> comsumer) {
        comsumer.accept(money);
    }
}
