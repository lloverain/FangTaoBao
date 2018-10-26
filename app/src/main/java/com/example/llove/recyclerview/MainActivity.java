package com.example.llove.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private boolean panduan=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView fanhui = findViewById(R.id.fanhui);
        ImageView caidan = findViewById(R.id.caidan);
        EditText sousuo = findViewById(R.id.sousuo);
        TextView quanbu = findViewById(R.id.quanbu);
        TextView zhutianmao = findViewById(R.id.zhutianmao);
        TextView dianpu = findViewById(R.id.dianpu);
        TextView taogongnue = findViewById(R.id.taogongnue);
        TextView tiaojianhuo = findViewById(R.id.tiaojianhuo);
        TextView zonghe = findViewById(R.id.zonghe);
        TextView xiaoliang = findViewById(R.id.xiaoliang);
        TextView shiping = findViewById(R.id.shiping);
        TextView shaixuan = findViewById(R.id.shaixuan);
        fanhui.setOnClickListener(this);
        caidan.setOnClickListener(this);
        sousuo.setOnClickListener(this);
        quanbu.setOnClickListener(this);
        zhutianmao.setOnClickListener(this);
        dianpu.setOnClickListener(this);
        taogongnue.setOnClickListener(this);
        tiaojianhuo.setOnClickListener(this);
        zonghe.setOnClickListener(this);
        xiaoliang.setOnClickListener(this);
        shiping.setOnClickListener(this);
        shaixuan.setOnClickListener(this);

        final ImageView buju = findViewById(R.id.bujuqiehuan);
//      布局切换按钮单击事件
        buju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (panduan==true){
                    //执行瀑瀑流布局
                    panduan = false;
                    initDatas(panduan);
                    buju.setImageResource(R.mipmap.bujuqiehuan1);
                }else {
                    //执行线性布局
                    panduan = true;
                    initDatas(panduan);
                    buju.setImageResource(R.mipmap.bujuqiehuan);

                }

            }
        });


        //找到空间
        recyclerView = (RecyclerView) this.findViewById(R.id.recyclerview);
        //线
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //设置数据
        initDatas(panduan);

    }

    //这个方法设置数据
    private void initDatas(boolean panduan) {
        List<rain> data = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            rain a = new rain("2条装男士纯棉紧身薄款秋冬打底裤", R.mipmap.qiuku, "￥15", "2.9万", "上海", "进店", "七匹狼专卖店","天猫无忧购","天猫直送","公益宝贝","包邮","领店铺优惠卷“满99减20”");
            data.add(a);
            rain b = new rain("花花公子薄款男士秋冬单件", R.mipmap.huahuagongzi, "￥105", "10.9万", "成都", "进店", "花花公子专卖店","天猫直送","公益宝贝","","包邮","领店铺优惠卷“满99减20”");
            data.add(b);
            rain c = new rain("杨佳颖",R.mipmap.qiuku1,"无价","13亿","北京","进店","20170798","公益宝贝","","","包邮","");
            data.add(c);
            rain d = new rain("测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试",R.mipmap.tu,"￥10","1","成都","进店","测试啊","天猫无忧购","","","","");
            data.add(d);
            rain e = new rain("纯棉秋裤",R.mipmap.tutu,"￥50.3","2151","广州","进店","纯棉之家","天猫无忧购","公益宝贝","","","");
            data.add(e);
            rain f = new rain("七匹狼纯棉秋裤",R.mipmap.tutu1,"￥99","2.3万","深圳","进店","七匹狼旗舰店","天猫无忧购","公益宝贝","天猫直送","包邮","满100减10");
            data.add(f);
            rain g = new rain("俞兆林正宗纯棉秋裤",R.mipmap.tutu2,"￥24.9","8912","石家庄","进店","俞兆林","天猫无忧购","","","包邮","");
            data.add(g);
            rain h = new rain("花花公子2条纯棉保暖秋裤",R.mipmap.tutu3,"￥109.9","3.1万","河南","进店","花花公子专卖店","","","天猫直送","包邮","");
            data.add(h);
        }
        if(panduan==true) {
            //设置recyclerview管理器
            LinearLayoutManager manager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(manager);
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, data);
            recyclerView.setAdapter(adapter);

        }else {
            StaggeredGridLayoutManager manager1 = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(manager1);
            bub adapter = new bub(this, data);
            recyclerView.setAdapter(adapter);
        }
        //设置数据


        //List<bean>---Adapter ----展示数据
        //设置设配器

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fanhui:
                Intent intent = new Intent(MainActivity.this,zhujiemian.class);
                startActivity(intent);
                break;
            case  R.id.caidan:
                Toast.makeText(this, "这是菜单！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sousuo:

            case R.id.quanbu:
                Toast.makeText(this, "这是全部！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.zhutianmao:
                Toast.makeText(this, "这是天猫！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dianpu:
                Toast.makeText(this, "这是店铺", Toast.LENGTH_SHORT).show();
                break;
            case R.id.taogongnue:
                Toast.makeText(this, "这是淘攻略", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tiaojianhuo:
                Toast.makeText(this, "这是挑尖货", Toast.LENGTH_SHORT).show();
                break;
            case R.id.zonghe:
                Toast.makeText(this, "这是综合", Toast.LENGTH_SHORT).show();
                break;
            case R.id.xiaoliang:
                Toast.makeText(this, "这是销量", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shiping:
                Toast.makeText(this, "这是视频", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shaixuan:
                Toast.makeText(this, "这是筛选", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
