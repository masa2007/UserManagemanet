package com.example.usermanagemanet;

import android.os.Bundle;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddAnimalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddAnimalFragment extends Fragment {

    ImageView img;
    private EditText etType ;
    private EditText etGender;
    private EditText etAge;
    private EditText etColorAn;
    private EditText etPlaceAn;
    private EditText etPrice;
    private Button btnAdd;
    private FireBaseServices fbs;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddAnimalFragment() {
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
    public static AddAnimalFragment newInstance(String param1, String param2) {
        AddAnimalFragment fragment = new AddAnimalFragment();
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //connectComponents( );
    }


    private void connectComponents() {


        fbs=FireBaseServices.getInstance();
        etType = getView().findViewById(R.id.etTypeAn);
        etGender = getView().findViewById(R.id.etGenderAn);
        etAge = getView().findViewById(R.id.etAgeAn);
        etColorAn = getView().findViewById(R.id.etColorAn);
        etPlaceAn = getView().findViewById(R.id.etPlaceAn);
        etPrice=getView().findViewById(R.id.etPrice);
        btnAdd = getView().findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type,gender,age,birthdate,color,place,price;
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
                Animal aml=new Animal(type,gender,age,color,place,price);
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
}