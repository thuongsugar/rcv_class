package com.example.rcv_class;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

import com.example.rcv_class.adapter.AdapterMusic;
import com.example.rcv_class.model.Music;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    //bat buoc co 3 cai nay
    private RecyclerView rcvMusic;
    private AdapterMusic adapterMusic;
    private List<Music> musicList;
    //

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        addEvents();
    }

    private void addEvents() {

    }

    private void initUI() {
        rcvMusic = findViewById(R.id.rcv_music);
        musicList = new ArrayList<>();
        adapterMusic = new AdapterMusic();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);


        //lam gia du lieu
        musicList.add(new Music(R.drawable.a,
                "Bai hat fake",
                "https://aredir.nixcdn.com/NhacCuaTui1019/GapGoYeuDuongVaDuocBenEm-PhanManhQuynh-7061898.mp3?st=sIoqH7cD8imEmvtIUtNjvQ&e=1631635351"));
        for (int i = 0; i < 30; i++) {
            Music m = new Music(R.drawable.a,"Bai hat thu: "+ i);
            musicList.add(m);
        }
        //


        adapterMusic.setMusicList(musicList);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false
        );
        rcvMusic.setLayoutManager(linearLayoutManager);// kieu du lieu hien thi

        rcvMusic.addItemDecoration(itemDecoration);
        rcvMusic.setAdapter(adapterMusic);

        //bat su kien onclick
        adapterMusic.setCLickItem(new AdapterMusic.iClickItem() {
            @Override
            public void onClickItem(int position) {
                Music m = musicList.get(position);
                Toast.makeText(MainActivity.this,m.getName(),Toast.LENGTH_LONG).show();
                if(m.getUrlMusic() != null){
                    try {
                        mediaPlayer.setDataSource(m.getUrlMusic());
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }
        });

    }

}