package com.sreeharan.farm_e;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sreeharan.farm_e.Adapters.LandAdapter;

public class MainActivity extends AppCompatActivity implements LandAdapter.LandItemClickListener {

    private static final int NUM_LIST_ITEMS = 5;
    private LandAdapter mAdapter;
    private RecyclerView mLandList;

    private static boolean isLoggedIn = false;
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
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.removeItem(isLoggedIn?R.id.sign_out:R.id.sign_up);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_auth_state, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sign_up:
                isLoggedIn = (!isLoggedIn);
                Toast.makeText(this, "Signed in", Toast.LENGTH_SHORT).show();
                invalidateOptionsMenu();
                return true;
            case R.id.sign_out:
                isLoggedIn = (!isLoggedIn);
                Toast.makeText(this, "Signed out", Toast.LENGTH_SHORT).show();
                invalidateOptionsMenu();
                return true;
            case R.id.toggle_button:
                isLoggedIn = (!isLoggedIn);
                Toast.makeText(this, "logged in is set to "+isLoggedIn, Toast.LENGTH_SHORT).show();
                invalidateOptionsMenu();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onLandItemClick(int clickedLandIndex) {
        Intent i = new Intent(MainActivity.this, LandDetailsActivity.class);
        startActivity(i);
    }
}