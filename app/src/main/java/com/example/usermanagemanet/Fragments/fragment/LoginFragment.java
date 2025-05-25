package com.example.usermanagemanet.Fragments.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.usermanagemanet.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    private EditText etUsername, etPassword;
    private TextView tvSignUPlink;
    private TextView etforgotpassword;
    private Button btnLoginLogin;
    private FireBaseServices fbs;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
        return inflater.inflate(R.layout.fragment_login, container, false);
    }


    public void onStart() {
        super.onStart();
        if (getView() == null) {
            Log.e("LoginFragment", "Error: View is null!");
            return;
        }
        //connecting components
        fbs = FireBaseServices.getInstance();
        etUsername = getView().findViewById(R.id.etUsernameLogin);
        etforgotpassword = getView().findViewById(R.id.etforgotpasswordLogin);
        etPassword = getView().findViewById(R.id.etpasswordLogin);
        btnLoginLogin = getView().findViewById(R.id.btnLoginLogin);
        etforgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoForgotPasswordFragment();
            }
        });

        tvSignUPlink = getView().findViewById(R.id.tvSignupLinkLogin);
        tvSignUPlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoSignupFragment();

            }
        });

        btnLoginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //data
                String Username = etUsername.getText().toString();
                String Password = etPassword.getText().toString();
                if (Username.trim().isEmpty() && Password.trim().isEmpty()) {
                    Toast.makeText(getActivity(), "some fields are empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                //login
                fbs.getAuth().signInWithEmailAndPassword(Username, Password).addOnSuccessListener(
                        new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(getActivity(), "you are succefully logged in !", Toast.LENGTH_SHORT).show();
                                gotoofficialFragment();
                            }

                        }
                ).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(), "Failed to log in ", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }

    private void gotoSignupFragment() {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayoutFrame, new SignupFragment());
        ft.commit();

    }
    private void gotoofficialFragment() {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayoutFrame, new OfficialFragment());
        ft.commit();

    }

    private void gotoForgotPasswordFragment() {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayoutFrame, new ForgotPasswordFragment());
        ft.commit();

    }



}


