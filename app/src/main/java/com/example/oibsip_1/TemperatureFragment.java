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

import com.example.oibsip_1.R;

public class TemperatureFragment extends Fragment {


    private TextView outputText, outputUnitText,inputUnitText;
    private EditText input;
    private View view;

    private Button convert;

    public TemperatureFragment() {
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
        view = inflater.inflate(R.layout.fragment_temperature, container, false);

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

        if(unit_input.equals("Celsius") && unit_output.equals("Kelvin")){
            outputText.setText(Double.toString(number_to_convert+273));
        }
        else if(unit_input.equals("Celsius") && unit_output.equals("Fahrenheit")){
            outputText.setText(Double.toString(number_to_convert*1.8 + 32));
        }
        else if(unit_input.equals("Kelvin") && unit_output.equals("Celsius")){
            outputText.setText(Double.toString(number_to_convert-273));
        }
        else if(unit_input.equals("Kelvin") && unit_output.equals("Fahrenheit")){
            outputText.setText(Double.toString((number_to_convert-273.15)*(9/5)+32));
        }
        else{
            Toast.makeText(getContext(),"Unit is not defined",Toast.LENGTH_LONG).show();
        }


    }
    public void init(){
        outputText = view.findViewById(R.id.tempOutput);
        outputUnitText = view.findViewById(R.id.tempOutputUnit);
        inputUnitText = view.findViewById(R.id.tempInputUnit);
        input = view.findViewById(R.id.tempInput);
        convert = view.findViewById(R.id.convertTemp);
    }
}