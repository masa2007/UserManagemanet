package com.example.usermanagemanet.Fragments.fragment;

import android.net.Uri;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class FireBaseServices {

    private static FireBaseServices instance;
    // private final FireBaseServices fbs = FireBaseServices.getInstance(); ← غير ضروري

    private FirebaseAuth auth;
    private FirebaseFirestore fire;
    private FirebaseStorage storage;

    private Uri selectedImageURL;
    // 🔒 تم تعليق دعم تخزين رابط الصورة
    // private Uri selectedImageURI;

    public Uri getSelectedImageURL() {
        return selectedImageURL;
    }
    public void setSelectedImageURL(Uri selectedImageURL) {
        this.selectedImageURL = selectedImageURL;}


    public FireBaseServices() {
        auth = FirebaseAuth.getInstance();
        fire = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();
        selectedImageURL=null;
    }

    public static FireBaseServices getInstance() {
        if (instance == null) {
            instance = new FireBaseServices();
        }
        return instance;
    }

    public FirebaseStorage getStorage() {
        return storage;
    }

    public FirebaseFirestore getFire() {
        return fire;
    }

    public FirebaseAuth getAuth() {
        return auth;
    }
}
