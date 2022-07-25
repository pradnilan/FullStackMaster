package com.simplilearn.controllers;

import com.simplilearn.model.Employee;
import com.simplilearn.service.EmployeeService;
import com.simplilearn.service.EmployeeServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("emp");
        String actionName;
        EmployeeService employeeService=new EmployeeServiceImpl();

        if(action.equals("Add Employee"))actionName="addEmployee.jsp";
        else if(action.equals("Delete Employee"))actionName="deleteEmployee.jsp";
        else {
            Set<Employee> allEmps=employeeService.getAllEmployee();
//            request.setAttribute("allEmps",allEmps);
//            //actionName="allEmployee.jsp";
//            RequestDispatcher dispatcher=request.getRequestDispatcher("allEmployee.jsp");
//            dispatcher.forward(request,response);

            HttpSession session=request.getSession();
            session.setAttribute("allEmps",allEmps);
            response.sendRedirect("allEmployee.jsp");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
