package com.example.rcv_class.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rcv_class.R;
import com.example.rcv_class.model.Music;

import java.util.List;

public class AdapterMusic extends RecyclerView.Adapter<AdapterMusic.MusicViewHolder> {
    private List<Music> musicList;
    private iClickItem iClickItem;
    //nhan danh sach tu ngoai vao
    public void setMusicList(List<Music> musicList1){
        musicList = musicList1;
        notifyDataSetChanged();
//        notifyItemChanged(9);

    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music, parent,false);



        MusicViewHolder viewHolder = new MusicViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Music music = musicList.get(position);
        if(music == null){
            return;
        }
        holder.imvAvt.setImageResource(music.getSrcImg());
        holder.tvName.setText(music.getName());


        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickItem.onClickItem(position);
            }
        });

    }


    @Override
    public int getItemCount() {
        if(musicList == null){
            return 0;
        }
        return musicList.size();//ttra ve tat ca phan tu trong lisst
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder{
        private ConstraintLayout constraintLayout;

        private ImageView imvAvt;
        private TextView tvName;

        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.layout_parent);
            imvAvt = itemView.findViewById(R.id.imv_avt);
            tvName = itemView.findViewById(R.id.tv_nameMusic);
        }
    }

    public void setCLickItem(iClickItem cLickItem){
            this.iClickItem = cLickItem; //
    }

    public interface iClickItem {
        void onClickItem(int position);
    }


}
