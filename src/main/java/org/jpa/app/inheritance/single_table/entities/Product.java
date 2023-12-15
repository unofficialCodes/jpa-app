package org.jpa.app.inheritance.single_table.entities;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

/*
 * Inheritance of entities is similar to OOP Inheritance concept
 * All the Sub-Entities extended from the base entity doesn't need to have a primary key in them.
 * Inheritance has three strategies, SINGLE_TABLE, TABLE_PER_CLASS, and JOINED.
 *
 * Inheritance.SINGLE_TABLE :
 * Only a single table will be created in database, which has all the fields from inherited classes.
 * A discriminator column (DTYPE) will be automatically created to identify the inherited sub-class entity.
 *
 *
 * Modify discriminator column name, and type of discriminator with @DiscriminatorColumn annotation
 * @DiscriminatorColumn(name = "discriminator_type", discriminatorType = DiscriminatorType.CHAR)
 *
 * DiscriminatorType.INTEGER -> value of @DiscriminatorValue(value = "1") on Inherited Sub-Entities should be a Integer String (default is class name string).
 * DiscriminatorType.CHAR -> stores only a single character, not safe
 * DiscriminatorType.STRING -> stores value mentioned in @DiscriminatorValue, else if not mentioned will default to class name of the entity.
 *
 * Advantage is utilization of Inheritance concept in terms of ORM/database.
 * Disadvantage is that columns which are not identical will be saved as null values in database.
 * */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator_type", discriminatorType = DiscriminatorType.STRING)
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
