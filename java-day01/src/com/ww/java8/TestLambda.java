package com.ww.java8;

import com.ww.java8.interfaces.MyPredicate;
import com.ww.java8.interfaces.impl.FilterEmployeeByAge;
import com.ww.java8.interfaces.impl.FilterEmployeeBySalary;
import com.ww.java8.module.Employee;
import org.junit.Test;

import java.util.*;

/**
 * @author WangWei
 * @Title: TestLambda
 * @ProjectName java8
 * @date 2019/1/11 10:13
 * @description:
 */
public class TestLambda {

    @Test
    public void test1() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }


    @Test
    public void test2() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }


    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.FREE),
            new Employee("赵四", 28, 7777.77, Employee.Status.BUSY),
            new Employee("王五", 35, 8888.88, Employee.Status.VOCATION),
            new Employee("于六", 38, 6666.66, Employee.Status.BUSY)
    ));


    // 需求：获取当前公司中员工年龄大于 35岁的员工信息
    public List<Employee> filterEmployees(List<Employee> employeeList) {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getAge() >= 35) {
                employees.add(employee);
            }
        }
        return employees;
    }

    @Test
    public void test3() {
        List<Employee> employees = filterEmployees(employeeList);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    //需求: 获取当前公司员工工资大于5000 的员工信息

    // 优化方式一: 策略设计模式
    @Test
    public void test4() {
        List<Employee> list = filterEmployees1(this.employeeList, new FilterEmployeeByAge());
        for (Employee employee : list) {
            System.out.println(employee);
        }
        System.out.println("--------------------------------------");
        List<Employee> employeeList1 = filterEmployees1(employeeList, new FilterEmployeeBySalary());
        for (Employee employee : employeeList1) {
            System.out.println(employee);
        }
    }

    public List<Employee> filterEmployees1(List<Employee> employeeList, MyPredicate<Employee> mp) {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (mp.compare(employee)) {
                employees.add(employee);
            }
        }
        return employees;
    }

    // 优化方式二: 匿名内部类

    @Test
    public void test5() {
        List<Employee> list = filterEmployees1(employeeList, new MyPredicate<Employee>() {
            @Override
            public boolean compare(Employee employee) {
                return employee.getSalary() <= 8000;
            }
        });
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    // 优化方式三：Lambda 表达式
    @Test
    public void test6() {
        List<Employee> list = filterEmployees1(employeeList, (e) -> e.getSalary() <= 8000);
        list.forEach(System.out::println);
    }

    // 优化方式四：只有实体类和employeeList, Stream API
    @Test
    public void test7() {
        employeeList.stream()
                .filter(e -> e.getSalary() >= 8000)
                .limit(1)
                .forEach(System.out::println);
        System.out.println("---------------------");
        employeeList.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

}
