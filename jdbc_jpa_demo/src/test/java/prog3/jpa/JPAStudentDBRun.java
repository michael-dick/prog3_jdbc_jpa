package prog3.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by MichaelDick on 29/10/15.
 */
public class JPAStudentDBRun {
    //Create EntityManagerFactory
    public static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("jdbc_jpa_demo");

    //Create EntityManager
    public static EntityManager em = emf.createEntityManager();

    public static void main(String[] args){

        //Create Student
        Student michi = new Student(1641518 , "Michael" , "Dick" , "ukdyn@student.kit.edu");

        //Create KIT Card
        KITCard michisCard = new KITCard(0 , michi);

        michi.setKitCard(michisCard);

        //Surround with try-finally to make sure the transaction is rolled back if something goes wrong

        try {
            em.getTransaction().begin();
            em.persist(michi);
            em.getTransaction().commit();
        }finally {
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
        }


        try {
            em.getTransaction().begin();
            michi.getKitCard().setDeposit(20);
            em.merge(michi);
            em.getTransaction().commit();
        }finally {
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
        }

        michi =  em.find(Student.class , 1641518);
        System.out.println(michi);




    }

}
