/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class DAOProduct extends DBContext {

    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO Product" + "  (pid,pname,quantity,price,image,description,status,cateID) VALUES "
            + " (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_PRODUCT_BY_ID = "select * from Product where pid =?";
    private static final String SELECT_PRODUCT_BY_PNAME = "select * from Product where pname LIKE ? ";
    private static final String SELECT_PRODUCT_BY_PNAME_AND_SORT_ASC = "select * from Product where pname LIKE ? ORDER BY price asc  ";
    private static final String SELECT_PRODUCT_BY_SORT_ASC = "select * from Product ORDER BY price asc ";
    private static final String SELECT_PRODUCT_BY_PNAME_AND_SORT_DESC = "select * from Product where pname LIKE ? ORDER BY price desc ";
    private static final String SELECT_PRODUCT_BY_SORT_DEC = "select * from Product ORDER BY price desc ";
    private static final String SELECT_ALL_PRODUCTS = "select * from Product";
    private static final String DELETE_PRODUCT_SQL = "delete from Product where pid = ?;";
    private static final String UPDATE_PRODUCT_SQL = "update Product set pname = ?,quantity= ?, price =? , image = ?, description = ?, status = ? , cateID = ?   where pid = ?;";

    public int insertProduct(Product pro) {
        Connection conn = null;
        int n = 0;
        String sql = "insert into Product(pid,pname,quantity,price,image,description,status,cateID) "
                + "values('" + pro.getPid() + "','" + pro.getPname() + "'," + pro.getQuantity()
                + "," + pro.getPrice() + ",'" + pro.getImage() + "','" + pro.getDescription() + "'," + pro.getStatus() + ","
                + pro.getCateID() + ")";
        // System.out.println(sql);
        try {
            //Statemetn
            conn = new DBContext().getConnection();
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (Exception ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteProduct(String pid) throws SQLException {
        int rowDeleted;
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);) {

            statement.setString(1, pid);
            rowDeleted = statement.executeUpdate();
            return rowDeleted;
        } catch (Exception ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

//    public void displayAll() {
//        String sql = "select * from Product";
//        ResultSet rs = getData(sql);
//        try {
//            while (rs.next()) {
//                String pid = rs.getString("pid"), pname = rs.getString(2); // "pname"
//                int quantity = rs.getInt("quantity");
//                double price = rs.getDouble(4);
//                String image = rs.getString(5), description = rs.getString(6);
//                int status = rs.getInt(7), cateID = rs.getInt(8);
//                Product pro = new Product(pid, pname, quantity, price, image, description, cateID);
//                System.out.println(pro);
//
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOProduct.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public ArrayList<Product> getPrice(double from, double to) {
        ArrayList<Product> arr = new ArrayList<Product>();
        String sql = "select * from Product where price between " + from + " and " + to;

        return arr;
    }

    public Product getProductById(String id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(SELECT_PRODUCT_BY_ID);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return (new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)
                ));
            }

        } catch (Exception ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet getProductByPname(String id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(SELECT_PRODUCT_BY_PNAME);
            ps.setString(1, "%" + id + "%");
            rs = ps.executeQuery();

        } catch (Exception ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet getProductByPnameAndSortAsc(String id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(SELECT_PRODUCT_BY_PNAME_AND_SORT_ASC);
            ps.setString(1, "%" + id + "%");
            rs = ps.executeQuery();

        } catch (Exception ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet getProductByPnameAndSortDesc(String id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(SELECT_PRODUCT_BY_PNAME_AND_SORT_DESC);
            ps.setString(1, "%" + id + "%");
            rs = ps.executeQuery();

        } catch (Exception ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet getProductBySortAsc(String id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(SELECT_PRODUCT_BY_SORT_ASC);

            rs = ps.executeQuery();

        } catch (Exception ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet getProductByDesc(String id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(SELECT_PRODUCT_BY_PNAME_AND_SORT_DESC);

            rs = ps.executeQuery();

        } catch (Exception ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

//    
//     public ArrayList<Product> getAllByPname(String pname) {
//        ArrayList<Product> arr1 = getAllByArray();
//        ArrayList<Product> arr = new ArrayList<Product>();
//         for (Product product : arr) {
//             if(product.getPname().contains(pname)){
//                 arr.add(product);
//             }
//         }
//        
//        return arr;
//    }
    public ArrayList<Product> getAllByArray() {
        ArrayList<Product> arr = new ArrayList<Product>();
        String sql = "select * from Product";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                String pid = rs.getString(1), pname = rs.getString(2); // "pname"
                int quantity = rs.getInt(3);
                double price = rs.getDouble(4);
                String image = rs.getString(5), description = rs.getString(6);
                int status = rs.getInt(7), cateID = rs.getInt(8);
                Product pro = new Product(pid, pname, quantity, price, image, description, status, cateID);
                arr.add(pro);

            }
            return arr;
        } catch (Exception ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ResultSet getAll() {
        ArrayList<Product> arr = new ArrayList<Product>();
        String sql = "select * from Product";
//        ResultSet rs = getData(sql);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
//            while (rs.next()) {
//                
//                String pid = rs.getString(1), pname = rs.getString(2); // "pname"
//                int quantity = rs.getInt(3);
//                double price = rs.getDouble(4);
//                String image= rs.getString(5), description= rs.getString(6);
//                int status= rs.getInt(7), cateID= rs.getInt(8);
////                Product pro=new Product(pid, pname, quantity, price, image, description, cateID);
////               arr.add(pro);
//
//            }
//
        } catch (Exception ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int updateProduct(Product product) throws SQLException {
        int rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {
            statement.setString(1, product.getPname());
            statement.setInt(2, product.getQuantity());
            statement.setDouble(3, product.getPrice());
            statement.setString(4, product.getImage());
            statement.setString(5, product.getDescription());
            statement.setInt(6, product.getStatus());
            statement.setInt(7, product.getCateID());
            statement.setString(8, product.getPid());

            rowUpdated = statement.executeUpdate();
            return rowUpdated;
        } catch (Exception ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void main(String[] args) {
        DAOProduct dao = new DAOProduct();
        int n = dao.insertProduct(new Product("P20", "HP G6", 2, 500, "no image", "second hand", 1, 3));
        int n1 = dao.insertProduct(new Product("P21", "HP G6", 2, 500, "no image", "second hand", 1, 1));
        int n2 = dao.insertProduct(new Product("P22", "HP G6", 2, 500, "no image", "second hand", 1, 4));
        int n3 = dao.insertProduct(new Product("P23", "HP G6", 2, 500, "no image", "second hand", 1, 8));
//        if (n > 0) {
//            System.out.println("Inserted");
//        }

//        try {
//            int m = dao.deleteProduct("P03");
//            if(m > 0){
//                System.out.println("Delete success");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        for(Product p: dao.getAll()){
//             System.out.println(p.getPname());
//         }
//        try {
//            int u = dao.updateProduct(new Product("P01", "asd", 6, 123, "yes_image", "autication", 1, 1));
//            if (u > 0) {
//                System.out.println(" Update success");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
