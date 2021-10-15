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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                showFormLogin(request, response);
                break;
            case "access":
                loginCus(request, response);
                break;
            case "logout":
                logoutCus(request, response);
                break;
            default:
                showFormLogin(request, response);
                break;
        }
    }
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }

    private void showFormLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        RequestDispatcher dispatcher = request.getRequestDispatcher("/login-form.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/newjsp.jsp");
        dispatcher.forward(request, response);
    }

    private void loginCus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAOCustomer daoCus = new DAOCustomer();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Customer cus = daoCus.loginCustomer(username, password);
        String message = "";

        if (cus != null) {
            request.getSession().setAttribute("auth", cus);
            request.setAttribute("auth", cus);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/product/product-cart.jsp");
            dispatcher.forward(request, response);
        } else {
            
            request.setAttribute("message", "Login faided!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/newjsp.jsp");
            dispatcher.forward(request, response);

        }

    }

    private void logoutCus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("message", "Logout successfully");
        HttpSession session = request.getSession();
        session.removeAttribute("auth");
        RequestDispatcher dispatcher = request.getRequestDispatcher("ProductServlet");

        dispatcher.forward(request, response);

    }

}
