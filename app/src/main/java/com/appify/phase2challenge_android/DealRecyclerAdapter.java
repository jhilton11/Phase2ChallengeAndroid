package com.appify.phase2challenge_android;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DealRecyclerAdapter extends RecyclerView.Adapter<DealRecyclerAdapter.Holder>{
    //public DealListener mListener;
    private ArrayList<Deal> dealArrayList;
    private Context context;

    public interface DealListener {
        public void onClickListener(Deal deal);
    }

    public DealRecyclerAdapter(ArrayList<Deal> deals) {
        //this.mListener = mListener;
        this.dealArrayList = deals;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.deal_row_layout, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final Deal deal = dealArrayList.get(position);
        holder.locationTv.setText(deal.getLocation());
        holder.nameTv.setText(deal.getName());
        holder.amountTv.setText(deal.getAmount()+ "");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return dealArrayList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        TextView locationTv, nameTv, amountTv;
        ImageView imageView;
        public Holder(View itemView) {
            super(itemView);
            locationTv = itemView.findViewById(R.id.location_tv);
            nameTv = itemView.findViewById(R.id.name_tv);
            amountTv = itemView.findViewById(R.id.amount_tv);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
