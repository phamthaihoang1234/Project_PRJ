/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.DAOBill;
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
import model.Bill;

/**
 *
 * @author Admin
 */
@WebServlet(name = "BillServlet", urlPatterns = {"/BillServlet"})
public class BillServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private DAOBill DAOBill;

    public void init() {
        DAOBill = new DAOBill();
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
        System.out.println(action);

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertBill(request, response);
                    break;
                case "delete":
                    deleteBill(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateBill(request, response);
                    break;
                case "view":
                    viewBill(request, response);
                    break;
                default:
                    listBill(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Bill> listBill = DAOBill.getAll();
        request.setAttribute("listBill", listBill);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/bill/bill-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/bill/bill-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");

        Bill existingBill = DAOBill.getBillDetailById(id);
        request.setAttribute("bill", existingBill);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/bill/bill-form.jsp");

        dispatcher.forward(request, response);

    }

    private void viewBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");

        Bill existingBill = DAOBill.getBillDetailById(id);
        request.setAttribute("bill", existingBill);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/bill/bill-view.jsp");

        dispatcher.forward(request, response);

    }

    private int getId() {
        int number = 0;
        if (!DAOBill.getAll().isEmpty()) {
            for (Bill bill : DAOBill.getAll()) {
                number = bill.getoID();
            }
        }

        number = number + 1;
        return number;
    }

    private void insertBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String dateCreate = request.getParameter("dateCreate");
        String cname = request.getParameter("cname");
        String cphone = request.getParameter("cphone");
        String cAddress = request.getParameter("cAddress");
        String total = request.getParameter("total");
        String status = request.getParameter("status");
        String cid = request.getParameter("cid");
        //  check data
        // convert

        int tota = Integer.parseInt(total);

        int sta = Integer.parseInt(status);
        int ci = Integer.parseInt(cid);

        // entity
        Bill bill = new Bill(getId(), dateCreate, cname, cphone, cAddress, tota, sta, ci);
        DAOBill.insertBill(bill);
        response.sendRedirect("BillServlet");
    }

    private void updateBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String id = request.getParameter("id");

        String dateCreate = request.getParameter("dateCreate");

        String cname = request.getParameter("cname");

        String cphone = request.getParameter("cphone");

        String cAddress = request.getParameter("cAddress");

        String total = request.getParameter("total");

        String status = request.getParameter("status");

        String cid = request.getParameter("cid");

        //  check data
        // convert
        double tota = Double.parseDouble(total);

        int sta = Integer.parseInt(status);
        int ci = Integer.parseInt(cid);

        // entity
        Bill bill = new Bill(Integer.parseInt(id), dateCreate, cname, cphone, cAddress, tota, sta, ci);

        DAOBill.updateBill(bill);
        response.sendRedirect("BillServlet");
    }

    private void deleteBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String idDel = request.getParameter("id");

        DAOBill.deleteBill(Integer.parseInt(idDel));
        response.sendRedirect("BillServlet");

    }
}
