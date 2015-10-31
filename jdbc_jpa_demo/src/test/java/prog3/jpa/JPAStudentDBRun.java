package prog3.jpa;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by MichaelDick and Philipp Ratz on 31/10/15.
 */
public class JPAStudentDBRun {
    //Create EntityManagerFactory
    public static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("jdbc_jpa_demo");

    //Create EntityManager
    public static EntityManager em = emf.createEntityManager();

    @Test
    public void testCreateStudent() throws Exception {
        //Create Student
        Student michi = new Student(1641518, "Michael", "Dick", "ukdyn@student.kit.edu");

        //Create KIT Card
        KITCard michisCard = new KITCard(0, michi);

        michi.setKitCard(michisCard);

        //Surround with try-finally to make sure the transaction is rolled back if something goes wrong

        try {
            em.getTransaction().begin();
            em.persist(michi);
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
        }

        michi = em.find(Student.class, 1641518);
        System.out.println(michi);
    }

    @Test
    public void testDeleteStudent() throws Exception {
        Student michi = em.find(Student.class, 1641518);

        try {
            em.getTransaction().begin();
            em.remove(michi);
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
        }
    }


}
