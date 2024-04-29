package com.sci;

import com.sci.dao.DBDepartments;
import com.sci.models.Department;

import java.util.List;

public class DepartmentApp {
    public static void main(String[] args) {

        DBDepartments dbDepartments = new DBDepartments();

        // Test Create New Department
        Department newDep = new Department();
        newDep.setDepartmentName("Development");
        newDep.setLocationId(1400);
        newDep.setManagerId(103);

        int newDepartmentId = dbDepartments.insert(newDep);
        System.out.println("New Department ID: " + newDepartmentId);

        // Test Read All Departments
        System.out.println("All Departments:");
        List<Department> departmentsList = dbDepartments.getAllDepartments();
        for (Department dep : departmentsList) {
            System.out.println(dep);
        }

        // Test Read Department by ID
        int departmentId = 10; // Specify the department ID to retrieve
        Department retrievedDepartment = dbDepartments.getDepartmentById(departmentId);
        if (retrievedDepartment != null) {
            System.out.println("Retrieved Department by ID: " + retrievedDepartment);
        } else {
            System.out.println("Department with ID " + departmentId + " not found.");
        }

        // Test Update Department
        Department departmentToUpdate = dbDepartments.getDepartmentById(newDepartmentId);
        if (departmentToUpdate != null) {
            departmentToUpdate.setDepartmentName("Updated Development");
            dbDepartments.update(departmentToUpdate);
            System.out.println("Department updated successfully: " + departmentToUpdate);
        } else {
            System.out.println("Department to update not found.");
        }

        // Test Delete Department
        dbDepartments.delete(newDepartmentId);
        System.out.println("Department deleted successfully.");

        // Test Read All Departments after deletion
        System.out.println("All Departments after deletion:");
        List<Department> departmentsAfterDeletion = dbDepartments.getAllDepartments();
        for (Department dep : departmentsAfterDeletion) {
            System.out.println(dep);
        }
    }
}
