package com.lambdaschool.webemployees;

import java.util.concurrent.atomic.AtomicLong;

public class Employee
{                                                 //AtomicLong is in charge of assigning the id and responsible for making sure that one of them gets assigned an id 1 at a time. person A and person B gets an id if given at the same time.
    private static final AtomicLong counter = new AtomicLong();
    private long id; // long is the base data type and Long is the class type - more numbers
    private String fname;
    private String lname;
    private double salary;
    private boolean has401k;
    private int companyID;
    private int healthPlanID;

    public Employee(String fname, String lname, double salary, boolean has401k, int companyID, int healthPlanID)
    {
        this.id = counter.incrementAndGet();
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
        this.has401k = has401k;
        this.companyID = companyID;
        this.healthPlanID = healthPlanID;
    }

    public Employee(Employee toClone)
    {
        this.id = toClone.getId();
        this.fname = toClone.getFname();
        this.lname = toClone.getLname();
        this.salary = toClone.getSalary();
        this.has401k = toClone.isHas401k();
        this.companyID = toClone.getCompanyID();
        this.healthPlanID = toClone.getHealthPlanID();
    }

    public Employee() //
    {
    }

    public long getId() // you always want to get the id never set it.
    {
        return id;
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public String getName() // was created manually to return the 1st name and last name
    {
        return fname + " " + lname;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public boolean isHas401k()
    {
        return has401k;
    }

    public void setHas401k(boolean has401k)
    {
        this.has401k = has401k;
    }

    public int getCompanyID()
    {
        return companyID;
    }

    public void setCompanyID(int companyID)
    {
        this.companyID = companyID;
    }

    public int getHealthPlanID()
    {
        return healthPlanID;
    }

    public void setHealthPlanID(int healthPlanID)
    {
        this.healthPlanID = healthPlanID;
    }

    @Override
    public String toString()
    {
        return "Employee{" + "id=" + id + ", fname='" + fname + '\'' + ", lname='" + lname + '\'' + ", salary=" + salary + ", has401k=" + has401k + ", companyID=" + companyID + ", healthPlanID=" + healthPlanID + '}';
    }
}

// static allows the id counter to be shared across objects
// final is very similar to a const. Once it's assigned a value it cannot be changed. We can change the object but can't create a new object in it's place