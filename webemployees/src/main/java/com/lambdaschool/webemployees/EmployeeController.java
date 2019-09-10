package com.lambdaschool.webemployees;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController // the annotation that activates the REST API - it also instantiates the objects for us.
@RequestMapping("/data") // everything in this controller is going to start with "data'
public class EmployeeController
{
    // localhost:2019/data/allemployees - all employees
    @GetMapping(value = "/allemployees",
                produces = {"application/json"})
    public ResponseEntity<?> getAllEmployees()
    {
                                     //this is coming from the Main class
        return new ResponseEntity<>(WebemployeesApplication.ourEmpList.empList, HttpStatus.OK);
    }                                  //Main              // object   //the data



    // localhost:2019/data/employee/2 - returns just that employee
    @GetMapping(value = "/employee/{id}",
                produces = {"application/json"}) // documentation

                                         //allows you to put in a variable in this case the id number
    public ResponseEntity<?> getEmpDetail(@PathVariable long id)
    {
                            //Main                //object   // for loop empList
        Employee rtnEmp = WebemployeesApplication.ourEmpList.findEmployee(e -> (e.getId() == id));
        return new ResponseEntity<>(rtnEmp, HttpStatus.OK);
    }


    // localhost:2019/data/employees/s - returns all of the employees whose name starts with an s
    @GetMapping(value = "/employees/{letter}",
                produces = {"application/json"})                    // we're using the character "char" key word so that we can use the == to compare
    public ResponseEntity<?> getEmployeesByFirstName(@PathVariable char letter)
    {
        //Calling the data in the ArrayList
        ArrayList<Employee> rtnEmps = WebemployeesApplication.ourEmpList.
                findEmployees(e -> e.getFname().toUpperCase().charAt(0) == Character.toUpperCase(letter));
                // for loop                                   //because arrays start at 0

        return new ResponseEntity<>(rtnEmps, HttpStatus.OK);
    }



    // localhost:2019/data/employees/sorted/s - returns all of the employees whose name starts with an s, but sorted alphabetically
    @GetMapping(value = "/employees/sorted/{letter}",
                produces = {"application/json"})
    public ResponseEntity<?> getEmployeesByFirstNameSorted(@PathVariable char letter)
    {
        //Calling the data
        ArrayList<Employee> rtnEmps = WebemployeesApplication.ourEmpList.
                findEmployees(e -> e.getFname().toUpperCase().charAt(0) == Character.toUpperCase(letter));

        //Telling the endpoint what to do
        rtnEmps.sort((e1, e2) -> ((int) (e1.getSalary() - e2.getSalary())));

        //Returning the endpoint
        return new ResponseEntity<>(rtnEmps, HttpStatus.OK);
    }

}

// separate methods can have the same names. When one method is ends, it's done.
