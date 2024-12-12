package controller;

import model.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "EmployeeServlet",urlPatterns = "/employee")



public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        employeeService = new EmployeeServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list":
                listEmployees(request, response);
                break;
            case "add":
               showAddForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteEmployees(request,response);
                break;
            case "view":
                viewEmployee(request,response);
                break;
            case "search":
                searchEmployee(request,response);
                break;
            default:
               listEmployees(request,response);
                break;
        }
    }
    private void listEmployees(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        List<Employee> employees = employeeService.getAllEmployees();
        request.setAttribute("employees", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
        dispatcher.forward(request, response);
    }
    private void showAddForm(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-employee.jsp");
        dispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String id = request.getParameter("id");
        Employee existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee != null) {
            request.setAttribute("employee", existingEmployee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("edit-employee.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("employee?action=list");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            addEmployee(request, response);
        } else if ("update".equals(action)) {
            updateEmployee(request, response);
        } else {
            response.sendRedirect("employee?action=list");
        }
    }
    private void addEmployee(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String department = request.getParameter("department");
            String position = request.getParameter("position");
            double salary = Double.parseDouble(request.getParameter("salary"));

            Employee newEmployee = new Employee(id, name, age, department, position, salary);

            employeeService.addEmployee(newEmployee);

            response.sendRedirect("employee?action=list");
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Dữ liệu không hợp lệ. Vui lòng thử lại.");
            showAddForm(request, response);
        }
    }
    private void updateEmployee(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String department = request.getParameter("department");
            String position = request.getParameter("position");
            double salary = Double.parseDouble(request.getParameter("salary"));

            Employee updatedEmployee = new Employee(id, name, age, department, position, salary);
            employeeService.updateEmployee(updatedEmployee);

            response.sendRedirect("employee?action=list");
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Dữ liệu không hợp lệ. Vui lòng thử lại.");
            showEditForm(request, response);
        }
    }
    private void deleteEmployees(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String id = request.getParameter("id");
        if (id != null){
            employeeService.deleteEmployee(id);
        }
        response.sendRedirect("employee?action=list");


    }
    private void viewEmployee(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String id = request.getParameter("id");
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null){
            request.setAttribute("employee",employee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view-employee.jsp");
            dispatcher.forward(request,response);
        }else {
            response.sendRedirect("employee?action=list");
        }

    }
    private void searchEmployee(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String keyword = request.getParameter("keyword").toLowerCase();
        List<Employee> matchingEmployees = employeeService.searchEmployees(keyword);
        request.setAttribute("employees",matchingEmployees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
        dispatcher.forward(request,response);
    }


}





