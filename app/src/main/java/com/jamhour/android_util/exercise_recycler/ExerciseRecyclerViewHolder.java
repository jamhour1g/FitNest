package com.jamhour.android_util.exercise_recycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jamhour.R;
import com.jamhour.android_util.ImageViewFromUri;
import com.jamhour.data.core.Exercise;

import java.time.Duration;

public class ExerciseRecyclerViewHolder extends RecyclerView.ViewHolder {

    private final TextView exerciseNameTextView;
    private final TextView exerciseDurationTextView;
    private final TextView exerciseLevelTextView;
    private final TextView exerciseBodyParts;
    private final ImageView exerciseCategoryImageView;

    public ExerciseRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        exerciseNameTextView = itemView.findViewById(R.id.exerciseNameTextView);
        exerciseBodyParts = itemView.findViewById(R.id.exerciseBodyParts);
        exerciseDurationTextView = itemView.findViewById(R.id.exerciseDurationTextView);
        exerciseLevelTextView = itemView.findViewById(R.id.exerciseLevelTextView);
        exerciseCategoryImageView = itemView.findViewById(R.id.exercise_categoryImageView);
    }

    public void updateViewForExercise(Exercise exercise) {
        exerciseNameTextView.setText(exercise.getName());
        exerciseBodyParts.setText(exercise.getTrainingBodyParts());
        Duration duration = exercise.getDuration();
        exerciseDurationTextView.setText(
                "%2dH, %2dM"
                        .formatted(
                                duration.toHours(),
                                duration.toMinutesPart()
                        )
        );
        exerciseLevelTextView.setText(exercise.getLevel().toString());
        ImageViewFromUri.loadImage(exercise.getImageUri(), exerciseCategoryImageView);
    }

}
