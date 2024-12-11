package service;

import model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> employees = new ArrayList<>();
    static {
        employees.add(new Employee("ID001","Nguyên Phương",20,"Testing","Tester",8000));
        employees.add(new Employee("ID002","Ngọc Thơm",23,"Developer","Lập Trình",10000));
        employees.add(new Employee("ID003","Lan",25,"finance","Kế Toán",7500));
        employees.add(new Employee("ID004","Linh",28,"Designer","Marketing",15000));
        employees.add(new Employee("ID005","Thanh Nga",32,"Manager","Quản lý cấp cao",20000));


    }
    @Override
    public List<Employee> getAllEmployees(){
        return employees;
    }
    @Override
    public Employee getEmployeeById(String id){
        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElse(null);

    }

    @Override
    public void addEmployee(Employee employee) {
       if (getEmployeeById(employee.getId()) != null){
           throw new IllegalArgumentException("Mã nhân viên đã tồn tại !");
       }


        employees.add(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee existing = getEmployeeById(employee.getId());
        if (existing != null){
            existing.setName(employee.getName());
            existing.setAge(employee.getAge());
            existing.setPosition(employee.getPosition());
            existing.setDepartment(employee.getDepartment());
            existing.setSalary(employee.getSalary());
        }

    }

    @Override
    public void deleteEmployee(String id) {
        employees.removeIf(employee -> employee.getId().equals(id));

    }

    @Override
    public List<Employee> searchEmployees(String keyword) {
        keyword = keyword.toLowerCase();
        String finalKeyword = keyword;
        String finalKeyword1 = keyword;
        return employees.stream()
                .filter(employee -> employee.getName().toLowerCase().contains(finalKeyword1) || employee.getId().toLowerCase().contains(finalKeyword1))
                .toList();
    }
}
