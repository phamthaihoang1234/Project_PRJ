
import dao.DAOAmin;
import dao.DAOBill;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class tesst {
    public static void main(String[] args) {
         DAOBill daoPro = new DAOBill();
         System.out.println(daoPro.getBillDetailById("0"));
    }
}
