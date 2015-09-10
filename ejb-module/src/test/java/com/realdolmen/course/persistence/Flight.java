package com.realdolmen.course.persistence;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JDOAX80 on 10/09/2015.
 */

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;
    private LocalDate departureTime;
    private LocalDate arrivalTime;
    @ManyToOne
    private Plane plane;
    @ManyToMany
    private List<Passenger> passengers = new ArrayList<>();
    @OneToMany
    private List<Ticket> ticketsOut;
    @OneToMany
    private List<Ticket> ticketsReturn;

    //Used by JPA
    protected Flight(){}


    public Flight(String number, LocalDate departureTime, LocalDate arrivalTime) {
        this.number = number;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDate departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDate getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDate arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getId() {
        return id;
    }

}
