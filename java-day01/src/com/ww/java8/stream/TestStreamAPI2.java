package com.ww.java8.stream;

import com.ww.java8.module.Employee;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by wangwei on 2019/1/16.
 */
public class TestStreamAPI2 {

    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.FREE),
            new Employee("赵四", 28, 7777.77, Employee.Status.BUSY),
            new Employee("王五", 35, 8888.88, Employee.Status.VOCATION),
            new Employee("于六", 38, 6666.66, Employee.Status.BUSY),
            new Employee("于六", 38, 6666.66,Employee.Status.BUSY),
            new Employee("于六", 38, 6666.66,Employee.Status.BUSY)
    ));

    /**
     *  排序：
     *      sorted()——自然排序(Comparable)
     *      sorted(Comparator com)——定制排序
     */
    @Test
    public void test8() {
        List<String> strings = Arrays.asList("ccc", "aaa", "bbb", "fff", "eee");

        strings.stream().sorted().forEach(System.out::println);

        employeeList.stream().sorted((e1, e2) -> {
            if (e1.getAge()==e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            }else{
                return -Integer.compare(e1.getAge(), e2.getAge());
            }
        }).forEach(System.out::println);
    }


    /**
     *  映射：
     *  map——接收Lambda，将元素转换为其他形式或提取信息。
     *          接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射为一个新的元素
     *  flatMap——接收一个函数作为参数，经流中的每个值都换成另一个流，然后把所有的流连接成一个流
     */

    @Test
    public void test6() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        list.stream().map((str) -> str.toUpperCase()).forEach(System.out::println );
        System.out.println("----------------------------");
        employeeList.stream().map(Employee::getName).forEach(System.out::println);

        System.out.println("-------------------------------");
        // old
        Stream<Stream<Character>> stream = list.stream().map(TestStreamAPI2::filterCharacter);
        stream.forEach((sm) -> {
            sm.forEach(System.out::println);
        });

        // now
        Stream<Character> characterStream = list.stream().flatMap(TestStreamAPI2::filterCharacter);
        characterStream.forEach(System.out::println);
    }

    @Test
    public void test7() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");

        List list2 = new ArrayList();
        list2.add(11);
        list2.add(22);
        list2.addAll(list);

        System.out.println(list2);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

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
