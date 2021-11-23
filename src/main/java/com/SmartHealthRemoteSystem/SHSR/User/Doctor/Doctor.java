package com.SmartHealthRemoteSystem.SHSR.User.Doctor;

import com.SmartHealthRemoteSystem.SHSR.User.User;

public class Doctor extends User {
    private String hospital;
    private String position;

    public Doctor() {
    }


    public Doctor(String userId, String name, String contact, String hospital, String position) {
        super(userId, name, contact);
        this.hospital = hospital;
        this.position = position;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
