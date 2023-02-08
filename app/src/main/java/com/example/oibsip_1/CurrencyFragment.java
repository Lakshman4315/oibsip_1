package com.example.oibsip_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CurrencyFragment extends Fragment {

    private TextView outputText, outputUnitText,inputUnitText;
    private EditText input;
    private View view;

    private Button convert;


    public CurrencyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=  inflater.inflate(R.layout.fragment_currency, container, false);

        init();

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculation();
            }
        });

        return view;    }

    private void calculation() {
        double number_to_convert = Double.parseDouble(input.getText().toString());
        String unit_input = inputUnitText.getText().toString();
        String unit_output = outputUnitText.getText().toString();

        if(unit_input.equals("rupee") && unit_output.equals("dollar")){
            outputText.setText(Double.toString(number_to_convert/81.74));
        }
        else if(unit_input.equals("dollar") && unit_output.equals("rupee")){
            outputText.setText(Double.toString(number_to_convert*81.74));
        }
        else{
            Toast.makeText(getContext(),"Unit is not defined",Toast.LENGTH_LONG).show();
        }


    }
    public void init(){
        outputText = view.findViewById(R.id.currOutput);
        outputUnitText = view.findViewById(R.id.currOutputUnit);
        inputUnitText = view.findViewById(R.id.currInputUnit);
        input = view.findViewById(R.id.currInput);
        convert = view.findViewById(R.id.convertCurr);
    }

}