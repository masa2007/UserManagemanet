package com.example.usermanagemanet.Fragments.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import com.example.usermanagemanet.R;

import com.example.usermanagemanet.Fragments.Data.AllAnimalFragment;
import com.example.usermanagemanet.Fragments.Classes.CartFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OfficialFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OfficialFragment extends Fragment {

    private ImageView ivBuy;
    private ImageView ivAdopt;
    private Button btnOpenCart;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OfficialFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OfficialFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OfficialFragment newInstance(String param1, String param2) {
        OfficialFragment fragment = new OfficialFragment();
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

    public void onStart() {
        super.onStart();
        connectComponents();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_official, container, false);

        Button btnOpenCart = view.findViewById(R.id.btnOpenCart);

        btnOpenCart.setOnClickListener(v -> {
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.FrameLayoutFrame, new CartFragment())
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }

    private void connectComponents() {



        ivBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAllAnimalFragment("buy");
            }
        });
        ivAdopt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAllAnimalFragment("adopt");
            }
        });

    }

    private void openAllAnimalFragment(String type) {
        AllAnimalFragment fragment = new AllAnimalFragment();
        Bundle bundle = new Bundle();
        bundle.putString("buy-adopt", type);
        fragment.setArguments(bundle);

        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayoutFrame, fragment);
        ft.commit();
    }



}