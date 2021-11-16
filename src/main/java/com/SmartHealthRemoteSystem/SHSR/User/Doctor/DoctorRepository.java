package com.SmartHealthRemoteSystem.SHSR.User.Doctor;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

public class DoctorRepository {
    public static final String COL_NAME = "Doctor";

    //create and update function
    public String saveDoctor(Doctor doctor)
            throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture =
                //auto create data ID by firebase
                dbFirestore.collection(COL_NAME).document(doctor.getUserId()).set(doctor);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }


    public Doctor getDoctor(String doctorId)
            throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(doctorId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Doctor tempDoctor = null;
        if (document.exists()) {
            tempDoctor  = document.toObject(Doctor.class);
            return tempDoctor;
        } else {
            return null;
        }
    }

    public String deleteDoctor(String doctorId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(doctorId).delete();
        return "Document with Sensor Data Id " + doctorId + " has been deleted";
    }
}
