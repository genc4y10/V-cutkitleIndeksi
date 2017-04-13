package com.example.gencay.vucutkitleindeksi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class vucutKitleIndeksi extends AppCompatActivity {
    private EditText editText;
    private TextView boy_tv,durum_tv,ideal_tv,kilo_tv;
    private SeekBar seekBar;
    private RadioGroup radioGroup;
    private boolean erkekmi=true;
    private double boy=0.0;
    private int kilo=50;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vucut_kitle_indeksi);

        editText=(EditText) findViewById(R.id.editText);
        boy_tv= (TextView) findViewById(R.id.boy_tv);
        durum_tv= (TextView) findViewById(R.id.durum_tv);
        ideal_tv= (TextView) findViewById(R.id.ideal_tv);
        kilo_tv= (TextView) findViewById(R.id.kilo_tv);
        radioGroup= (RadioGroup) findViewById(R.id.radioGrup);
        seekBar= (SeekBar) findViewById(R.id.seekBar);


        editText.addTextChangedListener(editTextOlayIzleyicisi);
        seekBar.setOnSeekBarChangeListener(seekBarOlayİsleyicisi);
        radioGroup.setOnCheckedChangeListener(radioGroupOlayİsleyicisi);

        guncelle();


    }

    private RadioGroup.OnCheckedChangeListener radioGroupOlayİsleyicisi=new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId==R.id.bay)
                erkekmi = true;
            else if (checkedId==R.id.bayan)
                erkekmi =false;

            guncelle();


        }
    };
    private SeekBar.OnSeekBarChangeListener seekBarOlayİsleyicisi=new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            kilo=30+progress;
            guncelle();

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }

    };

    private TextWatcher editTextOlayIzleyicisi=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                boy=Double.parseDouble(s.toString())/100.0;


            }
            catch (NumberFormatException e){
                boy=0.0;
            }
            guncelle();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }

    };



    private void guncelle(){

        kilo_tv.setText(String.valueOf(kilo)+" kg");
        boy_tv.setText(String.valueOf(boy)+" m");

        int idealKiloBay= (int) (50+2.3*((boy*100*0.4)-60));
        int idealKiloBayan= (int) (45.5+2.3*((boy*100*0.4)-60));

        double vki =kilo/(boy*boy);

        if(erkekmi){
            ideal_tv.setText(String.valueOf(idealKiloBay));

            if(vki<=17.5){
                durum_tv.setBackgroundResource(R.color.cokzayif);
                durum_tv.setText("Çok Zayıfsınız!");
            }else if(vki>17.5 && vki<=20.7){
                durum_tv.setBackgroundResource(R.color.zayif);
                durum_tv.setText("Zayıfsınız!");
            }
            else if(vki>20.7 && vki<=26.4){
            durum_tv.setBackgroundResource(R.color.ideal);
            durum_tv.setText("Kilonuz İdeal!");
            }
            else if(vki>26.4 && vki<=27.8){
            durum_tv.setBackgroundResource(R.color.birazideal);
            durum_tv.setText("Normalden Biraz Fazlasınız!");
            }
            else if(vki>27.8 && vki<=31.1){
            durum_tv.setBackgroundResource(R.color.cok);
            durum_tv.setText("Çok kilolusunuz!");
            }
            else if(vki>31.1 && vki<=34.9){
                durum_tv.setBackgroundResource(R.color.asiricok);
                durum_tv.setText("Aşırı kilolusunuz!");
            }
            else if(vki>35 && vki<=40){
                durum_tv.setBackgroundResource(R.color.risk);
                durum_tv.setText("Risk  Taşıyacak Kilodasınız!");
            }
            else{
                durum_tv.setBackgroundResource(R.color.doktortedavisi);
                durum_tv.setText("Doktor Tedavisi Gerekli!");
            }


        }else{
            ideal_tv.setText(String.valueOf(idealKiloBayan));

            if(vki<=17.5){
                durum_tv.setBackgroundResource(R.color.cokzayif);
                durum_tv.setText("Çok Zayıfsınız!");
            }else if(vki>17.5 && vki<=19.1){
                durum_tv.setBackgroundResource(R.color.zayif);
                durum_tv.setText("Zayıfsınız!");
            }
            else if(vki>19.1 && vki<=25.8){
                durum_tv.setBackgroundResource(R.color.ideal);
                durum_tv.setText("Kilonuz İdeal!");
            }
            else if(vki>25.8 && vki<=27.3){
                durum_tv.setBackgroundResource(R.color.birazideal);
                durum_tv.setText("Normalden Biraz Fazlasınız!");
            }
            else if(vki>=27.3 && vki<=32.3){
                durum_tv.setBackgroundResource(R.color.cok);
                durum_tv.setText("Çok kilolusunuz!");
            }
            else if(vki>32.3 && vki<=34.9){
                durum_tv.setBackgroundResource(R.color.asiricok);
                durum_tv.setText("Aşırı kilolusunuz!");
            }
            else if(vki>35 && vki<=40){
                durum_tv.setBackgroundResource(R.color.risk);
                durum_tv.setText("Risk  Taşıyacak Kilodasınız!");
            }
            else{
                durum_tv.setBackgroundResource(R.color.doktortedavisi);
                durum_tv.setText("Doktor Tedavisi Gerekli!");
            }

        }
    }
}
