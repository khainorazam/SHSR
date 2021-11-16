package com.SmartHealthRemoteSystem.SHSR.ViewDoctorPrescription;

import com.SmartHealthRemoteSystem.SHSR.ReadSensorData.SensorData;

import java.util.List;

public class Prescription {
    private String prescriptionId;
    private int timestamp;
    private String doctorId;
    private String patientId;
    private SensorData sensorData;
    private List<String> medicineList;
    private String prescriptionDescription;
    private String diagnosisAilmentDescription;

    public Prescription() {
    }

    public Prescription(String prescriptionId, int timestamp, String doctorId,
                        String patientId, SensorData sensorData, List<String> medicineList,
                        String prescriptionDescription, String diagnosisAilmentDescription) {
        this.prescriptionId = prescriptionId;
        this.timestamp = timestamp;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.sensorData = sensorData;
        this.medicineList = medicineList;
        this.prescriptionDescription = prescriptionDescription;
        this.diagnosisAilmentDescription = diagnosisAilmentDescription;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public SensorData getSensorData() {
        return sensorData;
    }

    public void setSensorData(SensorData sensorData) {
        this.sensorData = sensorData;
    }

    public List<String> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<String> medicineList) {
        this.medicineList = medicineList;
    }

    public String getPrescriptionDescription() {
        return prescriptionDescription;
    }

    public void setPrescriptionDescription(String prescriptionDescription) {
        this.prescriptionDescription = prescriptionDescription;
    }

    public String getDiagnosisAilmentDescription() {
        return diagnosisAilmentDescription;
    }

    public void setDiagnosisAilmentDescription(String diagnosisAilmentDescription) {
        this.diagnosisAilmentDescription = diagnosisAilmentDescription;
    }
}
