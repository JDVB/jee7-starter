package com.realdolmen.course.persistence;

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
    private double price;
    private Flight flight;
    @ManyToOne
    private Passenger passenger;
    @OneToMany(mappedBy = "ticketsOut")
    private Flight flightOut;
    @OneToMany(mappedBy = "ticketsReturn")
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
        this.price = price;
    }
}
