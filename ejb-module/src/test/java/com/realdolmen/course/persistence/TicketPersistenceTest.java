package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Ticket;
import org.junit.Test;

import javax.persistence.PersistenceException;

/**
 * Created by JDOAX80 on 10/09/2015.
 */
public class TicketPersistenceTest extends DataSetPersistenceTest{

    @Test
    public void testTicketCanBePersisted()  {
        Ticket ticket = new Ticket(1507);
        entityManager().persist(ticket);
        assertNotNull(ticket.getId());
    }

    @Test
    public void flightCanBeAssignedToATicket() throws Exception{

    }

    @Test(expected = PersistenceException.class)
    public void ticketPriceMustNotBeNegative() throws Exception {
        Ticket ticket = new Ticket(140.75);
        entityManager().persist(ticket);
    }

    @Test
    public void passengerCanBeAssignedToATicket() throws Exception {

    }
}
