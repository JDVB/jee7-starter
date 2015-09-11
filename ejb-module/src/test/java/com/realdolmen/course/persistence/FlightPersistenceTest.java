package com.realdolmen.course.persistence;

import jdk.nashorn.internal.runtime.ECMAException;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Created by JDOAX80 on 10/09/2015.
 */
public class FlightPersistenceTest extends DataSetPersistenceTest{

    @Test
    public void flightCanBePersisted() throws Exception {
        LocalDate date = LocalDate.of(1985, 10, 5);
        System.out.println(date);
    }

    @Test
    public void domesticFlightCanBePersisted() throws Exception{

    }

    @Test
    public void domesticFlightCanBeRetrieved() throws Exception{

        /*Checks whether the retrieved flight has the correct type*/
    }

    @Test
    public void internationalFlightCanBePersisted() throws Exception{

    }

    @Test
    public void internationalFlightCanBeRetrieved() throws Exception{


        /*Checks whether the retrieved flight has the correct type*/
    }

}
