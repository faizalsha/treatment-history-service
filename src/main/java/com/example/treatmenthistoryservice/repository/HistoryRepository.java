package com.example.treatmenthistoryservice.repository;


import com.example.treatmenthistoryservice.model.TreatmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import javax.transaction.Transactional;

public interface HistoryRepository extends JpaRepository<TreatmentHistory, String> {
    List<TreatmentHistory> findAllByPhysicianId(String physicianId);
    List<TreatmentHistory> findAllByPatientId(String patientId);
    
    //hospital - admin
    @Query(value = "SELECT * FROM Treatment_History  WHERE payment=false ", nativeQuery = true)
	List<TreatmentHistory> findAll();
    
    @Modifying(clearAutomatically = true)
	@Transactional
	@Query(value="UPDATE treatment_history a SET a.payment = b'1' WHERE a.treatment_id = ?1", nativeQuery = true)
    void updatePayment(String treatment_id);
    
    TreatmentHistory findByTreatmentId(String treatementId);
    
}
