package ro.utcn.sd.assignmentthree.converter;

import org.springframework.stereotype.Service;
import ro.utcn.sd.assignmentthree.dto.PatientDto;
import ro.utcn.sd.assignmentthree.entity.Patient;

@Service
public class PatientDtoToPatientConverter implements SuperConverter<PatientDto, Patient> {
    @Override
    public Patient apply(final PatientDto patientDto) {
        final Patient patient = new Patient();
        patient.setId(patientDto.getId());
        patient.setName(patientDto.getName());
        patient.setIcn(patientDto.getIcn());
        patient.setPnc(patientDto.getPnc());
        patient.setAddress(patientDto.getAddress());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        return patient;
    }
}
