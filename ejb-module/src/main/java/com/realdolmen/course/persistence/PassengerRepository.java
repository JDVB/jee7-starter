package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by JDOAX80 on 10/09/2015.
 */
public class PassengerRepository implements RemotePassengerRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Passenger> findAll() {
        return entityManager.createNamedQuery("Passenger.findAll").getResultList();
    }

    public List<Passenger> findAllLastNames(String lastName) {
        return entityManager.createNamedQuery("Passenger.findAllLastNames").setParameter("lastName", lastName).getResultList();
    }

/*    public List<Ticket> findTicketsByPassengerId(Integer id) {
        return entityManager.createNamedQuery("Passenger.findTicketsByPassengerId").setParameter("id", id).getResultList();
    }*/

    public void calculateTotalFlyerMiles() {
        entityManager.createNamedQuery("Passenger.totalFrequentFlyerMiles").getSingleResult();
    }

    public void deleteAll() {
        entityManager.createNamedQuery("Passenger.deleteAll");
    }

    public void remove(int id) {
        entityManager.remove(entityManager.getReference(Passenger.class, id));
    }
}