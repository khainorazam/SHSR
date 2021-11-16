package com.SmartHealthRemoteSystem.SHSR.User.Patient;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

public class PatientRepository {
    public static final String COL_NAME = "Patient";

    //create and update function
    public String savePatient(Patient patient)
            throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture =
                //auto create data ID by firebase
                dbFirestore.collection(COL_NAME).document(patient.getUserId()).set(patient);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }


    public Patient getPatient(String patientId)
            throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(patientId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Patient tempPatient = null;
        if (document.exists()) {
            tempPatient  = document.toObject(Patient.class);
            return tempPatient;
        } else {
            return null;
        }
    }

    public String deletePatient(String patientId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(patientId).delete();
        return "Document with Sensor Data Id " + patientId + " has been deleted";
    }
}
