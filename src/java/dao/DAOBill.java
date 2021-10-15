/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static com.sun.xml.bind.util.CalendarConv.formatter;
import static java.lang.System.out;
import model.Admin;
import model.Bill;
import model.Category;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DAOBill {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    private static final String INSERT_BILL_SQL = "INSERT INTO Bill" + "  (dateCreate,cname,cphone,cAddress,total,status,cid,oID) VALUES "
            + " (?,?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_BILL_BY_ID = "select * from Bill where oID =?;";
    private static final String SELECT_ALL_BILL = "select * from Bill";
    private static final String DELETE_BILL_SQL = "delete from Bill where oID = ?;";
    private static final String UPDATE_BILL_SQL = "update Bill set dateCreate = ?,cname= ?,cphone= ?,cAddress= ?,total= ?,status= ? Where oID=?;";

    public void insertBill(Bill bi) {

        try {
           
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(INSERT_BILL_SQL);
            ps.setString(1, bi.getDateCreate());
            ps.setString(2, bi.getCname());
            ps.setString(3, bi.getCphone());
            ps.setString(4, bi.getcAddress());
            ps.setDouble(5, bi.getTotal());
            ps.setInt(6, bi.getStatus());
            ps.setInt(7, bi.getCid());
            ps.setInt(8, bi.getoID());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean deleteBill(int oid) throws SQLException {

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(DELETE_BILL_SQL);
            ps.setInt(1, oid);
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateBill(Bill bi) throws SQLException {
        try {
            
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(UPDATE_BILL_SQL);

            ps.setString(1, bi.getDateCreate());
            ps.setString(2, bi.getCname());
            ps.setString(3, bi.getCphone());
            ps.setString(4, bi.getcAddress());
            ps.setDouble(5, bi.getTotal());
            ps.setInt(6, bi.getStatus());
            ps.setInt(7, bi.getoID());

            boolean a = ps.executeUpdate() > 0;
            out.print("<h1>" + a + "</h1>");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Bill getBillDetailById(String id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(SELECT_BILL_BY_ID);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {

                int oID = rs.getInt(1);
                String dateCreate = rs.getString(2);
                String cname = rs.getString(3);
                String cphone = rs.getString(4);
                String cAddress = rs.getString(5);
                int total = rs.getInt(6);
                int status = rs.getInt(7);
                int cid = rs.getInt(8);
                

                Bill bill = new Bill(oID,dateCreate, cname, cphone, cAddress, total, status, cid);

                return bill;

            }

            rs = ps.executeQuery();

        } catch (Exception ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Bill> getAll() {
        ArrayList<Bill> arr = new ArrayList<Bill>();
        String sql = "select * from Bill";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                int oID = rs.getInt(1);
                String dateCreate = rs.getString(2);
                String cname = rs.getString(3);
                String cphone = rs.getString(4);
                String cAddress = rs.getString(5);
                int total = rs.getInt(6);
                int status = rs.getInt(7);
                int cid = rs.getInt(8);
                

                Bill bill = new Bill(oID, dateCreate, cname, cphone, cAddress, total, status, cid);
                arr.add(bill);

            }
            return arr;

        } catch (Exception ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    private Connection getConnection() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public static void main(String[] args) {
        DAOBill dao = new DAOBill();

//         for(Bill bi: dao.getAll()){
//             System.out.println(bi.getCname());
//         }
//
//        try {
//            //          dao.insertBill(new Bill(2,"03/11/2000", "12345678","linhbeo","linhbeo",1,2,1));
////            dao.insertBill(new Bill(3,"03/11/2000", "12345678","linhbeo","linhbeo",1,2,1));
////              dao.insertBill(new Bill(4,"03/11/2000", "12345678","linhbeo","linhbeo",1,2,1));
////                dao.insertBill(new Bill(5,"03/11/2000", "12345678","linhbeo","linhbeo",1,2,1));
////                  dao.insertBill(new Bill(6,"03/11/2000", "12345678","linhbeo","linhbeo",1,2,1));
////                    dao.insertBill(new Bill(7,"03/11/2000", "12345678","linhbeo","linhbeo",1,2,1));
////                      dao.insertBill(new Bill(8,"03/11/2000", "12345678","linhbeo","linhbeo",1,2,1))
////            dao.deleteBill(1);
//            dao.updateBill(new Bill(2,"03/11/2000", "12345678","linhbeo1234","linhbeo",1,2,1));
//
////        try {
////            dao.updateBill(new Bill("linhbeo", "12345678","linhbeo","linhbeo",1,2,1));
////        } catch (SQLException ex) {
////            Logger.getLogger(DAOAmin.class.getName()).log(Level.SEVERE, null, ex);
////        }
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
