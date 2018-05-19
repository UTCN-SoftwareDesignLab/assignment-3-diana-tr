package ro.utcn.sd.assignmentthree.dto;

import org.springframework.format.annotation.DateTimeFormat;
import ro.utcn.sd.assignmentthree.entity.Patient;
import ro.utcn.sd.assignmentthree.entity.User;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class ConsultationDto {

    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;

    private Long patient_id;

    private Long user_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
