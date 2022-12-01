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

import com.example.ecoplastic.MainCallbacks;
import com.example.ecoplastic.R;

public class FragmentRegister extends Fragment {

    private Button bLoggin;
    private MainCallbacks mainCallbacks;

    public FragmentRegister() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentRegister newInstance() {
        FragmentRegister fragment = new FragmentRegister();
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
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_register, container, false);
        bLoggin = root.findViewById(R.id.register_b_login);
        bLoggin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("probando","login");
                mainCallbacks.onMsgFromFragtoMain("login","Vrrrr");
            }
        });

        return root;

    }

    @Override
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