package ro.utcn.sd.assignmentthree.service.consultation;

import ro.utcn.sd.assignmentthree.dto.ConsultationDto;
import ro.utcn.sd.assignmentthree.entity.Consultation;

import java.util.List;

public interface ConsultationService {

    List<Consultation> getAll();

    Consultation findById(Long id);

    Consultation create(ConsultationDto consultationDto);

    void delete(Long id);

    void update(Consultation consultation);

    List<Consultation> findByPatientId(Long id);

    List<Consultation> findByDoctorId(Long id);
}
