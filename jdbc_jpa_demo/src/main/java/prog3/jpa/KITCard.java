package prog3.jpa;

import javax.persistence.*;

/**
 * Created by MichaelDick on 28/10/15.
 */
@Entity
public class KITCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CARD_ID")
    private int id;

    private double deposit;

    @OneToOne(fetch = FetchType.LAZY)
    private Student student;

    //Constructors


    public KITCard() {
    }

    public KITCard(double deposit, Student student) {
        this.deposit = deposit;
        this.student = student;
    }

    //getter and setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "KITCard{" +
                "id=" + id +
                ", deposit=" + deposit +
                ", studentId=" + student.getMatnr() +
                '}';
    }
}