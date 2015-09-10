package com.realdolmen.course.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JDOAX80 on 10/09/2015.
 */
@Entity
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    @OneToMany
    private List<Flight> flights = new ArrayList<>();

    //Used by JPA
    protected Plane() {
    }

    public Integer getId() {
        return id;
    }

    public Plane(String type) {
    }
}
