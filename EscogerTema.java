package com.example.jjalv.nuevoreproductormultimedia;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;


public class EscogerTema extends Activity implements ListView.OnItemClickListener {

    ListView lv1;
    MediaPlayer mediaPlayer = null;
    File file = null;


    ArrayAdapter<String> adaptador;
    String[] ficheros;
    String temas;
    /**int[] canciones = {R.raw.acdc, R.raw.mecano, R.raw.melendi};
    String[] can = {"ACDC - shoot to trhill", "Mecano - Barco a venus", "Melendi - Una de Melendi"};*/
    int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escoger_tema);

        lv1 = (ListView) findViewById(R.id.list);
        lv1.setOnItemClickListener(this);



        // comprueba si hay ficheros en el directorio
        // y si los hay los lista en el Log , se puede prescindir de ello
        file = new File("/sdcard/Music/");

        ficheros = file.list();
        if (ficheros == null) {
            Log.e("PELIGRO", "No hay ficheros en el directorio especificado ");
        } else {
            for (int i = 0; i < ficheros.length; i++) {
                temas=ficheros[i];
                Log.d("LISTA DE FICHEROS ==>  ", temas);
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ficheros);
        lv1.setAdapter(adapter);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        // con i consigo el
        Uri datos = Uri.parse(Environment.getExternalStorageDirectory()
                .getPath() + "/music/"+ficheros[position]);
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("cancion",datos.toString());
        startActivity(intent);
        /**mediaPlayer = MediaPlayer.create(this, datos);
        mediaPlayer.start();*/

    }
}
