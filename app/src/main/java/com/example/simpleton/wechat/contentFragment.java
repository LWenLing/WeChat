package com.example.simpleton.wechat;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class contentFragment extends Fragment {

private List<String> weeks;

    public contentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  v=inflater.inflate(R.layout.fragment_content, container, false);
        init();
        ListView contentlist=v.findViewById(R.id.content_list);
        ArrayAdapter<String>adapter=new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,weeks);
        contentlist.setAdapter(adapter);
        //每个Item的点击事件的监听和处理
        contentlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String week=(String)parent.getItemAtPosition(position);
                Toast.makeText(contentFragment.this.getActivity(),week,Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
    private void init(){
        weeks=new ArrayList<>();
        weeks.add("周一");
        weeks.add("周2");
        weeks.add("周3");
        weeks.add("周4");
        weeks.add("周5");
        weeks.add("周6");
        weeks.add("周7");


    }

}
