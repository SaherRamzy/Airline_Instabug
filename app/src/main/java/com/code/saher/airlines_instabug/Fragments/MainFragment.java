package com.code.saher.airlines_instabug.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Toast;

import com.code.saher.airlines_instabug.Adapter.RetrofitAdapter;
import com.code.saher.airlines_instabug.Interfaces.Retrofitinterface;
import com.code.saher.airlines_instabug.Model.Airline;
import com.code.saher.airlines_instabug.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Field;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainFragment extends Fragment {

    final static String AIRLINE_BASE_URL = "https://www.kayak.com/";
    Retrofitinterface airlinesAPI;
    RetrofitAdapter retrofitAdapter;
    RecyclerView rv_show;
    Gson gson;
    Retrofit retrofit;
    ArrayList<Airline> result;

    public MainFragment() {
    }

    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main, container, false);
        try {
            ViewConfiguration config = ViewConfiguration.get(getActivity());
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if(menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception ex) {}

        rv_show = (RecyclerView) view.findViewById(R.id.rv_show);
//        rv_show.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),3);
        rv_show.setLayoutManager(layoutManager);
        //init retrofit
        initiaretrofit();
        return view;
    }

    private void initiaretrofit(){
        gson = new GsonBuilder().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(AIRLINE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        airlinesAPI = retrofit.create(Retrofitinterface.class);
        getDataFromAPI(airlinesAPI);
    }

    public void getDataFromAPI(Retrofitinterface moviesreq){
        Call<ArrayList<Airline>> call = moviesreq.getData();
        call.enqueue(new Callback<ArrayList<Airline>>() {
            @Override
            public void onResponse(Call<ArrayList<Airline>> call, Response<ArrayList<Airline>> response) {
                int code = response.code();
                if(code == 200){
                    result = response.body();
                    retrofitAdapter = new RetrofitAdapter(getActivity(),result,R.layout.grid_row);
                    rv_show.setAdapter(retrofitAdapter);
                }
                else {
                    Toast.makeText(getActivity(), "Did not work after res " + String.valueOf(code), Toast.LENGTH_LONG).show();}
            }

            @Override
            public void onFailure(Call<ArrayList<Airline>> call, Throwable t) {
                Toast.makeText(getActivity(), "Did not work: " + String.valueOf(t), Toast.LENGTH_LONG).show();
                Log.e("airlines","error is " + String.valueOf(t));
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
        switch(item.getItemId()){
//            case R.id.most_popular:
//                getDataFromPopularAPI(airlinesAPI);
//                break;
//            case R.id.highest_rated:
//                getDataFromTopRatedAPI(airlinesAPI);
//                break;
        }
        return true;
    }
}
