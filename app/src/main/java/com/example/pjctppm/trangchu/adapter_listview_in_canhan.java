package com.example.pjctppm.trangchu;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pjctppm.R;

import java.util.List;

public class adapter_listview_in_canhan extends RecyclerView.Adapter<adapter_listview_in_canhan.MyViewHolder> {

    Context context;
    List<CaNhan_Nhom> list;

    private static OnItemClickListener listener;
    private static OnLongClickListener longClickListener;

    public interface OnItemClickListener {
        void OnItemClick(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        adapter_listview_in_canhan.listener = listener;
    }

    public interface OnLongClickListener {
        void OnLongClick (View view,int position);
    }

    public void setOnLongClickListener(adapter_listview_in_canhan.OnLongClickListener longClickListener) {
        adapter_listview_in_canhan.longClickListener = longClickListener;
    }

    public adapter_listview_in_canhan(Context context, List<CaNhan_Nhom> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(context).inflate(R.layout.item_cv_canhan,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.txt.setText(list.get(position).getName_work());
        holder.img.setImageResource(list.get(position).getImg_work());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txt;
        private ImageView img;
        //  private ItemClickListener itemClickListener;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.name_work_canhan);
            img = (ImageView) itemView.findViewById(R.id.icon_work_canhan);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.OnItemClick(itemView,getLayoutPosition());
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