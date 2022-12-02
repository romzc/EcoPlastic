package com.example.ecoplastic.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ecoplastic.callbacks.FragmentCallbacks;
import com.example.ecoplastic.callbacks.MainCallbacks;
import com.example.ecoplastic.R;
import com.example.ecoplastic.widgets.EditTextButtons;

public class Fragment_CalculoHuella extends Fragment implements FragmentCallbacks {
    private MainCallbacks mainCallbacks;

    public Fragment_CalculoHuella() {}

    public static Fragment_CalculoHuella newInstance() {
        Fragment_CalculoHuella fragment = new Fragment_CalculoHuella();
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
        View view = inflater.inflate(R.layout.fragment_calculo_huella, container, false);
        EditTextButtons editTextNumber1 = view.findViewById(R.id.editTextNumber1);
        EditTextButtons editTextNumber2 = view.findViewById(R.id.editTextNumber2);
        EditTextButtons editTextNumber3 = view.findViewById(R.id.editTextNumber3);
        EditTextButtons editTextNumber4 = view.findViewById(R.id.editTextNumber4);
        EditTextButtons[] edits = {editTextNumber1,editTextNumber2,editTextNumber3,editTextNumber4};

        Button btn_calcular = view.findViewById(R.id.btn_calcular);
        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int val = calcular(edits);
                mainCallbacks.onMsgFromFragtoMain("CALCULO_HUELLA",String.valueOf(val));
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
    public int calcular(EditTextButtons[] edits){
        int suma = 0;
        Integer cad;
        for(int val = 0; val < 4; val++){
            cad = edits[val].getValue();
            if (cad > 0)
                suma += cad;
        }
        if(suma<10)
            return 1;
        else if (suma<15)
            return 2;
        else if(suma<20)
            return 3;
        else return 4;
    }


    /**
     * Metodos para manejar los enventos click.
     * */



    @Override
    public void onMsgFromMainToFragment(String strValue) {

    }
}