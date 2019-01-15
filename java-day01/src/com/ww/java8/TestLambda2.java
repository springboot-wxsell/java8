package com.ww.java8;

import com.ww.java8.interfaces.MyFunction;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author WangWei
 * @Title: TestLanbda
 * @ProjectName java8
 * @date 2019/1/14 12:00
 * @description:
 *                  1. Lambda 表达式的基础语法：java8 中引入一个新的操作符 "->" 该操作符称为箭头操作符或者Lambda 操作符
 *                      箭头操作符将 Lambda 表达式拆分为两部分
 *                      左侧： Lambda 表达式的参数列表
 *                      右侧： Lambda 表达式中所需要的执行的功能，即 Lambda体
 *
 *   语法格式一： 无参数+无返回值
 *                  () -> System.out.println("hello Lambda!");
 *
 *   语法格式二： 有一个参数+无返回值
 *                  (x) -> System.out.println(x)
 *                  或
 *                  x -> System.out.println(x)
 *
 *   语法格式三： 有两个以上参数+有返回值，并且Lambda 中有多条语句
 *                  (x, y) -> {
 *                      System.out.println("函数式接口");
 *                      return Integer.compare(x, y);
 *                  }
 *   语法格式四： 有两个以上参数+有返回值，并且Lambda 中只有一条语句
 *                  (x, y) -> Integer.compare(x, y);
 *   语法格式五： Lambada 表达式的参数列表的数据类型可以省略不写，因为 JVM 编译器通过上下文推断出，数据类型，即"类型推断"
 *                  (Integer x, Integer y) -> Integer.compare(x, y);
 *
 *
 *  2. Lambda 表达式需要"函数式接口" 的支持
 *  函数式接口：接口中只有一个抽象方法的接口，称为函数式接口，可以使用注解 @FunctionalInterface 修饰
 */
public class TestLambda2 {

    @Test
    public void test1() {
        int num = 0; // jdk1.7以前，必须为 final 修饰

        Runnable r = () -> System.out.println("Hello Lambda!" + num);
        r.run();
    }

    @Test
    public void test2() {
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("我很爱我家睿宝宝");
    }

    @Test
    public void test3() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    @Test
    public void test4() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
    }


    @Test
    public void test5() {
        show(new HashMap<>());
    }

    public void show(Map<Integer, String> map) {

    }

    @Test
    public void test6() {
        Integer num = operation(100, (x) -> x * x);
        System.out.println(num);

        System.out.println(operation(200, (x) -> x + x));
    }

    public Integer operation(Integer num, MyFunction mf) {
        return mf.getValue(num);
    }
}
