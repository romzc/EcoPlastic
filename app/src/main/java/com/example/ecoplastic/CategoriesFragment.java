package com.example.ecoplastic;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoriesFragment extends Fragment {

    private TextView cupText;
    private TextView bottleText;
    private TextView bagText;
    private TextView packText;

    public CategoriesFragment() {}

    // TODO: Rename and change types and number of parameters
    public static CategoriesFragment newInstance(String param1, String param2) {
        return new CategoriesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        ConstraintLayout layout = (ConstraintLayout) inflater.inflate(R.layout.fragment_categories, container, false);

        // ************ //
        Button bottleButton = (Button) layout.findViewById(R.id.bottle_home_button);
        Button cupButton = (Button) layout.findViewById(R.id.cups_home_button);
        Button packButton = (Button) layout.findViewById(R.id.pack_home_button);
        Button bagButton = (Button) layout.findViewById(R.id.bag_home_button);

        bottleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogBottle();
            }
        });

        cupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogCup();
            }
        });

        packButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogPacket();
            }
        });

        bagButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogBags();
            }
        });

        return layout;
    }

    private void showDialogBags() {

    }

    private void showDialogPacket () {

    }

    private void showDialogCup() {
        Dialog dialog = new Dialog( this.getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_sheet_cup);

        RadioGroup radioGroup = dialog.findViewById(R.id.cup_radiogroup);
        Button plusButton = dialog.findViewById(R.id.plus_cup_button);
        Button minusButton = dialog.findViewById(R.id.minus_cup_button);
        Button saveButton = dialog.findViewById(R.id.save_cup_button);
        Button discardButton = dialog.findViewById(R.id.discard_cup_button);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView cupText1 = dialog.findViewById(R.id.amount_cup);
                Integer integer = Integer.parseInt(cupText1.getText().toString());
                integer += 1;
                cupText1.setText(integer.toString());
            }
        });

        minusButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cupText = dialog.findViewById(R.id.amount_cup);
                Integer integer = Integer.parseInt(cupText.getText().toString());
                if( integer > 0 ) {
                    integer -= 1;
                    cupText.setText(integer.toString());
                }
            }
        });

        saveButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Log.d("TEST", "save button");
            }
        });

        discardButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Log.d("TEST", "discard button");
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private void showDialogBottle() {
        final Dialog dialog = new Dialog( this.getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_sheet_bottles);

        RadioGroup radioGroup = dialog.findViewById(R.id.bottles_radiogroup);
        Button plusButton = dialog.findViewById(R.id.plus_bottle_button);
        Button minusButton = dialog.findViewById(R.id.minus_bottle_button);
        Button saveButton = dialog.findViewById(R.id.save_bottles_button);
        Button discardButton = dialog.findViewById(R.id.discard_bottles_button);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                TextView bottleAmout = dialog.findViewById(R.id.amount_bottle);
                int integer = Integer.parseInt(bottleAmout.getText().toString());
                integer += 1;
                bottleAmout.setText(Integer.toString(integer));
            }
        });

        minusButton.setOnClickListener( new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                TextView bottleAmount = dialog.findViewById(R.id.amount_bottle);
                int integer = Integer.parseInt(bottleAmount.getText().toString());
                if( integer > 0 ) {
                    integer -= 1;
                    bottleAmount.setText(Integer.toString(integer));
                }
            }
        });

        saveButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Log.d("TEST", "save button");
            }
        });

        discardButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Log.d("TEST", "discard button");
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}