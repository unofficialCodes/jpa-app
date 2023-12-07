package org.jpa.app.relationalMappings.one_to_many.bidirectional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.jpa.app.relationalMappings.one_to_many.bidirectional.config.CustomPersistenceUnitInfo;

import java.util.Collections;
import java.util.List;

public class TestDrive {
    public static void main(String[] args) {
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), Collections.EMPTY_MAP);

        EntityManager em = emf.createEntityManager();

        EntityTransaction eTx = em.getTransaction();

        eTx.begin();

        Course c1 = new Course("course-1");
        Course c2 = new Course("course-2");

        Student student = new Student();
        student.setName("student-1");
        student.setCourses(List.of(c1, c2));

        c1.setStudent(student);
        c2.setStudent(student);

        em.persist(c1);
        em.persist(c2);
        em.persist(student); // Add to the context

        eTx.commit();

        em.close();
        emf.close();
    }
}
