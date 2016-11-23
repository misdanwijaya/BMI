package com.example.smkn4.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //variabel global
    double berat2;
    double tinggi2;
    double tinggic;
    double hasil2;
    String jk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ========================= Spinner untuk Jenis Kelamin ==============================

        // Spinner element
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner2.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories2 = new ArrayList<String>();
        categories2.add("Laki-laki");
        categories2.add("Perempuan");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);

        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner2.setAdapter(dataAdapter2);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void klikButton(View v) {

        //mengambil data
        EditText nberat = (EditText) findViewById(R.id.berat);
        EditText ntinggi = (EditText) findViewById(R.id.tinggi);
        Spinner jenis_kelamin = (Spinner)findViewById(R.id.spinner);



        //memilih jenis kelamin
        jk = jenis_kelamin.getSelectedItem().toString();

        //menghitung
        //hitung
        berat2 = Double.valueOf(nberat.getText().toString());
        tinggi2 = Double.valueOf(ntinggi.getText().toString());
        tinggic = tinggi2 / 100;
        hasil2 = berat2 / (tinggic * tinggic) ;

        //tampilkan
        display(hasil2);

        
    }

    public void display(double nilai) {
        TextView hasil = (TextView) findViewById(R.id.hasil);
        TextView kategori2 = (TextView) findViewById(R.id.kategori);
        TextView judul2 = (TextView) findViewById(R.id.judul);
        TextView solusi2 = (TextView) findViewById(R.id.solusi);

        judul2.setText("Hasil Anda");
        hasil.setText("BMI Anda : " + nilai);


        String x="Laki-laki";
        String y="Perempuan";

        if (jk.equals(x)){
            if (nilai < 17 ){
                kategori2.setText("Anda Termasuk Kurus");
                solusi2.setText("Solusi : Banyaklah mengkonsumsi makanan dengan 4 sehat 5 sempurna");
            }
            else if ( nilai  >= 17 && nilai  < 23){
                kategori2.setText("Anda Termasuk Normal");
                solusi2.setText("Solusi : Atur pola makan anda");
            }
            else if ( nilai  >= 23 && nilai  < 27){
                kategori2.setText("Anda Termasuk Kegemukan");
                solusi2.setText("Solusi : Budayakan berolahraga");
            }
            else if ( nilai  >= 27){
                kategori2.setText("Anda Termasuk Obesitas");
                solusi2.setText("Solusi : Budayakan berolahraga dan atur pola makan");
            }

        }else if(jk.equals(y)){

            if (nilai  < 18 ){
                kategori2.setText("Anda Termasuk Kurus");
                solusi2.setText("Solusi : Banyaklah mengkonsumsi makanan dengan 4 sehat 5 sempurna");
            }
            else if ( nilai  >= 18 && nilai  < 25){
                kategori2.setText("Anda Termasuk Normal");
                solusi2.setText("Solusi : Atur pola makan anda");
            }
            else if ( nilai  >= 25 && nilai  < 27){
                kategori2.setText("Anda Termasuk Kegemukan");
                solusi2.setText("Solusi : Budayakan berolahraga");
            }
            else if ( nilai  >= 27){
                kategori2.setText("Anda Termasuk Obesitas");
                solusi2.setText("Solusi : Budayakan berolahraga dan atur pola makan");
            }
        }
    }
}
