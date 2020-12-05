package com.example.pjctppm.trangchu;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pjctppm.R;

import java.util.List;

public class adapter_listview_in_nhom extends RecyclerView.Adapter<adapter_listview_in_nhom.MyViewHolder2> {

    Context context;
    List<CaNhan_Nhom> list;
    private static OnClickListener listener;
    private static OnLongClickListener longClickListener;

    public interface OnClickListener {
        void OnClick(View view,int position);
    }

    public void setOnClickListener(OnClickListener listener){
        adapter_listview_in_nhom.listener=listener;
    }

    public interface OnLongClickListener {
        void OnLongClick(View view,int position);
    }

    public void setOnLongClickListener(OnLongClickListener longClickListener){
        adapter_listview_in_nhom.longClickListener=longClickListener;
    }

    public adapter_listview_in_nhom(Context context, List<CaNhan_Nhom> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item_cv_nhom,parent,false);
        MyViewHolder2 myViewHolder2 = new MyViewHolder2(v);

        return myViewHolder2;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder2 holder, int position) {
        holder.txt.setText(list.get(position).getName_work());
        holder.img.setImageResource(list.get(position).getImg_work());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder{

        TextView txt;
        ImageView img;

        public MyViewHolder2(@NonNull final View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.name_work_nhom);
            img = (ImageView) itemView.findViewById(R.id.icon_work_nhom);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.OnClick(itemView,getLayoutPosition());
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (longClickListener != null) {
                        longClickListener.OnLongClick(itemView,getLayoutPosition());
                    }
                    return true;
                }
            });
        }
    }
}