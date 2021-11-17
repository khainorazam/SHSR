package com.SmartHealthRemoteSystem.SHSR.SendDailyHealth;

import com.SmartHealthRemoteSystem.SHSR.ReadSensorData.SensorData;


public class HealthStatus {
    //add health status Id to prevent conflict in database
    private String healthStatusId;
    private SensorData sensorData;
    private String additionalNotes;
    private String patientId;
    private String doctorId;
    private int timestamp;

    public HealthStatus() {
    }

    public HealthStatus(String healthStatusId, SensorData sensorData, String additionalNotes, String patientId, String doctorId, int timestamp) {
        this.healthStatusId = healthStatusId;
        this.sensorData = sensorData;
        this.additionalNotes = additionalNotes;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.timestamp = timestamp;
    }

    public String getHealthStatusId() {
        return healthStatusId;
    }

    public void setHealthStatusId(String healthStatusId) {
        this.healthStatusId = healthStatusId;
    }

    public SensorData getSensorData() {
        return sensorData;
    }

    public void setSensorData(SensorData sensorData) {
        this.sensorData = sensorData;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}
