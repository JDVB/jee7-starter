package com.realdolmen.course.persistence;

import org.junit.Test;

/**
 * Created by JDOAX80 on 10/09/2015.
 */
public class TicketTest extends DataSetPersistenceTest{

    @Test
    public void testTicketCanBePersisted()  {
        Ticket ticket = new Ticket(1507);
        entityManager().persist(ticket);
        assertNotNull(ticket.getId());
    }

    @Test
    public void flightCanBeAssignedToATicket() throws Exception{

    }

    @Test
    public void ticketPriceMustNotBeNegative() throws Exception {

    }

    @Test
    public void passengerCanBeAssignedToATicket() throws Exception {

    }
}
