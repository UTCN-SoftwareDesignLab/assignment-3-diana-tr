package ro.utcn.sd.assignmentthree.service.consultation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.utcn.sd.assignmentthree.converter.ConsultationDtoToConsultationConverter;
import ro.utcn.sd.assignmentthree.dto.ConsultationDto;
import ro.utcn.sd.assignmentthree.entity.Consultation;
import ro.utcn.sd.assignmentthree.repository.ConsultationRepository;

import java.util.List;

@Service
public class ConsultationServiceImpl implements ConsultationService {
    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private ConsultationDtoToConsultationConverter converter;

    @Override
    public List<Consultation> getAll() {
        return consultationRepository.findAll();
    }

    @Override
    public Consultation findById(Long id) {
        return consultationRepository.getOne(id);
    }

    @Override
    public Consultation create(ConsultationDto consultationDto) {
        Consultation consultation = converter.apply(consultationDto);
        return consultationRepository.save(consultation);
    }

    @Override
    public void delete(Long id) {
        consultationRepository.deleteById(id);
    }

    @Override
    public void update(Consultation consultation) {
        Consultation newConsultation = consultationRepository.getOne(consultation.getId());
        newConsultation.setDate(consultation.getDate());
        newConsultation.setUser(consultation.getUser());
        newConsultation.setPatient(consultation.getPatient());

        consultationRepository.save(newConsultation);
    }

    @Override
    public List<Consultation> findByPatientId(Long id) {
        return consultationRepository.findByPatient_id(id);
    }

    @Override
    public List<Consultation> findByDoctorId(Long id) {
        return consultationRepository.findByUser_id(id);
    }
}
