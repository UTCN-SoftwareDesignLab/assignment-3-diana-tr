package ro.utcn.sd.assignmentthree.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.utcn.sd.assignmentthree.converter.PatientDtoToPatientConverter;
import ro.utcn.sd.assignmentthree.dto.PatientDto;
import ro.utcn.sd.assignmentthree.entity.Patient;
import ro.utcn.sd.assignmentthree.repository.PatientRepository;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientDtoToPatientConverter converter;

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.getOne(id);
    }

    @Override
    public Patient create(PatientDto patientDto) {
        Patient patient = converter.apply(patientDto);
        return patientRepository.save(patient);
    }

    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public void update(Patient patient) {
        Patient newPatient = patientRepository.getOne(patient.getId());
        newPatient.setIcn(patient.getIcn());
        newPatient.setPnc(patient.getPnc());
        newPatient.setName(patient.getName());
        newPatient.setDateOfBirth(patient.getDateOfBirth());
        newPatient.setAddress(patient.getAddress());

        patientRepository.save(newPatient);
    }
}
