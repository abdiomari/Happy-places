package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    Context context;
    ArrayList<Data> list;

    public MyAdapter(Context context, ArrayList<Data> list) {
        this.context = context;
        this.list = list;
    }

    public MyAdapter(ArrayList<DataClass> dataList, OpenGalleryActivity openGalleryActivity) {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
       return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Data data = list.get(position);
        holder.title.setText(data.getTitle());
        holder.description.setText(data.getDescription());
//      Glide.with(holder.itemView.getContext()).load(data.getImageUri()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title, description;
//        ImageView imageView;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

          title = itemView.findViewById(R.id.titleTextView);
          description = itemView.findViewById(R.id.descriptionTextView);
//          imageView = itemView.findViewById(R.id.imageView);

        }
    }

}
