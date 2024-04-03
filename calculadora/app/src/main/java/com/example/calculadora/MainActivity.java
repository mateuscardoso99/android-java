package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    EditText ed2;
    EditText edR;
    Button btSoma;
    Button btSub;
    Button btMulti;
    Button btDiv;
    Button btnfechar;
    Button btnlimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText)findViewById(R.id.editText1);
        ed2 = (EditText)findViewById(R.id.editText2);
        edR = (EditText)findViewById(R.id.editTextResultado);
        btSoma = (Button)findViewById(R.id.btnSomar);
        btSub = (Button)findViewById(R.id.btnSubtrair);
        btMulti = (Button)findViewById(R.id.btnMultiplicar);
        btDiv = (Button)findViewById(R.id.btnDividir);
        btnfechar = (Button)findViewById(R.id.btnFechar);
        btnlimpar = (Button)findViewById(R.id.btnlimpar);

        ed1.setText("0");
        ed2.setText("0");
        edR.setText("0");

        btnfechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        btnlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpar();
            }
        });

            btSoma.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Double v1, v2, result;
                    v1 = Double.parseDouble(ed1.getText().toString());
                    v2 = Double.parseDouble(ed2.getText().toString());
                    result = v1 + v2;

                    edR.setText(result.toString());
                }
            });

            btSub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Double v1, v2, result;
                    v1 = Double.parseDouble(ed1.getText().toString());
                    v2 = Double.parseDouble(ed2.getText().toString());
                    result = v1 - v2;

                    edR.setText(result.toString());
                }
            });

            btMulti.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Double v1, v2, result;
                    v1 = Double.parseDouble(ed1.getText().toString());
                    v2 = Double.parseDouble(ed2.getText().toString());
                    result = v1 * v2;

                    edR.setText(result.toString());
                }
            });

            btDiv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Double v1, v2, result;
                    v1 = Double.parseDouble(ed1.getText().toString());
                    v2 = Double.parseDouble(ed2.getText().toString());
                    result = v1 / v2;

                    edR.setText(result.toString());
                }
            });

        }

        public void limpar() {
            ed1.setText("0");
            ed2.setText("0");
            edR.setText("0");
            ed1.requestFocus();
        }

    }
