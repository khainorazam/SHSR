package com.SmartHealthRemoteSystem.SHSR.SendDailyHealth;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class HealthStatusRepository {
    public static final String COL_NAME = "HealthStatus";

    public String CreateHealthStatus(HealthStatus healthStatus)
            throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture =
                //auto create data ID by firebase
                dbFirestore.collection(COL_NAME).document().set(healthStatus);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String UpdateHealthStatus(HealthStatus healthStatus)
            throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture =
                //auto create data ID by firebase
                dbFirestore.collection(COL_NAME).document(healthStatus.getHealthStatusId()).set(healthStatus);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public List<HealthStatus> getListHealthStatus(String patientId)
            throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection(COL_NAME).listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();

        List<HealthStatus> healthStatusList = new ArrayList<>();
        HealthStatus healthStatus = null;
        while (iterator.hasNext()) {
            DocumentReference documentReference1=iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot document = future.get();
            healthStatus = document.toObject(HealthStatus.class);

            //Only query health status that is request by the patient
            //Alt - can send all healthStatus info to service class but data will not secured
            if(healthStatus.getPatientId().equals(patientId)){
                healthStatusList.add(healthStatus);
            }
        }

        return healthStatusList;
    }


    public String deleteHealthStatus(String healthStatusId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(healthStatusId).delete();
        return "Document with Sensor Data Id " + healthStatusId + " has been deleted";
    }
}
