package com.jamhour.android_util.recycler.exercise;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.IconCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jamhour.R;
import com.jamhour.android_util.ImageViewFromUri;
import com.jamhour.data.core.Exercise;
import com.jamhour.data.generators.UserFactory;

import java.time.Duration;

public final class ExerciseRecyclerViewHolder extends RecyclerView.ViewHolder {

    private final TextView exerciseNameTextView;
    private final TextView exerciseDurationTextView;
    private final TextView exerciseLevelTextView;
    private final TextView exerciseBodyParts;
    private final ImageView exerciseCategoryImageView;
    private final CheckBox favoriteCheckBox;

    public ExerciseRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        favoriteCheckBox = itemView.findViewById(R.id.favoriteCheckBox);
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
        favoriteCheckBox.setOnCheckedChangeListener(getOnCheckedChangeListener(exercise));
    }

    private CompoundButton.OnCheckedChangeListener getOnCheckedChangeListener(Exercise exercise) {
        return (v, isChecked) -> {
            if (isChecked) {
                favoriteCheckBox.setButtonIcon(
                        IconCompat.createWithResource(
                                v.getContext(),
                                R.drawable.added_to_favorites_icon
                        ).toIcon(v.getContext())
                );
                UserFactory.getDefaultUser().addExercise(exercise);
            } else {
                favoriteCheckBox.setButtonIcon(
                        IconCompat.createWithResource(
                                v.getContext(),
                                R.drawable.favorite_icon
                        ).toIcon(v.getContext())
                );
                UserFactory.getDefaultUser().removeExercise(exercise);
            }
        };
    }

}
