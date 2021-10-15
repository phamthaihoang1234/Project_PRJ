/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.DAOCustomer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CustomerServlet", urlPatterns = {"/CustomerServlet"})
public class CustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private DAOCustomer daoCus;

    public void init() {
        daoCus = new DAOCustomer();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertCus(request, response);
                    break;
                case "delete":
                    deleteCus(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateCus(request, response);
                    break;
                case "view":
                    viewCus(request, response);
                    break;
                default:
                    listCus(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCus(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Customer> listCus = daoCus.getAll();
        request.setAttribute("listCus", listCus);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/customer-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/customer-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");

        Customer existingCus = daoCus.getCustomerById(id);
        request.setAttribute("cus", existingCus);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/customer-form.jsp");

        dispatcher.forward(request, response);

    }

    private void viewCus(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");

        Customer existingCus = daoCus.getCustomerById(id);
        request.setAttribute("cus", existingCus);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/customer-view.jsp");

        dispatcher.forward(request, response);

    }
    int number = 4;

    private int getId() {

        number = number + 1;
        return number;
    }

    private void insertCus(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String name = request.getParameter("cname");
        String phone = request.getParameter("cphone");
        String address = request.getParameter("cAddress");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String status = request.getParameter("status");

        //  check data
        // convert
        int sta = Integer.parseInt(status);

        // entity
        Customer cus = new Customer(name, phone, address, username, password, sta);
        daoCus.insertCustomer(cus);
        response.sendRedirect("CustomerServlet");
    }

    private void updateCus(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("cname");
        String phone = request.getParameter("cphone");
        String address = request.getParameter("cAddress");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String status = request.getParameter("status");

        //  check data
        // convert
        int sta = Integer.parseInt(status);

        // entity
        Customer cus = new Customer(Integer.parseInt(id), name, phone, address, username, password, sta);
        daoCus.updateCustomer(cus);
        response.sendRedirect("CustomerServlet");
    }

    private void deleteCus(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String idDel = request.getParameter("id");

        daoCus.deleteCustomer(Integer.parseInt(idDel));
        response.sendRedirect("CustomerServlet");

    }

}
