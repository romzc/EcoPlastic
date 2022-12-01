package com.example.ecoplastic.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ecoplastic.FragmentCallbacks;
import com.example.ecoplastic.MainCallbacks;
import com.example.ecoplastic.R;

public class FragmentBienvenida extends Fragment implements FragmentCallbacks {

    private MainCallbacks mainCallbacks;

    public FragmentBienvenida() {
    }

    public static FragmentBienvenida newInstance() {
        FragmentBienvenida fragment = new FragmentBienvenida();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bienvenida, container, false);
        Button btn_continuar = (Button) view.findViewById(R.id.btn_Continuar);

        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCallbacks.onMsgFromFragtoMain("BIENVENIDO","salida");
            }
        });

        return view;
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

    @Override
    public void onMsgFromMainToFragment(String strValue) {
    }
}