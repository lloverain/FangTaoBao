
package com.example.llove.recyclerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class zhujiemian extends FragmentActivity implements View.OnClickListener {
    private TextView shouye;
    private TextView weitao;
    private TextView xiaoxi;
    private TextView gouwuche;
    private TextView wodetaobao;
    private Fragment tab1;
    private Fragment tab2;
    private Fragment tab3;
    private Fragment tab4;
    private Fragment tab5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhujiemian);
        shouye = findViewById(R.id.shouye);
        weitao = findViewById(R.id.weitao);
        xiaoxi = findViewById(R.id.xiaoxi);
        gouwuche = findViewById(R.id.gouwuche);
        wodetaobao = findViewById(R.id.wodetaobao);

        shouye.setOnClickListener(this);
        weitao.setOnClickListener(this);
        xiaoxi.setOnClickListener(this);
        gouwuche.setOnClickListener(this);
        wodetaobao.setOnClickListener(this);
        select(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shouye:
                select(0);
                break;
            case R.id.weitao:
                select(1);
                break;
            case R.id.xiaoxi:
                select(2);
                break;
            case R.id.gouwuche:
                select(3);
                break;
            case R.id.wodetaobao:
                select(4);
                break;
        }

    }

    private void select(int i) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        yingcang(fragmentTransaction);
        switch (i) {
            case 0:
                if (tab1 == null) {
                    tab1 = new shouye();
                    fragmentTransaction.add(R.id.content, tab1);
                } else {
                    fragmentTransaction.show(tab1);
                }
                break;
            case 1:
                if (tab2 == null) {
                    tab2 = new weitao();
                    fragmentTransaction.add(R.id.content, tab2);
                } else {
                    fragmentTransaction.show(tab2);
                }
                break;
            case 2:
                if (tab3 == null) {
                    tab3 = new xiaoxi();
                    fragmentTransaction.add(R.id.content, tab3);
                } else {
                    fragmentTransaction.show(tab3);
                }
                break;
            case 3:
                if (tab4 == null) {
                    tab4 = new gouwuche();
                    fragmentTransaction.add(R.id.content, tab4);
                } else {
                    fragmentTransaction.show(tab4);
                }
                break;
            case 4:
                if (tab5 == null) {
                    tab5 = new wodetaobao();
                    fragmentTransaction.add(R.id.content, tab5);
                } else {
                    fragmentTransaction.show(tab5);
                }
                break;
            default:
                break;
        }
        fragmentTransaction.commit();//提交事务
    }

    private void yingcang(FragmentTransaction transaction) {
        if (tab1 != null) {
            transaction.hide(tab1);
        }
        if (tab2 != null) {
            transaction.hide(tab2);
        }
        if (tab3 != null) {
            transaction.hide(tab3);
        }
        if (tab4 != null) {
            transaction.hide(tab4);
        }
        if (tab5 != null) {
            transaction.hide(tab5);
        }
    }
}