package com.aloc.calcone;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private TextView result;

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        num1 = findViewById(R.id.txtNum1);
        num2 = findViewById(R.id.txtNum2);
        result = findViewById(R.id.txtRisultato);

        Log.d(TAG, "Application Started");
    }

    public void addition(View view) {
        double n1 = 0;
        double n2 = 0;

        if(!num1.getText().toString().isEmpty()) n1 = Double.parseDouble(num1.getText().toString());
        if(!num2.getText().toString().isEmpty()) n2 = Double.parseDouble(num2.getText().toString());

        updateResult(String.valueOf(n1+n2));
    }

    public void subtraction(View view) {
        double n1 = 0;
        double n2 = 0;

        if(!num1.getText().toString().isEmpty()) n1 = Double.parseDouble(num1.getText().toString());
        if(!num2.getText().toString().isEmpty()) n2 = Double.parseDouble(num2.getText().toString());

        updateResult(String.valueOf(n1-n2));
    }

    public void division(View view) {
        double n1 = 0;
        double n2 = 0;

        if(!num1.getText().toString().isEmpty()) n1 = Double.parseDouble(num1.getText().toString());
        if(!num2.getText().toString().isEmpty()) n2 = Double.parseDouble(num2.getText().toString());
        if(n2 != 0) updateResult(String.valueOf(n1/n2)); else updateResult("Impossibile");
    }

    public void multiplication(View view) {
        double n1 = 0;
        double n2 = 0;

        if(!num1.getText().toString().isEmpty()) n1 = Double.parseDouble(num1.getText().toString());
        if(!num2.getText().toString().isEmpty()) n2 = Double.parseDouble(num2.getText().toString());
        updateResult(String.valueOf(n1*n2));
    }

    private void updateResult(String res){
        if(result != null) result.setText(res);
    }
}