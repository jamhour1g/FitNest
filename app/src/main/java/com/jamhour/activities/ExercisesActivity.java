package com.jamhour.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jamhour.R;
import com.jamhour.android_util.ImageViewFromUri;
import com.jamhour.android_util.PaddedItemDecoration;
import com.jamhour.android_util.recycler.exercise.ExerciseRecyclerAdapter;
import com.jamhour.data.core.Category;

import java.time.Duration;

public class ExercisesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercises_activity);

        ImageView exerciseCategoryImageView = findViewById(R.id.exerciseCategoryImageView);

        TextView exerciseCategoryNumOfExercisesTextView = findViewById(R.id.exerciseCategoryNumOfExercisesTextView);
        TextView exerciseCategoryDurationTextView = findViewById(R.id.exerciseCategoryDurationTextView);
        TextView exerciseCategoryNameTextView = findViewById(R.id.exerciseCategoryNameTextView);

        RecyclerView exerciseRecyclerView = findViewById(R.id.exercisesRecyclerView);
        exerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        exerciseRecyclerView.addItemDecoration(new PaddedItemDecoration(15));


        var category = getIntent()
                .getParcelableExtra(Category.PARCELABLE_KEY, Category.class);

        if (category == null) {
            return;
        }

        ImageViewFromUri.loadImage(category.getImageUri(), exerciseCategoryImageView);
        exerciseCategoryNameTextView.setText(category.getName());
        Duration duration = category.getDuration();
        exerciseCategoryDurationTextView.setText(
                "%2dH, %2dM"
                        .formatted(
                                duration.toHours(),
                                duration.toMinutesPart()
                        )
        );
        exerciseCategoryNumOfExercisesTextView.setText(category.getNumberOfExercises() + " Exercises");
        exerciseRecyclerView.setAdapter(new ExerciseRecyclerAdapter(category.getExercises()));

    }

}