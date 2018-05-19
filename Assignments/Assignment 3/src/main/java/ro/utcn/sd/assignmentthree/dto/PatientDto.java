package ro.utcn.sd.assignmentthree.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class PatientDto {

    private Long id;

    @NotNull(message = "Please enter the name")
    private String name;

    private int icn;
    @Size(min = 13, message = "Personal numerical code must be 13 digits long")
    private int pnc;

    private Timestamp dateOfBirth;
    private String address;

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
