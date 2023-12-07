package org.jpa.app.secondaryTables;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SecondaryTables;
import jakarta.persistence.Table;

/*
* @SecondaryTable annotation was used before persistence 2.1 as an alternative to @Embeddable classes and database relations of tables.
* They provide a relation within two tables, as the primary.id is automatically mapped to the secondary.id column
* We can specify the custom column mappings, using @PrimaryKeyJoinColumn of secondary table.
* We can specify multiple secondary tables (@SecondaryTables({@SecondaryTable,@SecondaryTable})).
* */
@Entity
@SecondaryTables(value = {
        @SecondaryTable(name = "address", pkJoinColumns = {@PrimaryKeyJoinColumn(name = "company")})
})
@Table(name = "primary_tbl")
@Access(AccessType.FIELD)
public class PrimaryTable {

    @Id
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(table = "address")
    private String street;
    @Column(table = "address")
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
