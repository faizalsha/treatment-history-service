package com.example.treatmenthistoryservice.controller;


import com.example.treatmenthistoryservice.model.GenericResponse;
import com.example.treatmenthistoryservice.model.TreatmentHistory;
import com.example.treatmenthistoryservice.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        repository.save(history);
        return new GenericResponse(1, "success", history);
    }


//    @RequestMapping("/sample")
//    public TreatmentHistory sample(){
//        return new TreatmentHistory("treatment-id",
//                "physician-id",
//                2100.00,
//                "patient-id",
//                "lab-id",
//                "pharmacy-id-record",
//                "treatment-record-link",
//                new Date(2020, 10, 8),
//                new Time(12,10,15),
//                true);
//    }

}
