package com.example.llove.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class xiaoxi extends Fragment {
        private List<Integer> data;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_xiaoxi, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDatas();
        RecyclerView xiaoxiliaotian = getActivity().findViewById(R.id.xiaoxiliebiao);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        xiaoxiliaotian.setLayoutManager(manager);
//        RecyclerViewAdapter adap                ter = new RecyclerViewAdapter(getActivity(), data);
//        xiaoxiliaotian.setAdapter(adapter);

    }

    private void initDatas() {

    }
}
