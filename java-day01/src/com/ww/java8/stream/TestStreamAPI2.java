package com.ww.java8.stream;

import com.ww.java8.module.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by wangwei on 2019/1/16.
 */
public class TestStreamAPI2 {

    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("赵四", 28, 7777.77),
            new Employee("王五", 35, 8888.88),
            new Employee("于六", 38, 6666.66),
            new Employee("于六", 38, 6666.66),
            new Employee("于六", 38, 6666.66)
    ));


    /**
     *  筛选与切片
     *  filter——接收 Lambda， 从流中排除某些元素
     *  limie——截断流，使其元素不超过给定数量
     *  skip——跳过元素，返回一个扔掉了前n 个元素的流，若流中的元素不足n个，则返回一个空值， 与limit(n)互补
     *  distinct——筛选，通过流所生成的元素的hashcode() 和 equals() 去除重复元素
     */

    @Test
    public void test5() {
        employeeList.stream()
                .filter((x) -> x.getSalary() > 6000)
                .skip(2)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void test4() {
        employeeList.stream()
                .filter((e) -> e.getSalary() > 6000)
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        employeeList.stream()
                .filter((e) -> {
                    System.out.println("短路");
                    return e.getSalary() > 6000; //&& / ||
                })
                .limit(2).forEach(System.out::println);
    }

    // 内部迭代：迭代操作由 Stream API 完成
    @Test
    public void test1() {

        // 中间操作： 不会执行任何操作
        Stream<Employee> employeeStream = employeeList.stream().filter((e) -> e.getAge() > 35);
        // 终止操作：一次性执行全部内容， 即：“惰性求值”
        employeeStream.forEach(System.out::println);
        // now
        employeeList.stream().filter((e) -> e.getAge() > 35).forEach(System.out::println);

    }

    // 外部迭代
    @Test
    public void test2() {
        Iterator<Employee> employeeIterator = employeeList.iterator();
        while (employeeIterator.hasNext()) {
            System.out.println(employeeIterator.next());
        }
    }
}
