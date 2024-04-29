package com.sci;

import com.sci.dao.DBConfig;
import com.sci.models.Employee;
import org.hibernate.Session;

public class EmployeeApp {
  public static void testCache1() {

    System.out.println("Test cache scenario 1");

    try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

      System.out.println(session.get(Employee.class, 101));

      System.out.println("--------------------------------");

      System.out.println(session.get(Employee.class, 102));

      System.out.println("--------------------------------");

      System.out.println(session.get(Employee.class, 101));

    } catch (Exception ex) {
      System.err.println(ex.getMessage());
    }
  }

  public static void testCache2() {

    System.out.println("Test cache scenario 2");

    try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

      System.out.println(session.get(Employee.class, 103));

    } catch (Exception ex) {
      System.err.println(ex.getMessage());
    }
  }

  public static void main(String[] args) {

//    testCache1();
//
//    System.out.println("*****************************************");
//
//    testCache2();
//
//    System.out.println("*****************************************");
//
//    List<Employee> employeeList = dbEmployee.get();
//
//    for(Employee e : employeeList) {
//      System.out.println(e);
//    }

//    System.out.println(dbEmployee.get(100));

//    Employee employee = new Employee();
//    employee.setLastName("abdelghany");
//    employee.setEmail("abdelghany@sci.eg");
//    employee.setSalary(151);
//    employee.setCommissionPct(0.5);
//    employee.setDepartmentId(50);
//    employee.setJobId("SH_CLERK");
//    employee.setHireDate(new Date());
//
//    System.out.println(dbEmployee.insert(employee));

//    Employee employee = dbEmployee.get(231);
//
//    employee.setLastName("Mustafa");
//
//    dbEmployee.update(employee);


//    dbEmployee.delete(231);

    DBConfig.shutdown();

  }
}
