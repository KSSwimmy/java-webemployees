package com.lambdaschool.webemployees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Main Class

@SpringBootApplication
public class WebemployeesApplication
{
    public static EmpList ourEmpList; // we're going to create an object of EmpList and call it ourEmpList
    public static void main(String[] args)
    {
        ourEmpList = new EmpList();
        SpringApplication.run(WebemployeesApplication.class, args);
    }

}
