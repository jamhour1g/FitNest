package com.jamhour.activities;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jamhour.R;
import com.jamhour.android_util.ImageViewFromUri;
import com.jamhour.android_util.PaddedItemDecoration;
import com.jamhour.android_util.recycler.category.CategoryRecyclerViewAdapter;
import com.jamhour.data.core.Category;
import com.jamhour.data.generators.DataSourceFactory;
import com.jamhour.data.generators.UserFactory;

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen_activity);

        Button categoriesSearchButton = findViewById(R.id.categoriesSearchButton);
        categoriesSearchButton.setOnClickListener(this::displaySearchAlert);

        requestPermissionLauncher.launch(Manifest.permission.INTERNET);

        updateProfileImage();
        updateCategoriesRecyclerView();
    }

    private void updateCategoriesRecyclerView() {
        RecyclerView workOutCategories = findViewById(R.id.workOutCategoriesRecyclerView);
        workOutCategories.setAdapter(new CategoryRecyclerViewAdapter());
        workOutCategories.setLayoutManager(new LinearLayoutManager(this));
        workOutCategories.addItemDecoration(new PaddedItemDecoration(15));
    }

    private void updateProfileImage() {
        ImageView imageView = findViewById(R.id.userProfileImageViewHomeScreen);
        UserFactory.getDefaultUser().getImageUri().ifPresentOrElse(
                uri -> ImageViewFromUri.loadImage(uri, imageView),
                () -> Log.d(HomeActivity.class.getName(), "onCreate: default user has no image")
        );

        imageView.setOnClickListener(v -> startActivity(new Intent(this, UserProfileActivity.class)));
    }

    private void displaySearchAlert(View callerView) {
        Context context = callerView.getContext();
        View searchDialogView = getLayoutInflater()
                .inflate(R.layout.search_dialog, null);
        new AlertDialog.Builder(context)
                .setTitle("Search for your favorite category")
                .setMessage("Please enter the name of the category you want to search for")
                .setPositiveButton("Search", onSearchButtonClicked(searchDialogView, context))
                .setView(searchDialogView)
                .create()
                .show();
    }

    private DialogInterface.OnClickListener onSearchButtonClicked(View searchDialogView, Context context) {
        return (dialog, which) -> {
            EditText categoryEditText = searchDialogView.findViewById(R.id.categoryToSearchForEditText);
            String category = categoryEditText.getText().toString();

            DataSourceFactory.getCategories().stream()
                    .filter(c -> c.getName().equalsIgnoreCase(category))
                    .findFirst()
                    .ifPresentOrElse(
                            c -> startActivity(
                                    new Intent(context, ExercisesActivity.class)
                                            .putExtra(Category.PARCELABLE_KEY, c)
                            ),
                            () -> Toast.makeText(context, "Category not found", Toast.LENGTH_LONG).show()
                    );

        };
    }

}