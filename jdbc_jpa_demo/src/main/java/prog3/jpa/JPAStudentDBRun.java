package prog3.jpa;


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


    public static void main(String[] args) {


        //Create Student
        Student michi = new Student(1641518, "Michael", "Dick", "ukdyn@student.kit.edu");

        //Create KIT Card
        //new KITCard(double deposit , Student student)
        //Id autogeneriert
        KITCard michisCard = new KITCard(0, michi);

        //Bidirektionalitaet der Referenz
        michi.setKitCard(michisCard);

            //Schreiben auf die Datenbank benoetigt eine Transaktion
            em.getTransaction().begin();
            em.persist(michi);
            em.getTransaction().commit();


        //Auslesen benörigt keine Transaktion
        michi = em.find(Student.class, 1641518);
        System.out.println(michi);


        //Aufladen der Karte benoetigt wiederum eine Transaktion
        em.getTransaction().begin();
        michi.getKitCard().setDeposit(12.38);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}




