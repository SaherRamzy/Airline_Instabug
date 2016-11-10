package com.code.saher.airlines_instabug.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.code.saher.airlines_instabug.DB.DataBaseManager;
import com.code.saher.airlines_instabug.FavoriteActivity;
import com.code.saher.airlines_instabug.Interfaces.Retrofitinterface;
import com.code.saher.airlines_instabug.Model.Airline;
import com.code.saher.airlines_instabug.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import retrofit2.Retrofit;


public class DetailsFragment extends Fragment implements View.OnClickListener{

    final static String AIRLINE_BASE_URL = "https://www.kayak.com/";

    Airline result;
    ImageView iv_poster;
    TextView tv_1,tv_2,tv_3,tv_4;
    Button btn_fav,btn_show;
    RecyclerView list_trailers;
//    TrailerAdapter trailerAdapter;
    Gson gson;
    Retrofit retrofit;
    Retrofitinterface moviesAPI;
    DataBaseManager dataBaseManager;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        dataBaseManager = new DataBaseManager(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        result = (Airline) getActivity().getIntent().getExtras().getSerializable("result");

        iv_poster= (ImageView) view.findViewById(R.id.item_image);
        tv_1= (TextView) view.findViewById(R.id.item_text1);
        tv_2= (TextView) view.findViewById(R.id.item_text2);
        tv_3= (TextView) view.findViewById(R.id.item_text3);
        tv_4= (TextView) view.findViewById(R.id.item_text4);
        btn_fav = (Button) view.findViewById(R.id.btn_fav);
        btn_fav.setOnClickListener(this);
        btn_show = (Button) view.findViewById(R.id.btn_show);
        btn_show.setOnClickListener(this);

        list_trailers = (RecyclerView) view.findViewById(R.id.list_trailers);
        list_trailers.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        list_trailers.setLayoutManager( layoutManager);
//        initiaretrofit();

        Picasso.with(getActivity()).load(AIRLINE_BASE_URL+result.getLogoURL()).into(iv_poster);
        tv_1.setText(result.getDefaultName());
        tv_2.setText("ID : "+ result.getCode().toString());
        tv_3.setText("Site : "+result.getSite());
        tv_4.setText("Phone : "+result.getPhone().toString());

        return view;
    }

//    private void initiaretrofit(){
//        gson = new GsonBuilder().create();
//        retrofit = new Retrofit.Builder()
//                .baseUrl(AIRLINE_BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
//        moviesAPI = retrofit.create(Retrofitinterface.class);
//        getDataFromAPI(moviesAPI);
//    }
//
//    public void getDataFromAPI(Retrofitinterface moviesreq){
//        Call<Video> call = moviesreq.getVideos(result.getId().toString());
//        call.enqueue(new Callback<Video>() {
//            @Override
//            public void onResponse(Call<Video> call, Response<Video> response) {
//                int code = response.code();
//                if(code == 200){
//                    Video videoResp = response.body();
//                    arrayList= (ArrayList<com.code.saher.moviesapp.ModelForTrailer.Result>) videoResp.getResults();
//                    trailerAdapter = new TrailerAdapter(getActivity(),arrayList,R.layout.trailer_cell);
//                    list_trailers.setAdapter(trailerAdapter);
//                }
//                else {
//                    Toast.makeText(getActivity(), "Did not work after res " + String.valueOf(code), Toast.LENGTH_LONG).show();}
//            }
//
//            @Override
//            public void onFailure(Call<Video> call, Throwable t) {
//                Toast.makeText(getActivity(), "Did not work: " + String.valueOf(t), Toast.LENGTH_LONG).show();
//                Log.e("sunshine","error is " + String.valueOf(t));
//            }
//        });
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_fav :
                boolean check = dataBaseManager.Add_Favorite(result.getCode(),result.getDefaultName());
                if(check)Toast.makeText(getActivity(),"saved",Toast.LENGTH_SHORT).show();
                else Toast.makeText(getActivity(),"Not saved",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_show :
                startActivity(new Intent(getActivity(), FavoriteActivity.class));
                break;
        }
    }
}
