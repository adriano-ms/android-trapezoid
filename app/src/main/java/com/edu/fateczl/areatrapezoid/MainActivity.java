package com.edu.fateczl.areatrapezoid;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * @author Adriano M Sanchez
 */
public class MainActivity extends AppCompatActivity {

    private TextView txtName;
    private TextView txtRa;

    private EditText etBaseB;
    private EditText etBaseA;
    private EditText etHeight;

    private TextView txtResult;

    private Button btnCalculate;

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

        txtName = findViewById(R.id.txtName);
        txtRa = findViewById(R.id.txtRa);

        etBaseB = findViewById(R.id.etBaseB);
        etBaseA = findViewById(R.id.etBaseA);
        etHeight = findViewById(R.id.etHeight);

        txtResult = findViewById(R.id.txtResult);

        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(e -> calculate());
    }

    private void calculate(){
        double baseA = Double.parseDouble(etBaseA.getText().toString());
        double baseB = Double.parseDouble(etBaseB.getText().toString());
        double height = Double.parseDouble(etHeight.getText().toString());
        double result = ((baseA + baseB) * height) / 2.0;
        txtResult.setText(getString(R.string.txt_result) + "" + result);
    }
}