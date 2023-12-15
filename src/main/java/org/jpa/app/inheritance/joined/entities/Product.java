package org.jpa.app.inheritance.joined.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

/*
 * Inheritance of entities is similar to OOP Inheritance concept
 * All the Sub-Entities extended from the base entity doesn't need to have a primary key in them.
 * Inheritance has three strategies, SINGLE_TABLE, TABLE_PER_CLASS, and JOINED.
 *
 * InheritanceType.JOINED -
 * A new table will be created for the parent entity and for each sub-entities, and a primary key column will be added from the parent entity that holds the same values.
 * All primary key columns in sub-entity tables are referenced (foreign key) to parent table primary key column
 * Each time a query is executed hibernate will automatically query the database with a join clause (inner/outer join) to fetch data from all the tables.
 *
 *
 * Advantage is utilization of Inheritance in terms of ORM/database.
 * Disadvantage is that each time a JOIN query is executed internally by hibernate which is less performant than others.
 * */

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // JOIN queries are executed on sub-entities/tables
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
