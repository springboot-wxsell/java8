package com.ww.java8.interfaces.impl;

import com.ww.java8.interfaces.MyPredicate;
import com.ww.java8.module.Employee;

/**
 * @author WangWei
 * @Title: FilterEmployeeByAge
 * @ProjectName java8
 * @date 2019/1/14 11:27
 * @description:
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {

    @Override
    public boolean compare(Employee employee) {
        return employee.getAge() >= 35;
    }
}
