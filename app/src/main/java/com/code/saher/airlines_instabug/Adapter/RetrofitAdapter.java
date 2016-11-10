package com.code.saher.airlines_instabug.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.code.saher.airlines_instabug.DetailsActivity;
import com.code.saher.airlines_instabug.Model.Airline;
import com.code.saher.airlines_instabug.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by saher on 9/4/2016.
 */
public class RetrofitAdapter extends RecyclerView.Adapter<RetrofitAdapter.MovieViewHolder> {
    final static String AIRLINE_BASE_URL = "https://www.kayak.com/";

    private ArrayList<Airline> data;
    private int rowLayout;
    Context context;

public RetrofitAdapter(Context context, ArrayList<Airline> data, int rowLayout) {
        this.context = context;
        this.data = data;
        this.rowLayout = rowLayout;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieViewHolder holder, final int position) {
        holder.tv1.setText(data.get(position).getDefaultName());
        Picasso.with(context).load(AIRLINE_BASE_URL+data.get(position).getLogoURL()).into(holder.iv_showIcon);
        holder.iv_showIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("result", data.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder{
        TextView tv1;
        ImageView iv_showIcon;

        public MovieViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.item_text0);
            iv_showIcon = (ImageView) itemView.findViewById(R.id.item_image);
        }
    }
}
