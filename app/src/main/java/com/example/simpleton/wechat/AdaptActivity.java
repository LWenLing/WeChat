package com.example.simpleton.wechat;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;

public class AdaptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapt);
        init();
        changeFragement(new StaticArrayFragment());
    }
    private SparseArray<Fragment> fragements;//存放所有需要加载的fragement,SparseArray相当于HashMap`

    public void onClick(View view) {
       changeFragement(fragements.get(view.getId()));

    }
    private void init(){
        fragements=new SparseArray<>();
        fragements.put(R.id.btn_shuzu,new contentFragment());
        fragements.put(R.id.btn_simple,new SimpleAdapterFragment());
        fragements.put(R.id.btn_custom,new CustomerFragment());
    }
    private void changeFragement(Fragment fragment){
     FragmentManager manager=getSupportFragmentManager();
     FragmentTransaction transaction=manager.beginTransaction();
     transaction.replace(R.id.list_fragment,fragment);//replace相当于add+remove
     transaction.commit();



    }
}
