package com.example.simpleton.wechat;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v4.app.Fragment;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleAdapterFragment extends Fragment {


    public SimpleAdapterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_simple_adapter, container, false);
       //首先第一个获取数据，自定义模拟数据完成
        initData();
        initView(v);
        return v;

    }

    private void initView(View view) {
        ListView animalListView =view.findViewById(R.id.animal_list);
        SimpleAdapter adapter=new SimpleAdapter(getActivity(),
                datas
                ,
                R.layout.anmiallayout
                ,
                new String[]{"img_id","name","enter_date"}
                ,
                new int[]{R.id.animal_img,R.id.animal_name,R.id.animal_enter_date});
        animalListView.setAdapter(adapter);
    }

    private List<HashMap<String,Object>> datas;
    private void initData() {
        List<Animal> animals=new ArrayList<>();
        animals.add(new Animal(R.drawable.default_useravatar,"狮子",new Date()));
        animals.add(new Animal(R.mipmap.ic_launcher,"狮子",new Date()));
        animals.add(new Animal(R.mipmap.ic_launcher,"狮子",new Date()));
        animals.add(new Animal(R.mipmap.ic_launcher,"狮子",new Date()));
        animals.add(new Animal(R.mipmap.ic_launcher,"狮子",new Date()));
        animals.add(new Animal(R.mipmap.ic_launcher,"狮子",new Date()));
        animals.add(new Animal(R.mipmap.ic_launcher,"狮子",new Date()));
        //将数据的集合转为SimpleAdapter需要的数据结构
        datas=new ArrayList<>();
        for(Animal animal :animals){
            HashMap<String,Object> tmp=new HashMap<>();
            String EnterDate=String.format(Locale.CHINA,"%tF %tT",animal.getEnterDate(),animal.getEnterDate());
            tmp.put("img_id",animal.getImgId());
            tmp.put("name",animal.getName());
            tmp.put("enter_date",EnterDate);
            datas.add(tmp);
        }
    }

}
