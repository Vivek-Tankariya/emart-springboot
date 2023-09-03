package com.example.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Cart",
       uniqueConstraints = @UniqueConstraint(columnNames = {"CustID", "ProdID"}))
public class Cart {

    private int CartID;
    private int CustID;
    private int ProdID;
    private int Qty;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_ID")
    public int getCartID() {
        return CartID;
    }

    public void setCartID(int cartID) {
        CartID = cartID;
    }

    public int getCustID() {
        return CustID;
    }

    public void setCustID(int custID) {
        CustID = custID;
    }

    public int getProdID() {
        return ProdID;
    }

    public void setProdID(int prodID) {
        this.ProdID = prodID;
    }

    @Column(nullable = false)
    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }
}

