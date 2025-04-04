package com.example.usermanagemanet;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

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
        gotoAddAnimalFraqment();

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





    private void gotoLoginFraqment() {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayoutFrame,new LoginFragment());
        ft.commit();
    }

}
