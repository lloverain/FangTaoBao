package com.example.llove.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class xiaoxiAdatper extends RecyclerView.Adapter<xiaoxiAdatper.IntmHolder> {
    private List<xiaoxichat> datas;
    private Context context;

    @NonNull
    @Override
    public xiaoxiAdatper.IntmHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.xiaoxiliebiao, viewGroup, false);
        IntmHolder holder = new IntmHolder(view);
        return  holder;

    }

    @Override
    public void onBindViewHolder(@NonNull xiaoxiAdatper.IntmHolder intmHolder, int i) {
                    xiaoxichat data = datas.get(i);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class IntmHolder extends RecyclerView.ViewHolder {
        private RoundedImageView touxiang;
        private TextView dianmingname;
        private TextView endxiaoxi;
        private TextView time;
        public IntmHolder(@NonNull View itemView) {
            super(itemView);

            touxiang = itemView.findViewById(R.id.xiaoxiliebiaotouxiang);
            dianmingname = itemView.findViewById(R.id.xiaoxiliebiaodianming);
            endxiaoxi = itemView.findViewById(R.id.endxiaoxi);
            time = itemView.findViewById(R.id.time);

        }
    }
}
