package com.example.usermanagemanet.Fragments.Data;

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

import com.example.usermanagemanet.Fragments.Adapter.AnimalAdapter;
import com.example.usermanagemanet.Fragments.Classes.Animal;
import com.example.usermanagemanet.Fragments.fragment.FireBaseServices;
import com.example.usermanagemanet.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class AllAnimalFragment extends Fragment {

    private FireBaseServices fbs;
    private ArrayList<Animal> amllist;
    private RecyclerView rvAnimal;
    private AnimalAdapter adapter;

    public AllAnimalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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

        fbs.getFire().collection("animals").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (DocumentSnapshot dataSnapshot : queryDocumentSnapshots.getDocuments()) {
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
