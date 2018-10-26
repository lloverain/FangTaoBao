package com.example.llove.recyclerview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class chatAdapter extends RecyclerView.Adapter<chatAdapter.ViewHolder> {
    private List<chat> datas;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.liaotian,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        chat shuju = datas.get(i);
        viewHolder.touxiang.setImageResource(shuju.getTouxiang());
        if (shuju.getLeixing()==chat.jieshou){
            viewHolder.zuobuju.setVisibility(View.VISIBLE);
            viewHolder.youbuju.setVisibility(View.GONE);
            viewHolder.zuoxiaoxi.setText(shuju.getXiaoxi());

        }
        if (shuju.getLeixing()==chat.fasong){
            viewHolder.youbuju.setVisibility(View.VISIBLE);
            viewHolder.zuobuju.setVisibility(View.GONE);
            viewHolder.youxiaoxi.setText(shuju.getXiaoxi());
        }

    }


    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
                private    LinearLayout zuobuju;
                private LinearLayout youbuju;
                private TextView zuoxiaoxi;
                private TextView youxiaoxi;
                private TextView dianming;
                private RoundedImageView touxiang;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
         zuobuju = itemView.findViewById(R.id.zuobianchat);
           zuoxiaoxi = itemView.findViewById(R.id.zuobianxiaoxi);
            youbuju = itemView.findViewById(R.id.youbianchat);
            youxiaoxi = itemView.findViewById(R.id.youbianxiaoxi);
            dianming = itemView.findViewById(R.id.dianming);
            touxiang = itemView.findViewById(R.id.zuotouxiang);
        }
    }
    public chatAdapter(List<chat> data){
        datas = data;
    }
}
