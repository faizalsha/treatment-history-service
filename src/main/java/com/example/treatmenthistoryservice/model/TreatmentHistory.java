package com.example.treatmenthistoryservice.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;

@Entity
public class TreatmentHistory{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String treatmentId;
    private String physicianId;
    private double billAmount;
    private String patientId;
    private String labId;
    private String pharmacyRecordId;
    private String treatmentReportLink;
    private Date date;
    private Time time;
    private boolean status;

    public TreatmentHistory() {
    }

    public TreatmentHistory(String treatmentId, String physicianId, double billAmount, String patientId, String labId, String pharmacyRecordId, String treatmentReportLink, Date date, Time time, boolean status) {
        this.treatmentId = treatmentId;
        this.physicianId = physicianId;
        this.billAmount = billAmount;
        this.patientId = patientId;
        this.labId = labId;
        this.pharmacyRecordId = pharmacyRecordId;
        this.treatmentReportLink = treatmentReportLink;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public String getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(String treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(String physicianId) {
        this.physicianId = physicianId;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    public String getPharmacyRecordId() {
        return pharmacyRecordId;
    }

    public void setPharmacyRecordId(String pharmacyRecordId) {
        this.pharmacyRecordId = pharmacyRecordId;
    }

    public String getTreatmentReportLink() {
        return treatmentReportLink;
    }

    public void setTreatmentReportLink(String treatmentReportLink) {
        this.treatmentReportLink = treatmentReportLink;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}