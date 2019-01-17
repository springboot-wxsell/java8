package com.ww.java8.stream;

import a.e.E;
import com.ww.java8.module.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author WangWei
 * @Title: TestStreamAPI3
 * @ProjectName java8
 * @date 2019/1/16 15:16
 * @description: 终止操作
 */
public class TestStreamAPI3 {

    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.FREE),
            new Employee("赵四", 28, 7777.77, Employee.Status.BUSY),
            new Employee("王五", 35, 8888.88, Employee.Status.VOCATION),
            new Employee("于六", 38, 6666.66, Employee.Status.BUSY),
            new Employee("于六", 38, 6666.66, Employee.Status.BUSY)
    ));
    @Test
    public void test10() {
        String str = employeeList.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(str);
    }

    @Test
    public void test9(){
        DoubleSummaryStatistics dss = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getAverage());
    }

    // 分区
    @Test
    public void test8() {
        Map<Boolean, List<Employee>> map =  employeeList.stream().collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000));
        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    // 多级分组
    @Test
    public void test7() {
        Map<Employee.Status, Map<String, List<Employee>>> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
            if (e.getAge() <= 35) {
                return "青年";
            } else if (e.getAge() <= 50) {
                return "中年";
            } else {
                return "老年";
            }
        })));
        map.forEach((k, v) -> System.out.println(k + " : " + v));

    }


    // 分组
    @Test
    public void test6(){
        Map<Employee.Status, List<Employee>> group = employeeList.stream().collect(Collectors.groupingBy(Employee::getStatus));
        group.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    /**
     *  收集：
     *      collect——将流转化为其他形式。接收一个 Collector接口的实现,用于给Stream中元素做汇总的方法
     */

    @Test
    public void test5() {
        // 总数
        Long count = employeeList.stream().collect(Collectors.counting());
        System.out.println(count);
        System.out.println("----------------------");
        // 平均值
        Double salary = employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(salary);
        System.out.println("------------------------ ");
        // 总和
        employeeList.stream().collect(Collectors.summingDouble(Employee::getSalary));

        // 最大值
        Optional<Employee> max = employeeList.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(max.get());

        // 最小值(工资)
        Optional<Double> min = employeeList.stream().map(Employee::getSalary).collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());

    }
    @Test
    public void test4() {
       employeeList.stream().map(Employee::getName).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("--------------------------------------");
        employeeList.stream().map(Employee::getName).collect(Collectors.toSet()).forEach(System.out::println);
        System.out.println("---------------------------------------");
        // 特殊集合
        employeeList.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new)).forEach(System.out::println);
    }

    /**
     *  归约：
     *      reduce(T identity, BinaryOperator) / reduce(BinaryOperator)——可以将流中的元素反复结合起来，得到一个新值
     *
     */

    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
        System.out.println("----------------------------");
        Optional<Double> reduce = employeeList.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce.get());
    }

    /**
     *  查找与匹配：
     *   allMatch——检查是否匹配所有的元素
     *   anyMatch——检查是否配置一个元素
     *   noneMatch——检查是否没有匹配所有的元素
     *   findFirst——返回第一个元素
     *   findAny——返回当前流中的任意元素
     *   count——返回流中元素的总个数
     *   max——返回流中的最大值
     *   min——返回流中的最小值
     */

    @Test
    public void test2() {
        long count = employeeList.stream().count();
        System.out.println(count);
        System.out.println("--------------------------");
        Optional<Employee> max = employeeList.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max);
        System.out.println("----------------------------");

        Optional<Double> min = employeeList.stream().map(Employee::getSalary).min(Double::compare);
        System.out.println(min.get());
    }

    @Test
    public void test1() {
        boolean b = employeeList.stream().allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);

        System.out.println("-----------------------------------");
        boolean b1 = employeeList.stream().anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);

        System.out.println("-----------------------------------");
        boolean b2 = employeeList.stream().noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);
        System.out.println("-----------------------------------");

        Optional<Employee> first = employeeList.stream().sorted((e1, e2) -> e1.getSalary().compareTo(e2.getSalary().doubleValue())).findFirst();
        System.out.println(first.get());
        System.out.println("------------------------------------");

        Optional<Employee> any = employeeList.parallelStream().filter((e) -> e.getStatus().equals(Employee.Status.FREE)).findAny();
        System.out.println(any.get());
    }

}
