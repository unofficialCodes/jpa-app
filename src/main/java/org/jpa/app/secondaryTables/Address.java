package org.jpa.app.secondaryTables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Address {

    @Id
    private int id;
    private String street;
    private String city;
    @Column
    private int company;
}
