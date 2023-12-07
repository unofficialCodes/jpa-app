package org.jpa.app.relationalMappings.many_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.jpa.app.relationalMappings.many_to_one.config.CustomPersistenceUnitInfo;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class TestDrive {
    public static void main(String[] args) {
        String puName = "many-to-one";

        Map<String, String> props = new IdentityHashMap<>();

        props.put("jakarta.persistence.schema-generation.database.action", "drop-and-create");
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.format_sql", "true");

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);

        EntityManager em = emf.createEntityManager();

        EntityTransaction eTx = em.getTransaction();

        eTx.begin();

        Student student = new Student("student-1");
        Course course = new Course("course-1");
//        course.setStudent(student);
        student.setCourse(List.of(course));
        course.setStudent(student);

        em.persist(student); // Add to the context
        em.persist(course); // Add to the context

        eTx.commit();

        em.close();
        emf.close();
    }
}
