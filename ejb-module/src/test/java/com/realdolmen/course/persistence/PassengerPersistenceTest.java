package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Address;
import com.realdolmen.course.domain.CreditCard;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.persistence.PersistenceException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by JDOAX80 on 9/09/2015.
 */
public class PassengerPersistenceTest extends DataSetPersistenceTest {
    @Rule
    public ExpectedException expector = ExpectedException.none();

    @Test
    public void passengerCanBePersisted() throws Exception {
        List<CreditCard> creditCards = new ArrayList<>();
        creditCards.add(new CreditCard("14521025", "12-18", 7785415, CreditCardType.AMEX));
        Passenger passenger = new Passenger("Joske", "Jos", "14erea414", 41258, LocalDate.of(1985,11,12) ,LocalDate.of(2015,9,11) ,
                PassengerType.OCCASIONAL, creditCards, new Address("BlablaStraat", null, "BlablaCity", "5214", "Belgium"), null);
        entityManager().persist((passenger));
        assertNotNull(passenger.getId());
    }

    @Test
    public void passengerCanBeRetrieved() throws Exception {
    }

}