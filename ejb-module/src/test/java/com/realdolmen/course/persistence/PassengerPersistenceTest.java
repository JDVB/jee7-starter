package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Book;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;


/**
 * Created by JDOAX80 on 9/09/2015.
 */
public class PassengerPersistenceTest extends DataSetPersistenceTest{
    @Rule
    public ExpectedException expector = ExpectedException.none();

    @Test
    public void passengerCanBePersisted() throws Exception {
        Passenger passenger = new Passenger(new PassengerId("Joske", "blabli"), "Jos", 14852);
        entityManager().persist(passenger);
        assertNotNull(passenger.getPassengerId().getFirstName());
    }

    @Test
    public void passengerCanBeRetrievedById() throws Exception {
        assertEquals("Joske", entityManager().find(Passenger.class, new PassengerId("Joske", "blabi")).getPassengerId().getFirstName());
    }

    @Test(expected = PersistenceException.class)//Houdt in dat de verwachtte uitkomst van de test is dat er een exception gethrowed zal worden van het type PersistenceException
    public void passengerCanNotBePersistedWithoutLastName() {
        Passenger passenger = new Passenger(new PassengerId("Josette", "blablibla"),null, 14752);
        entityManager().persist(passenger);
    }

    @Test
    public void passengerFindAllWorks(){
        Query q = entityManager().createNamedQuery("Passenger.findAll");
        Collection<Passenger> passengerEntities = q.getResultList();
        assertEquals(1, passengerEntities.size());

    }
}

