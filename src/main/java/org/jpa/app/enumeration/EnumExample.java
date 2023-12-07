package org.jpa.app.enumeration;

import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EnumExample {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("student-pu");

        var em = emf.createEntityManager();

        var eTx = em.getTransaction();

        eTx.begin();

        Employee employee = new Employee();
        employee.setName("employee-1");
        employee.setCurrency(Currency.DOLLAR);
        employee.setJoinedAt(LocalDateTime.now());

        em.persist(employee);

        eTx.commit();

        em.close();
        emf.close();
    }
}
