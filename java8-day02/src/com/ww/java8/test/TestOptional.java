package com.ww.java8.test;

import com.ww.java8.module.Employee;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @author WangWei
 * @Title: TestOptional
 * @ProjectName java8
 * @date 2019/1/18 10:56
 * @description:
 */
public class TestOptional {

    /**
     * Optional 容器类的常用方法
     *  Optional.of(T t): 创建一个 Optional 实例
     *  Optional.empty(): 创建一个空的 Optional 实例
     *  Optional.ofNullable(T t): 若 t 不为null，创建 Optional 实例，否则创建空实例
     *  isPresent(): 判断是否包含值
     *  orElse(T t): 如果调用对象包含值，返回该值，否则返回t
     *  orElseGet(Supplier s): 如果调用对象包含值，返回该值，否则返回s获取的值
     *  map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()
     *  flatMap(Function mapper): 与map类似，要求返回的值必须的是Optional
     *
     */
    @Test
    public void test4(){
        Optional<Employee> op = Optional.ofNullable(new Employee("张三", 18, 888.88, Employee.Status.BUSY));
        Optional<String> str = op.map((e) -> e.getName());
        System.out.println(str);

        Optional<String> str2 = op.flatMap((e) -> Optional.of(e.getName()));
        System.out.println(str2);
    }

    // 传入什么就构建什么
    @Test
    public void test3(){
        Optional<Employee> op = Optional.ofNullable(null);
       /* if (op.isPresent()) {
            System.out.println(op.get());
        }*/

        Employee emp = op.orElse(new Employee("张三", 18, 888.88, Employee.Status.BUSY));
        System.out.println(emp);

        Employee employee = op.orElseGet(Employee::new);
        System.out.println(employee);
    }

    // 只是构建一个空的Optional
    @Test
    public void test2() {
        Optional<Employee> empty = Optional.empty();
        System.out.println(empty.get());
    }

    // 不能构建null
    @Test
    public void test1() {
        Optional<Employee> op = Optional.of(null);
        System.out.println(op.get());
    }
}
