package com.ww.java8.method;

import com.ww.java8.module.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * @author WangWei
 * @Title: TestMethodRef
 * @ProjectName java8
 * @date 2019/1/15 18:28
 * @description:
 *
 * 一、方法引用： 若 Lambda 体中的内容有方法已经实现了，我们可以使用“方法引用”
 *                              (可以理解为 方法引用是 Lambda 表达式的另一种表现形式)
 *
 * 主要有三种语法格式：
 *
 * 对象::实例方法名
 *
 * 类::静态方法名
 *
 * 类::实例方法名
 *
 * 注意：
 *      1. Lambda 体中调用的方法参数列表与返回值类型，要与函数式接口中的抽象方法的函数列表和返回值类型保持一致！
 *      2. 若 Lambda 参数类表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时, 可以使用 ClassName:: method
 *
 *  二、构造器引用
 *      格式：
 *          ClassName :: new;
 *
 *   注意：
 *      1. 需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致！
 *
 *  三、数组引用
 *      格式：
 *          Type :: new;
 *
 *
 */
public class TestMethodRef {
    @Test
    public void test7() {
        // old
        Function<Integer, String[]> function = (x) -> new String[x];

        // now
        Function<Integer, String[]> function1 = String[]::new;
        System.out.println(function1.apply(20).length);
    }


    // 构造器引用
    @Test
    public void test6() {
        BiFunction<Integer, Double, Employee> bf = Employee::new;
    }
    @Test
    public void test5() {
        // old
        Supplier<Employee> sup = () -> new Employee();

        // now
        Supplier<Employee> sup2 = Employee::new;
    }


    // 类::实例方法名
    @Test
    public void test4() {
        // old
        BiPredicate<String, String> predicate = (x, y) -> x.equals(y);

        // now
        BiPredicate<String, String> predicate2 = String::equals;
    }
    // 类::静态方法名
    @Test
    public void test3() {
        // old
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);

        // now
        Comparator<Integer> comparator2 = Integer::compare;
        int compare = comparator2.compare(4, 5);
        System.out.println(compare);
    }

    // 对象::实例语法格式
    @Test
    public void test1() {
        Consumer<String> consumer = System.out::println;
        consumer.accept("abcdef");
    }

    @Test
    public void test2() {
        Employee employee = new Employee();
        Supplier<String> sup = employee::getName;
        System.out.println(sup.get());

    }
}
