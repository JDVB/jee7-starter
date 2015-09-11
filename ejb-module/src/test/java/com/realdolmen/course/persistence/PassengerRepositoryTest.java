package com.realdolmen.course.persistence;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by JDOAX80 on 11/09/2015.
 */
public class PassengerRepositoryTest extends DataSetPersistenceTest {
    private PassengerRepository repository;

    @Before
    public void initializeRepository() {
        repository = new PassengerRepository();
        repository.entityManager = entityManager();
    }

    @Test
    public void allPassengersCanBeRetrieved() throws Exception {
        assertEquals(2, repository.findAll().size());
    }

    @Test
    public void allPassengersCanBeDeleted() throws Exception {
        repository.deleteAll();

    }

    @Test
    public void ticketsCanBeRetrievedByPassengerId() throws Exception {

    }
}
