package com.example.simpleton.wechat;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerFragment extends Fragment {
    private List<Animal> animals;
    private ListView listView;

    public CustomerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.anmiallayout, container, false);
        initData();
        initView(view);
        return view;
    }

    private void initView(View view) {
        listView = view.findViewById(R.id.list_custom);
        final CustomerAdapter simpleAdapter = new CustomerAdapter(CustomerFragment.this.getActivity(), animals);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private void initData() {
        animals = new ArrayList<>();
        animals.add(new Animal(R.mipmap.ic_launcher, "狮子", new Date()));
        animals.add(new Animal(R.mipmap.ic_launcher, "老虎", new Date()));
        animals.add(new Animal(R.mipmap.ic_launcher, "兔子", new Date()));
        animals.add(new Animal(R.mipmap.ic_launcher, "长颈鹿", new Date()));
        animals.add(new Animal(R.mipmap.ic_launcher, "啦啦啦啦", new Date()));
    }

}
