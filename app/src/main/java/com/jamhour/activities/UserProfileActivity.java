package com.jamhour.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jamhour.R;
import com.jamhour.android_util.ImageViewFromUri;
import com.jamhour.android_util.PaddedItemDecoration;
import com.jamhour.android_util.recycler.profile.ProfileRecyclerAdapter;
import com.jamhour.data.generators.UserFactory;

public class UserProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile_activity);

        RecyclerView userExercisesRecyclerView = findViewById(R.id.userExercisesRecyclerView);
        userExercisesRecyclerView.setAdapter(
                new ProfileRecyclerAdapter(UserFactory.getDefaultUser().favoriteExercises())
        );
        userExercisesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        userExercisesRecyclerView.addItemDecoration(new PaddedItemDecoration(15));

        ImageView userProfileImageView = findViewById(R.id.userProfileImageView);
        UserFactory.getDefaultUser().getImageUri().ifPresentOrElse(
                uri -> ImageViewFromUri.loadImage(uri, userProfileImageView),
                () -> Log.d(UserProfileActivity.class.getName(), "onCreate: default user has no image")
        );

        super.<TextView>findViewById(R.id.userProfileNameTextView)
                .setText(UserFactory.getDefaultUser().getName());
        super.<TextView>findViewById(R.id.userProfileEmailTextView)
                .setText(UserFactory.getDefaultUser().getEmail());

        super.<Button>findViewById(R.id.userBackButton)
                .setOnClickListener(v -> finish());

    }
}