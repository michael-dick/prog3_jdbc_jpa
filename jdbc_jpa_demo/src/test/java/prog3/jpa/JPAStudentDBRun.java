package prog3.jpa;

import prog3.AbstractDBRun;

/**
 * Created by MichaelDick and Philipp Ratz on 31/10/15.
 */
public class JPAStudentDBRun extends AbstractDBRun {

    public static void main(String[] args) {


        //Create Student
        Student michi = new Student(1641518, "Michael", "Dick", "ukdyn@student.kit.edu");

        //Create KIT Card
        KITCard michisCard = new KITCard(0, michi);

        michi.setKitCard(michisCard);

            em.getTransaction().begin();
            em.persist(michi);
            em.getTransaction().commit();


        michi = em.find(Student.class, 1641518);
        System.out.println(michi);
    }
}




