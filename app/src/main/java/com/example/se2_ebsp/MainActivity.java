package com.example.se2_ebsp;

import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Button TCP client
        Button BtnServer = findViewById(R. id. BtnServer);
        BtnServer.setOnClickListener(v -> {
            EditText InputText = findViewById(R.id.Input);
            TextView ServerAnswer = findViewById(R.id.AntwortServer);


            String initialString = "11704726";
            InputStream matrikelnummer = new ByteArrayInputStream(initialString.getBytes());

            TcpClient p = new TcpClient(143);
            String answer = p.run(matrikelnummer);

            ServerAnswer.setText(answer);
            
        });





        //Button Prime Numbers
        Button BtnprimeNumbers = findViewById(R. id. BtnPrimeNumbers);
        BtnprimeNumbers.setOnClickListener(v -> {
            EditText InputText = findViewById(R.id.Input);
            TextView PrimeNumbersAnswers = findViewById(R.id.AntwortPrimeNumbers);

            // Get the Input from the EditText and change it to String
            String matrikelnummer = InputText.getText().toString();

            //Calculating the prime numbers in the Matrikelnummer
            String primeNumbersString = PrimeNumbers.matPrimeNumbers(matrikelnummer);

            //Display the Prime numbers in the textView
            PrimeNumbersAnswers.setText("PRIME NUMBERS: " + primeNumbersString);

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}