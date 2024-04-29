# CS308-Task04-Hibernate

## Task Description
This repository contains the solution for Task 4, which involves adding relationships in the HR schema using Hibernate. The task includes defining entity classes for each table (Employees, Departments, Jobs, Locations, and JobHistory) and establishing relationships between them using Hibernate annotations.

## Project Structure
- **src/main/java**: Contains the Java source code for entity classes and Hibernate configuration.
- **src/main/resources**: Contains Hibernate configuration files.
- **docs**: Additional documentation or resources related to the project.

## Setting Up the Project
1. Clone this repository to your local machine.
2. Set up your development environment with Java and Hibernate.
3. Ensure you have a database set up with the HR schema.
4. Configure Hibernate properties in `src/main/resources/hibernate.cfg.xml` to connect to your database.

## Task Solution
### Entity Classes
- **Employees**: Annotated with Hibernate annotations, including mappings for relationships with Managers, Departments, Jobs, and JobHistory.
- **Departments**: Annotated with Hibernate annotations, including mappings for relationships with Employees and Locations.
- **Jobs**: Annotated with Hibernate annotations, including mappings for relationships with Employees and JobHistory.
- **Locations**: Annotated with Hibernate annotations, including mappings for relationships with Departments.
- **JobHistory**: Annotated with Hibernate annotations, including mappings for relationships with Employees and Jobs.

### Relationships
- **Employees-Departments**: @ManyToOne relationship between Employees and Departments using the DEPARTMENT_ID column.
- **Employees-Jobs**: @ManyToOne relationship between Employees and Jobs using the JOB_ID column.
- **Employees-Employees**: Self-referencing @ManyToOne relationship between Employees and Managers using the MANAGER_ID column.
- **Departments-Locations**: @ManyToOne relationship between Departments and Locations using the LOCATION_ID column.
- **JobHistory-Employees**: @ManyToOne relationship between JobHistory and Employees using the EMPLOYEE_ID column.
- **JobHistory-Jobs**: @ManyToOne relationship between JobHistory and Jobs using the JOB_ID column.

## Usage
- Modify the entity classes or Hibernate configuration files as needed to fit your specific database setup.
- Run your Hibernate application to test the relationships between entities.