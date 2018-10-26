package com.example.llove.recyclerview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

public class taobaochat extends AppCompatActivity {
    private String name;
    private int img;
    private List<chat> data =new ArrayList<>();
    private int c=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taobaochat);
        Intent intent = getIntent();
        //店名
        name = intent.getStringExtra("name").toString();
        //头像
        img = intent.getIntExtra("img",0);
        TextView dianming = findViewById(R.id.dianming);
        dianming.setText(name);

        final RecyclerView recyclerView = findViewById(R.id.chat);
        final TextView neirong = findViewById(R.id.neirong);
        Button send = findViewById(R.id.send);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        final chatAdapter chatAdapter = new chatAdapter(data);

        recyclerView.setAdapter(chatAdapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = neirong.getText().toString();
                switch (c){
                    case 1:
                        c = 2;
                        if (!neirong.equals("")){
                            chat chat = new chat(a,img, com.example.llove.recyclerview.chat.fasong);
                            data.add(chat);
                            chatAdapter.notifyItemChanged(data.size()-1);
                            recyclerView.scrollToPosition(data.size()-1);
                            neirong.setText("");

                        }
                        break;
                    case 2:
                        c=1;
                        if (!neirong.equals(""));
                        chat chat = new chat(a, img,com.example.llove.recyclerview.chat.jieshou);
                        data.add(chat);
                        chatAdapter.notifyItemInserted(data.size()-1);
                        recyclerView.scrollToPosition(data.size()-1);
                        neirong.setText("");
                }
            }
        });

    }


}
