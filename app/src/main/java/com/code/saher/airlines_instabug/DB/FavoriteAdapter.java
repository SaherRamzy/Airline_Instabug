package com.code.saher.airlines_instabug.DB;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.code.saher.airlines_instabug.R;

import java.util.ArrayList;

/**
 * Created by saher on 11/7/2016.
 */

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder> {

    private ArrayList<FavoriteModel> data;
    private int rowLayout;
    Context context;

    public FavoriteAdapter(Context context, ArrayList<FavoriteModel> data, int rowLayout) {
        this.context = context;
        this.data = data;
        this.rowLayout = rowLayout;
    }

    @Override
    public FavoriteAdapter.FavoriteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new FavoriteAdapter.FavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FavoriteAdapter.FavoriteViewHolder holder, int position) {
        holder.ID.setText(Integer.toString(data.get(position).ID));
        holder.Name.setText(data.get(position).Name);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class FavoriteViewHolder extends RecyclerView.ViewHolder{
        TextView ID;
        TextView Name;
        TextView popularity;

        public FavoriteViewHolder(View itemView) {
            super(itemView);
            ID = (TextView) itemView.findViewById(R.id.movie_id);
            Name = (TextView) itemView.findViewById(R.id.movie_name);
            popularity = (TextView) itemView.findViewById(R.id.movie_pop);
        }
    }
}
