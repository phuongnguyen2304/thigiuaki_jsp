package com.example.controller;

import service.EmployeeService;
import service.EmployeeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
