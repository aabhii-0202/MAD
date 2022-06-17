package com.example.a1rn19is005;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a1rn19is005.databinding.ActivitySimpleCalculatorBinding;

import java.util.regex.Pattern;

public class SimpleCalculator extends AppCompatActivity {
    ActivitySimpleCalculatorBinding binding;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySimpleCalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        text="";
        binding.buttonOne.setOnClickListener(view -> settext('1'));
        binding.buttonTwo.setOnClickListener(view -> settext('2'));
        binding.buttonThree.setOnClickListener(view -> settext('3'));
        binding.buttonFour.setOnClickListener(view -> settext('4'));
        binding.buttonFive.setOnClickListener(view -> settext('5'));
        binding.buttonSix.setOnClickListener(view -> settext('6'));
        binding.buttonSeven.setOnClickListener(view -> settext('7'));
        binding.buttonEight.setOnClickListener(view -> settext('8'));
        binding.buttonNine.setOnClickListener(view -> settext('9'));
        binding.buttonDiv.setOnClickListener(view -> settext('/'));
        binding.buttonMul.setOnClickListener(view -> settext('*'));
        binding.buttonAdd.setOnClickListener(view -> settext('+'));
        binding.buttonSub.setOnClickListener(view -> settext('-'));
        binding.buttonDot.setOnClickListener(view -> settext('.'));
        binding.buttonZero.setOnClickListener(view -> settext('0'));
        binding.buttonClear.setOnClickListener(view -> settext('$'));
        binding.buttonEqual.setOnClickListener(view -> calculate());

    }

    private void settext(char i) {
        text+=i;
        if(i=='$') text = "";
        binding.txtResult.setText(text);
    }

    private void calculate(){
        try {
            String data = binding.txtResult.getText().toString();
            if (data.contains("/")) {
                String[] operands = data.split("/");
                if (operands.length == 2) {
                    double operand1 = Double.parseDouble(operands[0]);
                    double operand2 = Double.parseDouble(operands[1]);
                    double result = operand1 / operand2;
                    text=String.valueOf(result);
                    binding.txtResult.setText(String.valueOf(result));
                } else {
                    Toast.makeText(getBaseContext(), "Invalid Input", Toast.LENGTH_LONG).show();
                }
            } else if (data.contains("*")) {
                String[] operands = data.split(Pattern.quote("*"));
                if (operands.length == 2) {
                    double operand1 = Double.parseDouble(operands[0]);
                    double operand2 = Double.parseDouble(operands[1]);
                    double result = operand1 * operand2;
                    text=String.valueOf(result);
                    binding.txtResult.setText(String.valueOf(result));
                } else {
                    Toast.makeText(getBaseContext(), "Invalid Input", Toast.LENGTH_LONG).show();
                }
            } else if (data.contains("+")) {
                String[] operands = data.split(Pattern.quote("+"));
                if (operands.length == 2) {
                    double operand1 = Double.parseDouble(operands[0]);
                    double operand2 = Double.parseDouble(operands[1]);
                    double result = operand1 + operand2;
                    text=String.valueOf(result);
                    binding.txtResult.setText(String.valueOf(result));
                } else {
                    Toast.makeText(getBaseContext(), "Invalid Input", Toast.LENGTH_LONG).show();
                }
            } else if (data.contains("-")) {
                String[] operands = data.split("-");
            if (operands.length == 2) {
                double operand1 = Double.parseDouble(operands[0]);
                double operand2 = Double.parseDouble(operands[1]);
                double result = operand1 - operand2;
                text=String.valueOf(result);
                binding.txtResult.setText(String.valueOf(result));
            } else {
                Toast.makeText(getBaseContext(), "Invalid Input", Toast.LENGTH_LONG).show();
            }
            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Invalid Input", Toast.LENGTH_LONG).show();
        }
    }
}



