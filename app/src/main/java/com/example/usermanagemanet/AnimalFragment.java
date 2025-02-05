package com.example.usermanagemanet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnimalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnimalFragment extends Fragment {

    private EditText etType ,etCategory;
    private EditText etGender;
    private EditText etAge;
    private EditText etBirthdate;
    private EditText etColorAn;
    private EditText etPlaceAn;
    private EditText etPrice;
    private FireBaseServices fbs;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnimalFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnimalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnimalFragment newInstance(String param1, String param2) {
        AnimalFragment fragment = new AnimalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animal, container, false);
    }
    public void onStart() {
        super.onStart();
        connectComponents();
    }

    public void connectComponents() {
        etType = getActivity().findViewById(R.id.etTypeAn);
        etGender = getActivity().findViewById(R.id.etGenderAn);
        etAge = getActivity().findViewById(R.id.etAgeAn);
        etBirthdate = getActivity().findViewById(R.id.etBirth);
        etColorAn = getActivity().findViewById(R.id.etColorAn);
        etPlaceAn = getActivity().findViewById(R.id.etPlaceAn);
        etPrice=getActivity().findViewById(R.id.etPrice);
        fbs=FireBaseServices.getInstance();
        Button btnAdd = getActivity().findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type,gender,age,birthdate,color,place,Category,price;
                type=etType.getText().toString();
                gender=etGender.getText().toString();
                age=etAge.getText().toString();
                birthdate=etBirthdate.getText().toString();
                color= etColorAn.getText().toString();
                place= etPlaceAn.getText().toString();
                Category=etCategory.getText().toString();
                price=etPrice.getText().toString();


                if (type.trim().isEmpty()||gender.trim().isEmpty()||age.trim().isEmpty()||birthdate.trim().isEmpty()||
                color.trim().isEmpty()||place.trim().isEmpty()||Category.trim().isEmpty()||price.trim().isEmpty())
                {
                    Toast.makeText(getActivity(), " some fields are empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                Animals aml=new Animals(type,gender,age,birthdate,color,place,Category,price);
                fbs.getFire().collection("animals").add(aml).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });


            }

        });
    }
}