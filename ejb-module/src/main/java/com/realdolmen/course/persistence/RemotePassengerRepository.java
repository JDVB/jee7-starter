package com.realdolmen.course.persistence;


import com.realdolmen.course.domain.Passenger;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by JDOAX80 on 10/09/2015.
 */
@Remote
public interface RemotePassengerRepository {
    List<Passenger> findAll();
}
