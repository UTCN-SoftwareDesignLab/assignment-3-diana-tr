package ro.utcn.sd.assignmentthree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.utcn.sd.assignmentthree.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
