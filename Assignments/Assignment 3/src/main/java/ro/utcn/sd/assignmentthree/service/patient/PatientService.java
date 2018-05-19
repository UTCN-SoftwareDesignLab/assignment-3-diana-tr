package ro.utcn.sd.assignmentthree.service.patient;

import ro.utcn.sd.assignmentthree.dto.PatientDto;
import ro.utcn.sd.assignmentthree.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAll();

    Patient findById(Long id);

    Patient create(PatientDto patientDto);

    void delete(Long id);

    void update(Patient patient);
}
