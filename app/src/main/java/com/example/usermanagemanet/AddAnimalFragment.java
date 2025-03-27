package com.example.usermanagemanet;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;


public class AddAnimalFragment extends Fragment {

    private static final int PICK_IMAGE_REQUEST = 1;

    private ImageView imgView;

    private EditText etType ;
    private EditText etGender;
    private EditText etAge;
    private EditText etColorAn;
    private EditText etPlaceAn;
    private EditText etPrice;
    private Button btnAdd;
    private FireBaseServices fbs;
    private Utils utils;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animal, container, false);
        imgView = view.findViewById(R.id.ivamlAddamlFragment);

        imgView.setOnClickListener(v -> openGallery());

        return view;
    }
    public void onStart() {
        super.onStart();
        connectComponents();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //connectComponents( );
    }


    private void connectComponents() {


        fbs = FireBaseServices.getInstance();
        utils = Utils.getInstance();
        etType = getView().findViewById(R.id.etTypeAn);
        etGender = getView().findViewById(R.id.etGenderAn);
        etAge = getView().findViewById(R.id.etAgeAn);
        etColorAn = getView().findViewById(R.id.etColorAn);
        etPlaceAn = getView().findViewById(R.id.etPlaceAn);
        etPrice = getView().findViewById(R.id.etPrice);
        btnAdd = getView().findViewById(R.id.btnAdd);
        imgView = getView().findViewById(R.id.ivamlAddamlFragment);

        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }

        });



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type,gender,age,color,place,price;
                utils = Utils.getInstance();
                type=etType.getText().toString();
                gender=etGender.getText().toString();
                age=etAge.getText().toString();
                color= etColorAn.getText().toString();
                place= etPlaceAn.getText().toString();
                price=etPrice.getText().toString();

                if (type.trim().isEmpty()||gender.trim().isEmpty()||age.trim().isEmpty()||
                color.trim().isEmpty()||place.trim().isEmpty() ||price.trim().isEmpty())
                {
                    Toast.makeText(getActivity(), " some fields are empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                Animal aml;
                if (fbs.getSelectedImageURL() == null)
                {
                     aml= new Animal(type, gender, age, color ,place,price);
                }
                else {
                     aml= new Animal(type, gender, age, color ,place,price,fbs.getSelectedImageURL().toString());

                }
                fbs.getFire().collection("animals").add(aml).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getActivity(), "Successfully added your animal!", Toast.LENGTH_SHORT).show();
                        gotoAllAnimalFragment();

                    }
                    

                    private void gotoAllAnimalFragment() {
                        FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.FrameLayoutFrame,new AllAnimalFragment());
                        ft.commit();

                    }

                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("Failure Add animal: ", e.getMessage());

                    }
                });
            }
        });

    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            imgView.setImageURI(imageUri);
        }
    }


    public void toBigImg(View view) {
    }

}
