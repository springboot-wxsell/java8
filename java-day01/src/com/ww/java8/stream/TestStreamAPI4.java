package com.ww.java8.stream;

import com.ww.java8.module.Employee;
import jdk.nashorn.internal.ir.IdentNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author WangWei
 * @Title: TestStreamAPI4
 * @ProjectName java8
 * @date 2019/1/17 15:22
 * @description:
 */
public class TestStreamAPI4 {

    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.FREE),
            new Employee("赵四", 28, 7777.77, Employee.Status.BUSY),
            new Employee("王五", 35, 8888.88, Employee.Status.VOCATION),
            new Employee("于六", 38, 6666.66, Employee.Status.BUSY),
            new Employee("于六", 38, 6666.66, Employee.Status.BUSY)
    ));

    /**
     * 给定[1, 2, 3, 4, 5]， 返回[1, 4, 9, 16, 25]
     */
    @Test
    public void test() {
        Integer[] num = new Integer[]{1, 2, 3, 4, 5};
        Arrays.stream(num).map((x) -> x * x).forEach(System.out::println);
    }

    /**
     *  怎样用 map 和 reduce 方法数一数流中有多少个Employee
     */
    @Test
    public void test2() {
        Integer sum = employeeList.stream().map((e) -> 1).reduce(0, Integer::sum);
        System.out.println(sum);

        Optional<Integer> sum1 = employeeList.stream().map((e) -> 1).reduce(Integer::sum);
        System.out.println(sum1.get());
    }
}
