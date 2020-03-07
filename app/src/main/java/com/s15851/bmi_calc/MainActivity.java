package com.s15851.bmi_calc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{
    private static DecimalFormat df = new DecimalFormat("#.##");

    private EditText height;
    private EditText weight;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void calculateBMI(View v)
    {
        String h = height.getText().toString();
        String w = weight.getText().toString();

        if (h != null && !"".equals(h) && w != null && !"".equals(w))
        {
            Double heightValue = Double.parseDouble(h);
            Double weightValue = Double.parseDouble(w);
            Double bmi = weightValue / (heightValue * heightValue) * 10000;

            displayBMI(bmi);
        }
    }

    private void displayBMI(Double bmi)
    {
        String bmiLabel = "";

        if (bmi<=18.5)
        {
            bmiLabel = getString(R.string.under);
        }
        else if (bmi>18.5 && bmi<25)
        {
            bmiLabel = getString(R.string.normal);
        }
        else if (bmi>=25 && bmi<30)
        {
            bmiLabel = getString(R.string.over);
        }
        else {
            bmiLabel = getString(R.string.obese);
        }
        result.setText("BMI: " + df.format(bmi) + "\n\n" + bmiLabel);
    }
}
