package com.example.ecoplastic.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.ecoplastic.R;
import com.example.ecoplastic.activities.HomeActivity;
import com.example.ecoplastic.callbacks.MainCallbacks;
import com.example.ecoplastic.fragments.FragmentBienvenida;
import com.example.ecoplastic.fragments.FragmentLogin;
import com.example.ecoplastic.fragments.FragmentRegister;
import com.example.ecoplastic.fragments.FragmentResultado;
import com.example.ecoplastic.fragments.Fragment_CalculoHuella;

public class MainActivity extends AppCompatActivity implements MainCallbacks {
    private Fragment_CalculoHuella fragment_c;
    private FragmentResultado fragment_r;
    private FragmentBienvenida fragment_b = new FragmentBienvenida();
    FragmentLogin fragmentLogin = new FragmentLogin();
    FragmentRegister fragmentRegister = new FragmentRegister();

    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(fragmentLogin);
    }

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_inicio,fragment);
        transaction.commit();
    }

    @Override
    public void onMsgFromFragtoMain(String sender, String strValue) {

        if (sender.equals("register")){
            try {
                loadFragment(fragmentRegister);
            } catch (Exception e){
                Log.e("ERROR", "onStrFromFragToMain " + e.getMessage());
            }
        }

        if (sender.equals("login")){
            try {
                loadFragment(fragmentLogin);
            } catch (Exception e){
                Log.e("ERROR", "onStrFromFragToMain " + e.getMessage());
            }
        }
        if (sender.equals("ingresar")){
            try {
                loadFragment(fragment_b);
            }
            catch (Exception e){
                Log.e("ERROR", e.getMessage());
            }
        }

        if (sender.equals("BIENVENIDO")) {
            try {
                ft = getSupportFragmentManager().beginTransaction();
                fragment_c = Fragment_CalculoHuella.newInstance();
                ft.replace(R.id.fragment_inicio, fragment_c);
                ft.commit();

            } catch (Exception e) {
                Log.e("ERROR", "onStrFromFragToMain " + e.getMessage());
            }
        }

        if (sender.equals("CALCULO_HUELLA")) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("TOTAL",Integer.parseInt(strValue));

                ft = getSupportFragmentManager().beginTransaction();
                fragment_r = FragmentResultado.newInstance("","");
                fragment_r.setArguments(bundle);

                ft.replace(R.id.fragment_inicio, fragment_r);
                ft.commit();

            } catch (Exception e) {
                Log.e("ERROR", "onStrFromFragToMain " + e.getMessage());
            }
        }
        if (sender.equals("RESULTADO")) {
            try {
                Intent intent = new Intent(this.getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            } catch (Exception e) {
                Log.e("ERROR", "onStrFromFragToMain " + e.getMessage());
            }
        }
    }
}