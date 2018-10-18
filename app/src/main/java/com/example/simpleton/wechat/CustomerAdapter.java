package com.example.simpleton.wechat;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class CustomerAdapter extends BaseAdapter {
    private List<Animal> animals;
    private Context context;
    public CustomerAdapter() {
    }

    public CustomerAdapter(Context context, List<Animal> animals) {
        this.animals = animals;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.animals.size();
    }

    @Override
    public Object getItem(int position) {
        return animals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    //每一条item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View view;
        if(convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.anmiallayout,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.animal_img);
            viewHolder.nameView = view.findViewById(R.id.animal_name);
            viewHolder.enterDateVIew = view.findViewById(R.id.animal_enter_date);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
       //给viewHoder赋值
        Animal animal = animals.get(position);
        viewHolder.imageView.setImageResource(animal.getImgId());
        viewHolder.nameView.setText(animal.getName());
        viewHolder.enterDateVIew.setText(DateFormat.format("yyyy-MM-dd EEEE hh:mm",animal.getEnterDate()));
        return view;
    }

    //成员： item_simple_adapter的所有需要显示内容的控件
    class ViewHolder{
        ImageView imageView;
        TextView nameView;
        TextView enterDateVIew;
    }
}
