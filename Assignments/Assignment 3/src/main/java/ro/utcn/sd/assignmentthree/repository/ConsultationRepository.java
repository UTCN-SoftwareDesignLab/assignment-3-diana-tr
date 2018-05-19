package ro.utcn.sd.assignmentthree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.utcn.sd.assignmentthree.entity.Consultation;

import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findByPatient_id(Long id);

    List<Consultation> findByUser_id(Long id);
}
