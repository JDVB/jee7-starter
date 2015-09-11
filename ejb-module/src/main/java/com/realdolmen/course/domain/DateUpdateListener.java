package com.realdolmen.course.domain;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by JDOAX80 on 11/09/2015.
 */
public class DateUpdateListener {

    @PrePersist
    @PreUpdate
    public void dateLastUpdated(Passenger passenger) {
        Date date = new Date();
        passenger.setDateLastUpdated(date);
    }
}
