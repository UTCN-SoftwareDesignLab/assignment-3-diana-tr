package ro.utcn.sd.assignmentthree.entity;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idpatient")
    private Long id;

    private String name;
    private int icn;
    private int pnc;
    @Column(name = "dateOfBirth")
    private Timestamp dateOfBirth;
    private String address;

    public Patient() {
    }

    public Patient(String name, int icn, int pnc, Timestamp dateOfBirth, String address) {
        this.name = name;
        this.icn = icn;
        this.pnc = pnc;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcn() {
        return icn;
    }

    public void setIcn(int icn) {
        this.icn = icn;
    }

    public int getPnc() {
        return pnc;
    }

    public void setPnc(int pnc) {
        this.pnc = pnc;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
