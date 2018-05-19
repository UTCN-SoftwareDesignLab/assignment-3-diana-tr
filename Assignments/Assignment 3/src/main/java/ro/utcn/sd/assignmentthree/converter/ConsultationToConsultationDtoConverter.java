package ro.utcn.sd.assignmentthree.converter;

import ro.utcn.sd.assignmentthree.dto.ConsultationDto;
import ro.utcn.sd.assignmentthree.entity.Consultation;

public class ConsultationToConsultationDtoConverter implements SuperConverter<Consultation,ConsultationDto> {
    @Override
    public ConsultationDto apply(final Consultation consultation) {
        final ConsultationDto consultationDto=new ConsultationDto();
        consultationDto.setId(consultation.getId());
        consultationDto.setDate(consultation.getDate());
        consultationDto.setPatient_id(consultation.getPatient().getId());
        consultationDto.setUser_id(consultation.getUser().getId());
        return consultationDto;
    }
}
