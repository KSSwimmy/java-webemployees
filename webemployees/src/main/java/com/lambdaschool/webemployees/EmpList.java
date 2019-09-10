package com.lambdaschool.webemployees;

//where the arraylist and data is created

// we made this class public so that it will have access to the application

import java.util.ArrayList;

public class EmpList
{
    public ArrayList<Employee> empList = new ArrayList<>();

    public EmpList()
    {
        empList.add(new Employee("Steve", "Green", 45000, true, 1, 1));
        empList.add(new Employee("Sam", "Ford", 80000, true, 1, 1));
        empList.add(new Employee("John", "Jones ", 75000, true, 1, 1));
    }

    // find first employee that matches filter
    public Employee findEmployee(CheckEmployee tester) // send it the lambda expression
    {
        for (Employee e: empList) // search through the list
        {
            if (tester.test(e)) // because this method is in here (in this class) it already knows about the ArrayList empList we don't have to do anything special to it.
            {
                return e; //
            }
        }
        return null; //
    }

    // the lambda expression is going to implement test

    // find all employees that match filter
    public ArrayList<Employee> findEmployees(CheckEmployee tester)
    {
        ArrayList<Employee> tempEmpList = new ArrayList<>();

        for (Employee e: empList)
        {
            if (tester.test(e))
            {
                tempEmpList.add(e);
            }
        }

        return tempEmpList;
    }
}
