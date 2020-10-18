package com.example.treatmenthistoryservice.controller;


import com.example.treatmenthistoryservice.model.GenericResponse;
import com.example.treatmenthistoryservice.model.TreatmentHistory;
import com.example.treatmenthistoryservice.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.sql.Date;
import java.sql.Time;

@RestController
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    private HistoryRepository repository;

    @RequestMapping("/patient/{patientId}")
    public GenericResponse getAllRecordsByPatientId(@PathVariable String patientId){
        return new GenericResponse(1,
                "successful",
                repository.findAllByPatientId(patientId));
    }

    @RequestMapping("/physician/{physicianId}")
    public GenericResponse getAllRecordsByPhysicianId(@PathVariable String physicianId){
        return new GenericResponse(1,
                "successful",
                repository.findAllByPhysicianId(physicianId));
    }

    @RequestMapping(value = "/insert-history", method = RequestMethod.POST)
    public GenericResponse insertHistory(@RequestBody TreatmentHistory history){
        return new GenericResponse(1, "success", repository.save(history));
    }

    @RequestMapping("/get-history-by-id/{recordId}")
    public GenericResponse getRecordById(@PathVariable String recordId){
        GenericResponse response;
        try{
            response =  new GenericResponse(1, "succes", repository.findById(recordId).get());
        }catch (Exception e){
            return new GenericResponse(0, "exception occurred" + e.getMessage(), null);
        }
        return response;
    }

    @RequestMapping(value = "/update-history/{recordId}", method = RequestMethod.POST)
    public GenericResponse updateHistory(@PathVariable String recordId, @RequestBody TreatmentHistory newRecord){
        TreatmentHistory oldRecord;
        try {
            oldRecord = repository.findById(recordId).get();
        }catch (Exception e){
            return new GenericResponse(0, "Exception occurred" + e.getMessage(), null);
        }
        oldRecord.setTreatmentReportLink(newRecord.getTreatmentReportLink());
        oldRecord.setPharmacyRecordId(newRecord.getPharmacyRecordId());
        oldRecord.setBillAmount(newRecord.getBillAmount());
        oldRecord.setPharmacyRecordId(newRecord.getPharmacyRecordId());
        oldRecord.setStatus(newRecord.getStatus());
        //this update the record in table see jpaRepository documentation
        repository.save(oldRecord);
        return new GenericResponse(1, "success", oldRecord);
    }


    @RequestMapping("/sample")
    public TreatmentHistory sample(){
        return new TreatmentHistory("physician-id",
                1020.00,
                "patient-id",
                "lab-id",
                "pharmacy-id-record",
                "treatment-record-link",
                new Date(2020, 10, 8),
                new Time(12,10,15),
                true,
                "pcm,bitadin,wax",
                "x-ray,mri,brain imaging,ultrasound",
                "take two medicine everyday");
    }

}
