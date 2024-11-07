package com.jamhour.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jamhour.R;
import com.jamhour.android_util.PaddedItemDecoration;
import com.jamhour.android_util.category_recycler.CategoryRecyclerViewAdapter;

public class HomeActivity extends AppCompatActivity {
    private final ActivityResultLauncher<String> requestPermissionLauncher = registerForActivityResult(
            new ActivityResultContracts.RequestPermission(),
            isGranted -> {
                if (Boolean.FALSE.equals(isGranted)) {
                    Toast.makeText(
                                    this,
                                    "Failed to load images without permission to access internet",
                                    Toast.LENGTH_LONG
                            )
                            .show();
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.home_screen_activity);
        super.onCreate(savedInstanceState);

        requestPermissionLauncher.launch("android.permission.INTERNET");
        RecyclerView workOutCategories = findViewById(R.id.workOutCategoriesRecyclerView);
        workOutCategories.setAdapter(new CategoryRecyclerViewAdapter());
        workOutCategories.setLayoutManager(new LinearLayoutManager(this));
        workOutCategories.addItemDecoration(new PaddedItemDecoration(15));

    }

}