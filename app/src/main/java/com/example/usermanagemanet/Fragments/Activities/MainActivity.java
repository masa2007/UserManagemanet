package com.example.usermanagemanet.Fragments.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.usermanagemanet.Fragments.Data.AddAnimalFragment;
import com.example.usermanagemanet.Fragments.Data.AllAnimalFragment;

import com.example.usermanagemanet.Fragments.fragment.OfficialFragment;
import com.example.usermanagemanet.R;

import com.example.usermanagemanet.Fragments.fragment.LoginFragment;

public class MainActivity extends AppCompatActivity {

    private Object EdgeToEdge;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter AnimalAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] myDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });;
    }


    @Override
    protected void onStart() {
        super.onStart();
        gotoOfficialFraqment();
    }

    private void gotoAllAnimalFraqment() {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayoutFrame,new AllAnimalFragment());
        ft.commit();
    }


    private void gotoAddAnimalFraqment() {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayoutFrame,new AddAnimalFragment());
        ft.commit();
    }

    private void gotoOfficialFraqment() {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayoutFrame,new OfficialFragment());
        ft.commit();
    }




    private void gotoLoginFraqment() {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayoutFrame,new LoginFragment());
        ft.commit();
    }

}
