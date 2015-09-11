package com.realdolmen.course.domain;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

/**
 * Created by JDOAX80 on 10/09/2015.
 */
@MappedSuperclass
public abstract class AbstractEntity {
    private LocalDate lastUpdated;
    private String modifiedBy;
    private int version;
}
