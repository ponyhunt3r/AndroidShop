package com.example.annac.firstone;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";



    ArrayList<String> list1;
    ArrayList<String> list2;
    ArrayList<String> list3;

    public RecyclerViewAdapter(ArrayList<String> l1, ArrayList<String> l2, ArrayList<String> l3) {
        list1 = l1;
        list2 = l2;
        list3 = l3;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d("LOG", "XXX");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.Company.setText(list1.get(i));
        viewHolder.Price.setText(list2.get(i));
        viewHolder.Model.setText(list3.get(i));
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Company;
        TextView Model;
        TextView Price;



        public ViewHolder(View itemView) {
            super(itemView);
            RelativeLayout parentLayout;
            Company = itemView.findViewById(R.id.Company);
            Model = itemView.findViewById(R.id.Model);
            Price = itemView.findViewById(R.id.Price);

            parentLayout = itemView.findViewById((R.id.recycler_view));
        }

    }

}
