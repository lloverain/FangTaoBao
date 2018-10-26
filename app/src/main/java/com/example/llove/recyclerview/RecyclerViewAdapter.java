package com.example.llove.recyclerview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemHolder> {


    private final Context mContext;
    private final List<rain> mDatas;


    //MainActivity传来的值，这里接收
    public RecyclerViewAdapter(Context context, List<rain> datas) {
        //成员变量
        this.mDatas = datas;
        this.mContext = context;
    }

    //单击

    private OnMyItemClickListener listener;

    public void setOnMyItemClickListener(OnMyItemClickListener listener) {
        this.listener = listener;

    }

    public interface OnMyItemClickListener {
        void myClick(View v, int pos);

        void mLongClick(View v, int pos);
    }


    @NonNull

    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //这里是创建条目的回调函数  样式
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_view, viewGroup, false);
        ItemHolder holder = new ItemHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemHolder itemHolder, int i) {
        //这里绑定数据
        final rain data = mDatas.get(i);
        itemHolder.tu.setImageResource(data.getImg());
        itemHolder.mc.setText(data.getName());
        itemHolder.jg.setText(data.getJiage());
        itemHolder.rs.setText(data.getRenshu());
        itemHolder.dd.setText(data.getDidian());
        itemHolder.jd.setText(data.getJindian());
        itemHolder.dm.setText(data.getDianming());
        itemHolder.tb.setText(data.getTianmao());
        itemHolder.tb1.setText(data.getTianmao1());
        itemHolder.tb2.setText(data.getTianmao2());
        itemHolder.yh.setText(data.getYouhu());
        itemHolder.by.setText(data.getBaoyou());
        itemHolder.jd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, data.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        itemHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,taobaochat.class);
                intent.putExtra("name",data.getDianming());
                intent.putExtra("img",data.getImg());
                mContext.startActivity(intent);


            }
        });

        itemHolder.tu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "这是" + data.getImg() + "图", Toast.LENGTH_SHORT).show();

            }
        });

        if (itemHolder.tb.getText().equals("")) {
            itemHolder.tb.setVisibility(View.GONE);
        }
        if (itemHolder.tb1.getText().equals("")) {
            itemHolder.tb1.setVisibility(View.GONE);
        }
        if (itemHolder.tb2.getText().equals("")) {
            itemHolder.tb2.setVisibility(View.GONE);
        }
        if (itemHolder.yh.getText().equals("")) {
            itemHolder.yh.setVisibility(View.INVISIBLE);
        }
        if (itemHolder.by.getText().equals("")) {
            itemHolder.by.setVisibility(View.GONE);
        }
        //设置数据
//        itemHolder.setDate(data);

        //设置单击事件


    }

    @Override
    public int getItemCount() {
        //这个方法用于设置这条目的数目

        if (mDatas != null) {
            return mDatas.size();
        }

        return 0;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private TextView mc;
        private ImageView tu;
        private TextView jg;
        private TextView rs;
        private TextView dd;
        private TextView dm;
        private TextView jd;
        private TextView tb;
        private TextView tb1;
        private TextView tb2;
        private TextView yh;
        private TextView by;
        private View item;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            //名称mc
            mc = itemView.findViewById(R.id.name);
            //图片
            tu = itemView.findViewById(R.id.tu);
            //价格
            jg = itemView.findViewById(R.id.jg);
            //人数
            rs = itemView.findViewById(R.id.rs);

            //地点
            dd = itemView.findViewById(R.id.dd);
            //店名
            dm = itemView.findViewById(R.id.djm);
            //进店
            jd = itemView.findViewById(R.id.jd);
            //淘宝提示1
            tb = itemView.findViewById(R.id.tiammao);
            //淘宝提示2
            tb1 = itemView.findViewById(R.id.tiammao1);
            //淘宝提示3
            tb2 = itemView.findViewById(R.id.tiammao2);
            //优惠
            yh = itemView.findViewById(R.id.youhui);
            //包邮
            by = itemView.findViewById(R.id.baoyou);

            item = itemView.findViewById(R.id.youbianzhenggebuju);

        }
//
//                 public void setDate(rain data) {
//
//                //控件绑定数据
//                text.setText("");
//                imageView.setImageResource(R.mipmap.tu);
//
//        }
    }


}


