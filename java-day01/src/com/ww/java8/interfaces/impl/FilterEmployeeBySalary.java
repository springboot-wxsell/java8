package com.ww.java8.interfaces.impl;

import com.ww.java8.interfaces.MyPredicate;
import com.ww.java8.module.Employee;

/**
 * @author WangWei
 * @Title: FilterEmployeeBySalart
 * @ProjectName java8
 * @date 2019/1/14 11:39
 * @description:
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee> {
    @Override
    public boolean compare(Employee employee) {
        return employee.getSalary() > 8500;
    }
}
