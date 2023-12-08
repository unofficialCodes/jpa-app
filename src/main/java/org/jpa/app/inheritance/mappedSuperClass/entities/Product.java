package org.jpa.app.inheritance.mappedSuperClass.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;

/*
 * MappedSuperclass is a marker interface, which is similar to OOP Inheritance concept but it is not a Entity,
 *  hence no query can be created to fetch the data referencing this class.
 *
 * MappedSuperclass should be used when we don't have to query all the sub-entities referencing the parent entity,
 *  rather it can be used to just share the fields that we want to keep in common with other entities.
 *
 *
 * Advantage is utilization of Inheritance in terms of ORM/database.
 * Disadvantage is that each time a "union all" query is executed internally by hibernate which is not supported by the JPQL query.
 * */

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // JOIN queries are executed on sub-entities/tables
public abstract class Product {

    @Id
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
