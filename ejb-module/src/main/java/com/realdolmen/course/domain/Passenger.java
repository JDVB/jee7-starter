package com.realdolmen.course.domain;

import javax.ejb.Local;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by JDOAX80 on 9/09/2015.
 */
@Entity
@EntityListeners({DateUpdateListener.class})
@NamedQueries({
        @NamedQuery(name = Passenger.FIND_ALL, query = "SELECT p FROM Passenger p"),
        @NamedQuery(name = Passenger.FIND_ALL_LASTNAMES, query = "SELECT p FROM Passenger p WHERE p.lastName= :lastName"),
        @NamedQuery(name = Passenger.TOTAL_FREQUENT_FLYERMILES, query = "SELECT SUM(p.frequentFlyerMiles) FROM Passenger p"),
        @NamedQuery(name = Passenger.FIND_TICKETS_BY_PASSENGERID, query = "SELECT p FROM Passenger P WHERE p.id = :id"),
        @NamedQuery(name = Passenger.DELETE_ALL, query = "DELETE FROM Passenger p")
})
public class Passenger implements Serializable {


    public static final String FIND_ALL = "Passenger.findAll";
    public static final String FIND_ALL_LASTNAMES = "Passenger.findAllLastNames";
    public static final String TOTAL_FREQUENT_FLYERMILES = "Passenger.totalFrequentFlyerMiles";
    public static final String FIND_TICKETS_BY_PASSENGERID = "Passenger.findTicketsByPassengerId";
    public static final String DELETE_ALL = "Passenger.deleteAll";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    @Basic(optional = false)
    @Column(updatable = false)
    private String ssn;
    private int frequentFlyerMiles;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Temporal(TemporalType.DATE)
    private Date lastFlight;
    private int age;
    @Enumerated(EnumType.STRING)
    private PassengerType passengerType;
    @ElementCollection
    @Column(name = "creditcards")
    private List<CreditCard> creditCards = new ArrayList<>();
    @Embedded
    private Address address;
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "preferences")
    private List<String> preferences = new ArrayList<>();
    private byte[] picture;
    @OneToMany(mappedBy = "passenger", fetch = FetchType.LAZY)
    private List<Ticket> tickets = new ArrayList<>();
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastUpdated;
    /*
     * Used by JPA
     */
    protected Passenger() {

    }

    public Passenger(String firstName, String lastName, String ssn, int frequentFlyerMiles, LocalDate dateOfBirth,
                     LocalDate lastFlight, PassengerType passengerType, List<CreditCard> creditCards, Address address, List<String> preferences) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.frequentFlyerMiles = frequentFlyerMiles;
        setDateOfBirth(dateOfBirth);
        setLastFlight(lastFlight);
        this.passengerType = passengerType;
        this.creditCards = creditCards;
        this.address = address;
        this.preferences = preferences;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate date) {
        dateOfBirth= Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public int getAge() {
        return age;
    }


    @PostPersist
    @PostLoad
    @PostUpdate
    public void setAge() {
        LocalDate date = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        long years = Period.between(date, currentDate).getYears();
        age = (int)years;
    }

    public Date getLastFlight() {
        return lastFlight;
    }

    public void setLastFlight(LocalDate lastFlight) {
        this.lastFlight = Date.from(lastFlight.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public Date getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(Date dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }
}

