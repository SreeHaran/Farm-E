package com.sreeharan.farm_e;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sreeharan.farm_e.Adapters.LandAdapter;

public class MainActivity extends AppCompatActivity implements LandAdapter.LandItemClickListener {

    private static final int NUM_LIST_ITEMS = 5;
    private LandAdapter mAdapter;
    private RecyclerView mLandList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLandList = findViewById(R.id.land_rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mLandList.setLayoutManager(layoutManager);

        mLandList.setHasFixedSize(true);
        mAdapter = new LandAdapter(NUM_LIST_ITEMS, this);
        mLandList.setAdapter(mAdapter);
    }

    @Override
    public void onLandItemClick(int clickedLandIndex) {
        Intent i = new Intent(MainActivity.this, LandDetailsActivity.class);
        startActivity(i);

    }
}