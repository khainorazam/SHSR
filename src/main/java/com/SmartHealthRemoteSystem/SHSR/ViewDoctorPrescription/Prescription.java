package com.SmartHealthRemoteSystem.SHSR.ViewDoctorPrescription;

public class Prescription {
    String ecgReading;
    Double bodyTemperature;
    int timestamp;
    String sensorDataId;

    public Prescription() {
    }

    public Prescription(String ecgReading, Double bodyTemperature, int timestamp, String sensorDataId) {
        this.ecgReading = ecgReading;
        this.bodyTemperature = bodyTemperature;
        this.timestamp = timestamp;
        this.sensorDataId = sensorDataId;
    }

    public String getEcgReading() {
        return ecgReading;
    }

    public void setEcgReading(String ecgReading) {
        this.ecgReading = ecgReading;
    }

    public Double getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(Double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getSensorDataId() {
        return sensorDataId;
    }

    public void setSensorDataId(String sensorDataId) {
        this.sensorDataId = sensorDataId;
    }
}
