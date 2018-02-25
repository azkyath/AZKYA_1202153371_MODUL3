package com.example.android.modul3_azkya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class daftar_minuman extends AppCompatActivity {

    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> nama;
    private ArrayList<String> caption;
    private ArrayList<Integer> gambar;

    //Daftar Menu makanan yang akan di tampilkan
    private String[] jenis_minuman = {
            "Aqua",
            "Pristine",
            "LeMineral",
            "Cleo",
            "Club",
            "Amidis",
            "Ades",
            "Equil",
            "Evian",
            "Nestle",
            "Vit"};

    //daftar caption yang akan di tampilka
    private String[] deskripsi = {
            "ini adalah minuman aqua",
            "ini adalah minuman pristine",
            "ini adalah minuman LeMineral",
            "ini adalah minuman Cleo  ",
            "ini adalah minuman Club",
            "ini adalah minuman Amidis",
            "ini adalah minuman Ades",
            "ini adalah minuman Equil",
            "ini adalah minuman Evian",
            "ini adalah minuman Nestle",
            "ini adalah minuman Vit"};

    //gambar-gambar minuman yang akan muncul
    private int[] Gambar = {R.drawable.aqua,
            R.drawable.pristine,
            R.drawable.leminerale,
            R.drawable.cleo,
            R.drawable.club,
            R.drawable.amidis,
            R.drawable.ades,
            R.drawable.equil,
            R.drawable.evian,
            R.drawable.nestle,
            R.drawable.vit,};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_minuman);

        //mendeklarasikan array data menu, caption, dan gambar
        nama = new ArrayList<>();
        caption = new ArrayList<>();
        gambar = new ArrayList<>();
        DaftarItem();

        //inisiasi recyclerview
        rvView = (RecyclerView) findViewById(R.id.Rview);
        rvView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(nama, caption, gambar);
        rvView.setAdapter(adapter);

    }

    //Mengambil data dari variable gambar, caption, dan nama minuman, lalu memasangnya pada list yang terhubung dengan Class Adapter
    private void DaftarItem() {
        for (int w = 0; w < jenis_minuman.length; w++) {
            nama.add(jenis_minuman[w]);
            caption.add(deskripsi[w]);
            gambar.add(Gambar[w]);
        }
    }
}
