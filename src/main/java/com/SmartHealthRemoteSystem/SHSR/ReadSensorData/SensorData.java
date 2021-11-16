package com.SmartHealthRemoteSystem.SHSR.ReadSensorData;

public class SensorData {
    private String ecgReading;
    private double bodyTemperature;
    private int timestamp;
    private String sensorDataId;
    private String OxygenReading;

    public SensorData() {
    }

    public SensorData(String ecgReading, double bodyTemperature, int timestamp, String sensorDataId,String OxygenReading) {
        this.ecgReading = ecgReading;
        this.bodyTemperature = bodyTemperature;
        this.timestamp = timestamp;
        this.sensorDataId = sensorDataId;
        this.OxygenReading= OxygenReading;
    }

    public String getEcgReading() {
        return ecgReading;
    }

    public void setEcgReading(String ecgReading) {
        this.ecgReading = ecgReading;
    }

    public double getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public void setOxygenReading(String OxygenReading){this.OxygenReading=OxygenReading;}

    public String getOxygenReading(){return OxygenReading;}

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
