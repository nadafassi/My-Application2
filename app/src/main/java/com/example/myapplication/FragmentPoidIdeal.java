package com.example.myapplication;



import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.NoCopySpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;


public class FragmentPoidIdeal extends Fragment {

    private RadioButton hommeBtn;
    private RadioButton femmeBtn;

    private EditText poidBtn;
    private EditText tailleBtn;
    private ImageView imc;
    private Button calculBtn;
    private TextView resultat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View view = inflater.inflate(R.layout.fragment_poid_ideal,container,false);

     poidBtn=(EditText) view.findViewById(R.id.textPoid);
     tailleBtn=(EditText)view.findViewById(R.id.textTaille);
     resultat=(TextView)view.findViewById(R.id.resulta);
      imc=(ImageView)view.findViewById(R.id.imgeIMC);
     calculBtn=(Button)view.findViewById(R.id.CalculBtn);
     calculBtn.setOnClickListener(calculBtnListener);
     return view;

    }
    private  View.OnClickListener calculBtnListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            double monPoids=Double.valueOf(poidBtn.getText().toString());
            double maTaille=Double.valueOf(tailleBtn.getText().toString());
            resultat.setText(String.valueOf(monPoids/(maTaille*maTaille/10000)));
            resultat.setVisibility(View.VISIBLE);
          imc.setVisibility(View.VISIBLE);

        }
    };
}