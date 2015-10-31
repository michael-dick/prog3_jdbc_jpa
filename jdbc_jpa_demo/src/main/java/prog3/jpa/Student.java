package prog3.jpa;

import javax.persistence.*;

/**
 * Created by MichaelDick and Philipp Ratz on 31/10/15.
 */
@Entity
public class Student {


    @Id //don't use value generator in this case, since Matrikelnummer is unique
    @Column(name = "STUDENT_ID")
    private int matnr;

    private String firstname;

    private String lastname;

    private String email;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //lazy means "load kitcard on-demand --> only when needed" cascade.all means, persist,remove,merge kitcard when performing those operations for student
    private KITCard kitCard;

    //Constructors

    public Student() {
    }

    public Student(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public Student(int matnr, String firstname, String lastname, String email) {
        this.matnr = matnr;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    //Getter and Setter

    public int getMatnr() {
        return matnr;
    }

    public void setMatnr(int matnr) {
        this.matnr = matnr;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public KITCard getKitCard() {
        return kitCard;
    }

    public void setKitCard(KITCard kitCard) {
        this.kitCard = kitCard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "matnr=" + matnr +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", kitCard=" + kitCard +
                '}';
    }
}
