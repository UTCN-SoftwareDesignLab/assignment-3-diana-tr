package ro.utcn.sd.assignmentthree.converter;

import ro.utcn.sd.assignmentthree.dto.PatientDto;
import ro.utcn.sd.assignmentthree.entity.Patient;

public class PatientToPatientDtoConverter implements SuperConverter<Patient, PatientDto> {
    @Override
    public PatientDto apply(final Patient patient) {
        final PatientDto patientDto = new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setIcn(patient.getIcn());
        patientDto.setPnc(patient.getPnc());
        patientDto.setAddress(patient.getAddress());
        patientDto.setName(patient.getName());
        patientDto.setDateOfBirth(patient.getDateOfBirth());
        return patientDto;
    }
}
