package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by JDOAX80 on 10/09/2015.
 */
@Entity
public class Ticket implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    private double price;
    @ManyToOne
    private Passenger passenger;
    @ManyToOne
    private Flight flightOut;
    @ManyToOne
    private Flight flightReturn;

    //Used by JPA
    protected Ticket() {}

    public Ticket(double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0) {
           // throw new IllegalArgumentException("The price of a ticket can not be negative");
        }
        this.price = price;
    }
}
