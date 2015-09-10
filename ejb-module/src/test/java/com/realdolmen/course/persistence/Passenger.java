package com.realdolmen.course.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by JDOAX80 on 9/09/2015.
 */
@Entity
public class Passenger implements Serializable {
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
    @CollectionTable()
    @Column(name = "creditcards")
    @Embedded
    private List<CreditCard> creditCards = new ArrayList<>();
    @Embedded
    private Address address;
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "preferences")
    private List<String> preferences = new ArrayList<>();
    private byte[] picture;
    @OneToMany
    private List<Ticket> tickets = new ArrayList<>();
    @ManyToMany(mappedBy = "passengers")
    private List<Flight> flights =  new ArrayList<>();
    /*
     * Used by JPA
     */
    protected Passenger() {

    }

    public Passenger(String firstName, String lastName, String ssn, int frequentFlyerMiles, Date dateOfBirth,
                     Date lastFlight, PassengerType passengerType, List<CreditCard> creditCards, Address address, List<String> preferences) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.dateOfBirth = dateOfBirth;
        this.lastFlight = lastFlight;
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

    public void setDateOfBirth(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, Calendar.NOVEMBER, day);
        dateOfBirth = cal.getTime();
        setAge(dateOfBirth);
    }

    public int getAge() {
        return age;
    }

    public void setAge(Date dateOfBirth) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateOfBirth);
        Calendar today = Calendar.getInstance();
        int tempAge = today.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
        if(today.get(Calendar.DAY_OF_YEAR) < cal.get(Calendar.DAY_OF_YEAR))
            tempAge--;
        age = tempAge;
    }

    public Date getLastFlight() {
        return lastFlight;
    }

    public void setLastFlight(Date lastFlight) {
        this.lastFlight = lastFlight;
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
}

enum PassengerType {
    OCCASIONAL, REGULAR
}
