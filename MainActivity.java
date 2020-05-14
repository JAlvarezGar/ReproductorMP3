package com.example.jjalv.nuevoreproductormultimedia;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements Button.OnClickListener {

    TextView tv1;
    Button bt1, bt2, bt3, bt4,bt5;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.textView);
        bt1 = (Button) findViewById(R.id.play);
        bt2 = (Button) findViewById(R.id.pausa);
        bt3 = (Button) findViewById(R.id.stop);
        bt4 = (Button) findViewById(R.id.power);
        bt5=(Button)findViewById(R.id.escoger);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.escoger:

                Intent escoge= new Intent(this,EscogerTema.class);
                startActivity(escoge);

                break;

            case R.id.play:
                Bundle datos = this.getIntent().getExtras();
                String tema = datos.getString("cancion" );
                mediaPlayer = MediaPlayer.create(this, Uri.parse(tema));
                mediaPlayer.start();
                break;
            case R.id.pausa:
                int posicion = mediaPlayer.getCurrentPosition();
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }else{
                    mediaPlayer.seekTo(posicion);
                    mediaPlayer.start();
                }
                break;
            case R.id.stop:
                mediaPlayer.stop();
                break;
            case R.id.power:
                mediaPlayer.stop();

        }


    }


}
