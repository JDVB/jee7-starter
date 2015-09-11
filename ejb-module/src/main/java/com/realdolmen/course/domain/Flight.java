package com.realdolmen.course.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JDOAX80 on 10/09/2015.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)//Joined-Subclass Strategy
public abstract class Flight extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*Identity niet gebruiken als generatedValue strategy want dit geldt enkel voor 1 tabel(zijnde flight) wat er voor zorgt dat wanneer
      je een domesticflight toevoegt en nadien een internationalflight dan moeten hun id's verschillen ten op zichte van elkaar(1 en 2) en
      niet afzonderlijk 1 en 1
     */
    private Integer id;
    private String number;
    private LocalDate departureTime;
    private LocalDate arrivalTime;
    @ManyToOne
    private Plane plane;
    @ManyToMany
    @JoinTable(name = "jnd_flight_passenger", joinColumns = @JoinColumn(name = "flight_fk"), inverseJoinColumns = @JoinColumn(name = "passenger_fk"))
    private List<Passenger> passengers = new ArrayList<>();
    @OneToMany(mappedBy = "flightOut")
    private List<Ticket> ticketsOut;
    @OneToMany(mappedBy = "flightReturn")
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
