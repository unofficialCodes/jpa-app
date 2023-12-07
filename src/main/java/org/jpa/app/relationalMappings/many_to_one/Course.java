package org.jpa.app.relationalMappings.many_to_one;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Standard convention is to mention the mapping in the @ManyToOne mapped class, instead of @OneToMany class (table mapping)

@Entity
@Table(name = "mto_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne(optional = false, targetEntity = Student.class) // Uni-directional, Bi-directional
    @JoinColumn(name = "s_id") // Uni-directional, Bi-directional. @AttributesOverrides or @AttributeOverride doesn't work in @ManyToOne mapping class, only @JoinColumn can override the column.
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course() {
    }
}
