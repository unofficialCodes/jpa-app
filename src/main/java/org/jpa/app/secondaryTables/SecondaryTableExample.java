package org.jpa.app.secondaryTables;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SecondaryTableExample {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");

        EntityManager em = emf.createEntityManager();

        EntityTransaction eTx = em.getTransaction();

        eTx.begin();

        PrimaryTable primaryTable = new PrimaryTable();
        primaryTable.setId(1);
        primaryTable.setCity("city-1");
        primaryTable.setStreet("street-1");
        primaryTable.setName("record-1");

        em.persist(primaryTable);

        eTx.commit();

        em.close();
        emf.close();
    }
}
