package com.ww.java8;

import com.ww.java8.interfaces.MyFunction2;
import com.ww.java8.module.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author WangWei
 * @Title: TestLambda3
 * @ProjectName java8
 * @date 2019/1/14 15:56
 * @description:
 */
public class TestLambda3 {

    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.FREE),
            new Employee("赵四", 28, 7777.77, Employee.Status.BUSY),
            new Employee("王五", 35, 8888.88, Employee.Status.VOCATION),
            new Employee("于六", 38, 6666.66, Employee.Status.BUSY)
    ));

    @Test
    public void test1() {
        Collections.sort(employeeList, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        employeeList.forEach(System.out::println);
    }

    @Test
    public void test2() {
        operation(100L, 200L, (x, y) -> x + y);
    }

    // 需求：对于两个 Long 型数据进行处理
    public void operation(Long l1, Long l2, MyFunction2<Long, Long> mf) {
        System.out.println(mf.getValue(l1, l2));
    }
}
