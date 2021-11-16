package com.SmartHealthRemoteSystem.SHSR.ReadSensorData;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

public class SensorDataRepository {
    public static final String COL_NAME = "SensorData";

    public String CreateSensorData(SensorData sensorData)
            throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture =
                //auto create data ID by firebase
                dbFirestore.collection(COL_NAME).document().set(sensorData);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String UpdateSensorData(SensorData sensorData)
            throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture =
                //auto create data ID by firebase
                dbFirestore.collection(COL_NAME).document(sensorData.getSensorDataId()).set(sensorData);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public SensorData getSensorDataDetails(String sensorDataId)
            throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(sensorDataId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        SensorData tempSensorData = null;
        if (document.exists()) {
            tempSensorData = document.toObject(SensorData.class);
            return tempSensorData;
        } else {
            return null;
        }
    }

    public String deletePatient(String sensorDataId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(sensorDataId).delete();
        return "Document with Sensor Data Id " + sensorDataId + " has been deleted";
    }
}
