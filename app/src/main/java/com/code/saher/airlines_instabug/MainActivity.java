package com.code.saher.airlines_instabug;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.code.saher.airlines_instabug.Fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main, new MainFragment())
                .commit();
    }
}
