/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class BillDetail {
    private int pid;
    private String oID;
    private int quantity;
    private int money;
    private int total;

    public BillDetail() {
    }

    public BillDetail(int pid, String oID, int quantity, int money, int total) {
        this.pid = pid;
        this.oID = oID;
        this.quantity = quantity;
        this.money = money;
        this.total = total;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getoID() {
        return oID;
    }

    public void setoID(String oID) {
        this.oID = oID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
    
}
