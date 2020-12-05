package com.example.pjctppm.trangchu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pjctppm.R;

import java.util.List;

public class menu_adapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<item_navigation_view> list;

    public menu_adapter(Context context, int layout, List<item_navigation_view> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView txt;
        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);

            viewHolder = new ViewHolder();
            viewHolder.txt = convertView.findViewById(R.id.item_txt);
            viewHolder.img = convertView.findViewById(R.id.item_img);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txt.setText(list.get(position).name);
        viewHolder.img.setImageResource(list.get(position).icon);
        return convertView;
    }
}
