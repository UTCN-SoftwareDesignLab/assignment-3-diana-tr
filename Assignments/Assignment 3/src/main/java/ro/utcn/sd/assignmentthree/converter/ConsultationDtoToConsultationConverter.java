package ro.utcn.sd.assignmentthree.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.utcn.sd.assignmentthree.dto.ConsultationDto;
import ro.utcn.sd.assignmentthree.entity.Consultation;
import ro.utcn.sd.assignmentthree.service.patient.PatientService;
import ro.utcn.sd.assignmentthree.service.user.UserService;

@Service
public class ConsultationDtoToConsultationConverter implements SuperConverter<ConsultationDto,Consultation> {
    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;

    @Override
    public Consultation apply(final ConsultationDto consultationDto) {
        final Consultation consultation=new Consultation();
        consultation.setId(consultationDto.getId());
        consultation.setDate(consultationDto.getDate());
        consultation.setPatient(patientService.findById(consultationDto.getPatient_id()));
        consultation.setUser(userService.findById(consultationDto.getUser_id()));
        return consultation;
    }
}
