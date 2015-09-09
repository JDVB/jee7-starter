package com.realdolmen.course.persistence;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by JDOAX80 on 9/09/2015.
 */
@Embeddable
public class PassengerId implements Serializable {
    private String firstName;
    private String ssn;

    protected PassengerId(){

    }

    public PassengerId(String firstName, String ssn) {
        this.firstName = firstName;
        this.ssn = ssn;
    }

    public String getSsn() {
        return ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassengerId that = (PassengerId) o;

        if (!firstName.equals(that.firstName)) return false;
        return ssn.equals(that.ssn);

    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + ssn.hashCode();
        return result;
    }

}
