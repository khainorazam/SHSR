package com.SmartHealthRemoteSystem.SHSR.User;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

public class UserRepository {
    public static final String COL_NAME = "User";

    //create and update function
    public String saveUser(User user)
            throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture =
                //auto create data ID by firebase
                dbFirestore.collection(COL_NAME).document(user.getUserId()).set(user);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public User getUser(String userId)
            throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(userId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        User tempUser = null;
        if (document.exists()) {
            tempUser  = document.toObject(User.class);
            return tempUser;
        } else {
            return null;
        }
    }

    public String deleteUser(String userId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(userId).delete();
        return "Document with Sensor Data Id " + userId + " has been deleted";
    }
}
