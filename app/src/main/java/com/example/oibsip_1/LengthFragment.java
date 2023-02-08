package com.example.oibsip_1;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LengthFragment extends Fragment {

    private TextView outputText;
    private EditText input, outputUnitText,inputUnitText;
    private View view;

    private Button convert;

    public LengthFragment() {
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
        view =  inflater.inflate(R.layout.fragment_length, container, false);

        //Initialisation
        init();

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculation();
            }
        });

        return view;    }

    @SuppressLint("SetTextI18n")
    private void calculation() {
        double number_to_convert = Double.parseDouble(input.getText().toString());
        String unit_input = inputUnitText.getText().toString();
        String unit_output = outputUnitText.getText().toString();

        if(unit_input.equals("mm") && unit_output.equals("cm")){
            outputText.setText(Double.toString(number_to_convert/10));
        }
        else if(unit_input.equals("mm") && unit_output.equals("m")){
            outputText.setText(Double.toString(number_to_convert/1000));
        }
        else if(unit_input.equals("mm") && unit_output.equals("km")){
            outputText.setText(Double.toString(number_to_convert/1000000));
        }
        else if(unit_input.equals("mm") && unit_output.equals("dm")){
            outputText.setText(Double.toString(number_to_convert/100));
        }
        else if(unit_input.equals("cm") && unit_output.equals("mm")){
            outputText.setText(Double.toString(number_to_convert*10));
        }
        else if(unit_input.equals("cm") && unit_output.equals("m")){
            outputText.setText(Double.toString(number_to_convert/100));
        }
        else if(unit_input.equals("cm") && unit_output.equals("km")){
            outputText.setText(Double.toString(number_to_convert/100000));
        }
        else if(unit_input.equals("cm") && unit_output.equals("dm")){
            outputText.setText(Double.toString(number_to_convert/10));
        }
        else{
            Toast.makeText(getContext(),"Unit is not defined",Toast.LENGTH_LONG).show();
        }


    }

    public void init(){
        outputText = view.findViewById(R.id.output);
        outputUnitText = view.findViewById(R.id.outputUnit);
        inputUnitText = view.findViewById(R.id.inputUnit);
        input = view.findViewById(R.id.input);
        convert = view.findViewById(R.id.convert);
    }

}