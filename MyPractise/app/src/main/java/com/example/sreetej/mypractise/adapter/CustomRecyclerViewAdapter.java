package com.example.sreetej.mypractise.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sreetej.mypractise.R;

import java.util.zip.Inflater;

/**
 * Created by sreetej on 22/03/17.
 */

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.ViewHolder> {

    private String[] mDataSet;

    public CustomRecyclerViewAdapter(String[] dataSet) {
        this.mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(mDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            mCardView = (CardView) itemView.findViewById(R.id.card_view);
            textView = (TextView) itemView.findViewById(R.id.textView_card);

        }


    }
}
