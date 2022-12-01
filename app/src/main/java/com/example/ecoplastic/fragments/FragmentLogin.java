package com.example.ecoplastic.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ecoplastic.FragmentCallbacks;
import com.example.ecoplastic.MainCallbacks;
import com.example.ecoplastic.R;

public class FragmentLogin extends Fragment {
    private Button bRegister;
    private Button bIngresar;

    private MainCallbacks mainCallbacks;

    public FragmentLogin() {

    }
    // TODO: Rename and change types and number of parameters
    public static FragmentLogin newInstance(String param1, String param2) {
        FragmentLogin fragment = new FragmentLogin();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        bRegister = (Button)root.findViewById(R.id.login_b_register);
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("probando","register");
                mainCallbacks.onMsgFromFragtoMain("register","");
            }
        });

        bIngresar = (Button) root.findViewById(R.id.login_b_ingresar);
        bIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("probando","ingresar");
                mainCallbacks.onMsgFromFragtoMain("ingresar","");
            }
        });
        return root;
    }


    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainCallbacks){
            mainCallbacks = (MainCallbacks) context;
        }
        else{
            throw new RuntimeException(context.toString()+"must implement FragmentCallbacks");
        }
    }
}