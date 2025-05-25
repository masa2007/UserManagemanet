package com.example.usermanagemanet.Fragments.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.usermanagemanet.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnimalDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnimalDetailsFragment extends Fragment {

    private TextView tvType,tvGender,tvColor,tvAge,
            tvPlace,tvPrice;
    private ImageView ivAnimal;
    private FireBaseServices fbs;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnimalDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnimalDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnimalDetailsFragment newInstance(String param1, String param2) {
        AnimalDetailsFragment fragment = new AnimalDetailsFragment();
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
        return inflater.inflate(R.layout.fragment_animal_details, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        connectComponents();

    }

    private void connectComponents() {
        fbs = FireBaseServices.getInstance();
        tvType = getView().findViewById(R.id.tvTypeDetailsFragment);
        tvGender = getView().findViewById(R.id.tvGenderDetailsFragment);
        tvAge = getView().findViewById(R.id.tvAgeDetailsFragment);
        tvColor = getView().findViewById(R.id.tvColorDetailsFragment);
        tvPlace = getView().findViewById(R.id.tvPlaceDetailsFragment);
        tvPrice = getView().findViewById(R.id.tvPriceDetailsFragment);
        ivAnimal = getView().findViewById(R.id.ivAnimalDetailsFragment);


    }
}