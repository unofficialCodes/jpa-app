package org.jpa.app.inheritance.table_per_class.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

/*
 * Inheritance of entities is similar to OOP Inheritance concept
 * All the Sub-Entities extended from the base entity doesn't need to have a primary key in them.
 * Inheritance has three strategies, SINGLE_TABLE, TABLE_PER_CLASS, and JOINED.
 *
 * InheritanceType.TABLE_PER_CLASS -
 * A new table will be created for each sub-entities, and primary keys, along with other parent entity fields will be added to the sub-entity table in database.
 * Internally executes a "union all" (which is not supported by jpql) query to fetch the data (when querying for the parent data).
 *
 * Advantage is utilization of Inheritance in terms of ORM/database.
 * Disadvantage is that each time a "union all" query is executed internally by hibernate which is not supported by the JPQL query.
 * */

@Entity
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
