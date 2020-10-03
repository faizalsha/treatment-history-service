package com.example.treatmenthistoryservice.repository;

import com.example.treatmenthistoryservice.model.TreatmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<TreatmentHistory, String> {
    List<TreatmentHistory> findAllByPhysicianId(String physicianId);
    List<TreatmentHistory> findAllByPatientId(String patientId);
}
