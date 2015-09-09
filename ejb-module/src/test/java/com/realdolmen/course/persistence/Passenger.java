package com.realdolmen.course.persistence;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by JDOAX80 on 9/09/2015.
 */

@Entity
@NamedQueries({@NamedQuery(name = Passenger.FIND_ALL, query = "select p FROM Passenger p")})
public class Passenger implements Serializable {

    @EmbeddedId
    PassengerId passengerId;
    @Basic(optional = false)
    private String lastName;
    private Integer frequentFlyerMiles;

    public static final String FIND_ALL = "Passenger.findAll";
    /**
     * Used by JPA.
     */
    protected Passenger() {
    }

    //Used for unit testing, not the ORM framework
    public Passenger(PassengerId passengerId, String lastName, Integer frequentFlyerMiles) {
        this.passengerId = passengerId;
        this.lastName = lastName;
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public PassengerId getPassengerId() {
        return passengerId;
    }


    public String getLastName() {
        return lastName;
    }

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

}
