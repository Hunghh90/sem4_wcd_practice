package com.example.exam_practice.servlet;

import com.example.exam_practice.dao.EmployeeDAO;
import com.example.exam_practice.dao.impl.EmployeeDAOImpl;
import com.example.exam_practice.entities.EmployeeEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(value = "/employee-servlet")
public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;
    public void init() {
        employeeDAO = new EmployeeDAOImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<EmployeeEntity> employees = employeeDAO.getAll();
        req.setAttribute("employees",employees);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            EmployeeEntity st = new EmployeeEntity(
                    req.getParameter("fullName"),
                    dateFormat.parse(req.getParameter("birthday")),
                    req.getParameter("address"),
                    req.getParameter("position"),
                    req.getParameter("department")
            );
            employeeDAO.createEmployee(st);
            resp.sendRedirect("employee-servlet");
        }catch (Exception ex){
            System.out.printf(ex.getMessage());
        }
    }
}
