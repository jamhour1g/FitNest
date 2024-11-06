package com.jamhour.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jamhour.R;
import com.jamhour.android_util.CategoryRecyclerViewAdapter;
import com.jamhour.android_util.PaddedItemDecoration;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.home_screen_activity);
        super.onCreate(savedInstanceState);

        RecyclerView workOutCategories = findViewById(R.id.workOutCategoriesRecyclerView);
        workOutCategories.setAdapter(new CategoryRecyclerViewAdapter());
        workOutCategories.setLayoutManager(new LinearLayoutManager(this));
        workOutCategories.addItemDecoration(new PaddedItemDecoration(15));

    }

}