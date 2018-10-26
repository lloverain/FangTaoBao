package com.example.llove.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static java.lang.Math.random;

public class bub extends RecyclerView.Adapter<bub.ItemHolder> {


    private final Context mContext;
    private final List<rain> shuju;


    //MainActivity传来的值，这里接收
    public bub(Context context, List<rain> dt) {
        //成员变量
        this.shuju = dt;
        this.mContext = context;
    }

    @NonNull

    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //这里是创建条目的回调函数  样式
        View view = LayoutInflater.from(mContext).inflate(R.layout.bubu, viewGroup, false);
        ItemHolder holder = new ItemHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        //这里绑定数据
        final rain data = shuju.get(i);
        itemHolder.tu.setImageResource(data.getImg());
        itemHolder.mc.setText(data.getName());
        itemHolder.jg.setText(data.getJiage());
        itemHolder.rs.setText(data.getRenshu() + "人付款");
        itemHolder.dd.setText(data.getDidian());
        itemHolder.tb.setText(data.getTianmao());
        itemHolder.tb1.setText(data.getTianmao1());
        itemHolder.tb2.setText(data.getTianmao2());
        itemHolder.yh.setText(data.getYouhu());
        itemHolder.by.setText(data.getBaoyou());

        itemHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,taobaochat.class);
                intent.putExtra("name",data.getDianming());
                intent.putExtra("img",data.getImg());
                mContext.startActivity(intent);
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
        //////////////////////////////////////
        if ((itemHolder.tb.getText().equals("天猫无忧购") || itemHolder.tb.getText().equals("天猫直送") || itemHolder.tb.getText().equals("公益宝贝")) &&(
                itemHolder.tb1.getText().equals("天猫无忧购") || itemHolder.tb1.getText().equals("天猫直送") || itemHolder.tb1.getText().equals("公益宝贝") )&&(
                itemHolder.tb2.getText().equals("天猫无忧购") || itemHolder.tb2.getText().equals("天猫直送") || itemHolder.tb2.getText().equals("公益宝贝"))) {
            int shu = (int) (random() * 3);
            switch (shu) {
                case 0:
                    itemHolder.tb.setVisibility(View.GONE);
                    break;
                case 1:
                    itemHolder.tb1.setVisibility(View.GONE);
                    break;
                case 2:
                    itemHolder.tb2.setVisibility(View.GONE);
                    break;

            }
        }
        //设置数据
//        itemHolder.setDate(data);

        //设置单击事件


    }

    @Override
    public int getItemCount() {
        //这个方法用于设置这条目的数目

        if (shuju != null) {
            return shuju.size();
        }

        return 0;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private TextView mc;
        private ImageView tu;
        private TextView jg;
        private TextView rs;
        private TextView dd;
        private TextView tb;
        private TextView tb1;
        private TextView tb2;
        private TextView yh;
        private TextView by;
        private View item;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            //名称mc
            mc = itemView.findViewById(R.id.name1);
            //图片
            tu = itemView.findViewById(R.id.tu1);
            //价格
            jg = itemView.findViewById(R.id.jg1);
            //人数
            rs = itemView.findViewById(R.id.rs1);

            //地点
            dd = itemView.findViewById(R.id.dd1);

            //淘宝提示1
            tb = itemView.findViewById(R.id.tm1);
            //淘宝提示2
            tb1 = itemView.findViewById(R.id.tm1);
            //淘宝提示3
            tb2 = itemView.findViewById(R.id.tm2);
            //优惠
            yh = itemView.findViewById(R.id.youhui1);
            //包邮
            by = itemView.findViewById(R.id.baoyou1);

            item = itemView.findViewById(R.id.item);
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
