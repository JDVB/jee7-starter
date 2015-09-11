package com.realdolmen.course.domain;

import javax.persistence.Entity;

/**
 * Created by JDOAX80 on 10/09/2015.
 */
@Entity
public class InternationalFlight extends Flight {
    boolean blackListed;
    String regulations;

    //Used by JPA
    protected InternationalFlight() {}
}
