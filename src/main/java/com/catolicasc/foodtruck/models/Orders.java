/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catolicasc.foodtruck.models;

import java.util.Date;

/**
 *
 * @author dayan.freitas
 */
public class Orders {
    Integer id;
    Customers customers;
    User seller;
    Date order_date;
    Date prepared_date;
    Date delivery_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Date getPrepared_date() {
        return prepared_date;
    }

    public void setPrepared_date(Date prepared_date) {
        this.prepared_date = prepared_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }
    
    
}
