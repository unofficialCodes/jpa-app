package org.jpa.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.jpa.app.model.Student;

public class App
{
    public static void main( String[] args )
    {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("student-pu");

        EntityManager em = emf.createEntityManager();

        EntityTransaction eTx = em.getTransaction();

        eTx.begin();

        Student student = new Student("student-1", "student1@gmail.com");
        em.persist(student);
        // PERSIST 100
        // DELETE 100
        // PERSIST 102 -> only this statement will be mirrored to the database, other statements will be managed by the context.

        eTx.commit();

        em.close();
        emf.close();
    }
}
