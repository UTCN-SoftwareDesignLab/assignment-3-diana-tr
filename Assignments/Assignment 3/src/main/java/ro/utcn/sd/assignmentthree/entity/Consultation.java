package ro.utcn.sd.assignmentthree.entity;

import javax.persistence.*;

@Entity
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idconsultation")
    private int id;
/*
    @ManyToOne
    @JoinColumn(name = "idpatient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Date date;

    public Consultation() {
    }

    public Consultation(Patient patient, User user, Date date) {
        this.patient = patient;
        this.user = user;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/
}
