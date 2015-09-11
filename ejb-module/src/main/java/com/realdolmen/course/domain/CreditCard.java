package com.realdolmen.course.domain;

import javax.persistence.Embeddable;
import javax.persistence.Enumerated;

/**
 * Created by JDOAX80 on 10/09/2015.
 */
@Embeddable
public class CreditCard {
    String number;
    String expiryDate;
    Integer controlNumber;
    @Enumerated
    CreditCardType creditCardType;

    protected CreditCard() {

    }

    public CreditCard(String number, String expiryDate, Integer controlNumber, CreditCardType creditCardType) {
        this.number = number;
        this.expiryDate = expiryDate;
        this.controlNumber = controlNumber;
        this.creditCardType = creditCardType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(Integer controlNumber) {
        this.controlNumber = controlNumber;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }
}
