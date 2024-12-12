package service;

import model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String id);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(String id);
    List<Employee> searchEmployees(String keyword);





}
