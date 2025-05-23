package com.example.usermanagemanet.Fragments.Data;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.usermanagemanet.Fragments.fragment.FireBaseServices;
import com.example.usermanagemanet.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import com.example.usermanagemanet.Fragments.Adapter.AnimalAdapter;
import com.example.usermanagemanet.Fragments.Classes.Animal;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllAnimalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllAnimalFragment extends Fragment {

    private FireBaseServices fbs;
    private ArrayList<Animal>amllist;
    private RecyclerView rvAnimal;
    private AnimalAdapter adapter;
    private Image img;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AllAnimalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllAnimalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AllAnimalFragment newInstance(String param1, String param2) {
        AllAnimalFragment fragment = new AllAnimalFragment();
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
            String filterType = getArguments().getString("buy-adopt");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_animal, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();

        fbs = FireBaseServices.getInstance();
        amllist = new ArrayList<>();
        rvAnimal = getView().findViewById(R.id.rvAnimalAmlFragment);
        rvAnimal.setHasFixedSize(true);
        rvAnimal.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AnimalAdapter(getActivity(), amllist);
        rvAnimal.setAdapter(adapter);
        fbs.getFire().collection("animals").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                for (DocumentSnapshot dataSnapshot: queryDocumentSnapshots.getDocuments()){
                    Animal aml = dataSnapshot.toObject(Animal.class);

                    amllist.add(aml);
                }

                adapter.notifyDataSetChanged();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "No data available", Toast.LENGTH_SHORT).show();
                Log.e("AllAnimalFragment", e.getMessage());
            }
        });
    }


}