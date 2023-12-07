package org.jpa.app.relationalMappings.many_to_one;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

// We can't store multiple values in One's side (as database will store values in the table, similar to ManyToMany relation in database),
// so we use the Many's side to store foreign keys of entities.

@Entity
@Table(name = "mto_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    // @OneToMany(mappedBy = "student") // Bi-directional
    @OneToMany // Uni-directional, still maps to the Many's table.
    // @JoinColumn(name = "s_id") // Uni-directional, this makes sure no extra associations table will be created for mapping of entities, maps to the Course table - Course.student_id
    private List<Course> course;

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
