package org.jpa.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.annotations.LazyGroup;

@Entity
@Table(name = "annotated_entity_tbl", schema = "public", uniqueConstraints = {@UniqueConstraint(name = "id", columnNames = {"id"})})
@SequenceGenerator(name = "id_sq", allocationSize = 1, initialValue = 1, sequenceName = "id_sq")
public class AnnotatedEntity {

    @Id
    // @GeneratedValue(generator = "id_sq", strategy = GenerationType.IDENTITY)
    // GenerationType.TABLE -> This generation type is similar to sequence but a new table is created with pk (sequence name) and key-value (sequence generator) columns
    @GeneratedValue(generator = "my_sequence", strategy = GenerationType.TABLE)
    @TableGenerator(name = "my_sequence",
            table = "key_generator", // table name of GenerationType.TABLE
            pkColumnName = "key_name", // primary key column name (String/Varchar)
            pkColumnValue = "id_sequence", // primary key column name or sequence name or value
            valueColumnName = "key_value_generator", // sequence generation column name
            allocationSize = 20, // generation sequence allocation size
            schema = "public" // schema of the table
    )


//    @LazyGroup(value = "DEFAULT")
    private int id;
    @Column(name = "fields")
    private String field;

    @PostLoad
    public void postLoad() {
        System.out.println("Entity loaded to the context");
    }

    @PostUpdate
    public void postUpdate() {
        System.out.println("Updated entity saved to DB" + this);
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("Entity state changed ");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "AnnotatedEntity{" +
                "id=" + id +
                ", field='" + field + '\'' +
                '}';
    }
}
