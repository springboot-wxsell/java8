package com.ww.java8.stream;

import com.ww.java8.module.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author WangWei
 * @Title: TestSteamAPI1
 * @ProjectName java8
 * @date 2019/1/15 19:47
 * @description:
 *  一、Stream 的三个操作步骤：
 *
 *  1. 创建stream
 */
public class TestSteamAPI1 {

    @Test
    public void test1() {
        // 1. 可以通过 Collection 系列集合提供的 stream() 或者 paralletStream()
        List<String> list = new ArrayList<>();
        Stream<String> stringStream =  list.stream();
        // 2.通过 Arrays 中的静态方法stream() 获取数组流

        Employee[] employees = new Employee[10];
        Stream<Employee> employeeStream = Arrays.stream(employees);

        // 3. 通过Stream 类中的静态方法of
        Stream<String> strStream = Stream.of("aa", "bb", "cc");

        // 4. 创建无限流
        // 迭代
        //Stream<Integer> integerStream = Stream.iterate(0, (x) -> x + 2);
        //integerStream.forEach(System.out::println);
        Stream.iterate(0, (x) -> x + 2).limit(10).forEach(System.out::println);
        // 生成
        Stream.generate(() -> Math.random()).limit(5).forEach(System.out::println);
    }
}
