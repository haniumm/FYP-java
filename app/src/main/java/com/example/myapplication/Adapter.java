package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private List<String> data,des;





    Adapter(Context context,List<String> data){
        this.layoutInflater=LayoutInflater.from(context);
        this.data=data;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view =layoutInflater.inflate(R.layout.custom_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
//bind textview with data received
        String title= data.get(i);
        ViewHolder.textTitle.setText(title);


        //similarly you can set new images for each card and  descrptions

    }

    @Override
    public int getItemCount() {
        return data.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{


        static TextView textTitle,textDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription=itemView.findViewById(R.id.textDiscription);
        }
    }
}
