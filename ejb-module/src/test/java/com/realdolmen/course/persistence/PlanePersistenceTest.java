package com.realdolmen.course.persistence;

import org.junit.Test;

/**
 * Created by JDOAX80 on 10/09/2015.
 */
public class PlanePersistenceTest extends DataSetPersistenceTest {

    @Test
    public void planeCanBePersisted() throws Exception {
        Plane plane = new Plane("A380");
        entityManager().persist(plane);
        assertNotNull(plane.getId());
    }
}
