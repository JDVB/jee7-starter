package com.realdolmen.course.domain;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JDOAX80 on 10/09/2015.
 */
@Entity
public class DomesticFlight extends Flight{
    private String airlineCompany;
    @ElementCollection(fetch = FetchType.LAZY)
    @Column(name = "referencesDomesticFlight")
    private List<String> referencesDomesticFlight = new ArrayList<>();

    //Used by JPA
    protected DomesticFlight(){}

    public DomesticFlight(String number, LocalDate departureTime, LocalDate arrivalTime, String airlineCompany, List<String> references) {
        super(number, departureTime, arrivalTime);
        this.airlineCompany = airlineCompany;
        this.referencesDomesticFlight = references;
    }

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public List<String> getReferences() {
        return referencesDomesticFlight;
    }

    public void setReferences(List<String> references) {
        this.referencesDomesticFlight = references;
    }
}
