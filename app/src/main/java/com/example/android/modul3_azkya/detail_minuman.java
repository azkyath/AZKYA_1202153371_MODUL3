package com.example.android.modul3_azkya;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class detail_minuman extends AppCompatActivity {
    private TextView nama_minuman, capt;
    private ImageView imgmenu;
    TextView jmlh;
    ImageView bat;
    Button btplus, btmin;
    int i = 1 ;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_minuman);

        //inisiasi id yang sesuai dengan layout xml nya
        nama_minuman = (TextView) findViewById(R.id.textView_nama);
        capt = (TextView) findViewById(R.id.desc);
        jmlh = (TextView) findViewById(R.id.jumlah);
        imgmenu = (ImageView) findViewById(R.id.imageViewdetail);
        bat = (ImageView) findViewById(R.id.battery);
        btplus = (Button) findViewById(R.id.btnplus);
        btmin = (Button) findViewById(R.id.btnminus);

        //method saat button di click menggunakan level list drawable
        btplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bat.getDrawable().getLevel()+1<=5){
                    i= i + 1 ;
                    jmlh.setText(i + "L");
                    bat.setImageLevel(bat.getDrawable().getLevel()+1);
                }else { bat.setImageLevel(5);
                    Toast.makeText(detail_minuman.this, "Full!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bat.getDrawable().getLevel()-1>=0){
                    i = i - 1 ;
                    jmlh.setText(i + "L");
                    bat.setImageLevel(bat.getDrawable().getLevel()-1);
                }else { bat.setImageLevel(0);
                    Toast.makeText(detail_minuman.this, "Terlalu sedikit!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Intent data = getIntent();
        String menu = data.getStringExtra("nama");
        String deskripsi = data.getStringExtra("pminuman");
        Integer gmbr = data.getIntExtra("gambar", 0);

        nama_minuman.setText(menu);
        capt.setText(deskripsi);
        imgmenu.setImageResource(gmbr);

    }
}
