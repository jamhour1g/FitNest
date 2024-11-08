package com.jamhour.android_util.recycler.profile;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jamhour.R;
import com.jamhour.android_util.ImageViewFromUri;
import com.jamhour.data.core.Exercise;

import java.time.Duration;

public class ProfileRecyclerViewHolder extends RecyclerView.ViewHolder {

    private final TextView userProfileExerciseNameTextView;
    private final TextView userProfileExerciseDurationTextView;
    private final TextView userProfileExerciseLevelTextView;
    private final TextView userProfileExerciseBodyParts;
    private final ImageView userProfileExerciseImageView;
    private final CheckBox trash;

    public ProfileRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        trash = itemView.findViewById(R.id.trash);
        userProfileExerciseNameTextView = itemView.findViewById(R.id.userProfileExerciseNameTextView);
        userProfileExerciseBodyParts = itemView.findViewById(R.id.userProfileExerciseBodyParts);
        userProfileExerciseDurationTextView = itemView.findViewById(R.id.userProfileExerciseDurationTextView);
        userProfileExerciseLevelTextView = itemView.findViewById(R.id.userProfileExerciseLevelTextView);
        userProfileExerciseImageView = itemView.findViewById(R.id.userProfileExerciseImageView);
    }

    public void updateViewForExercise(Exercise exercise, CompoundButton.OnCheckedChangeListener listener) {
        userProfileExerciseNameTextView.setText(exercise.getName());
        userProfileExerciseBodyParts.setText(exercise.getTrainingBodyParts());
        Duration duration = exercise.getDuration();
        userProfileExerciseDurationTextView.setText(
                "%2dH, %2dM"
                        .formatted(
                                duration.toHours(),
                                duration.toMinutesPart()
                        )
        );
        userProfileExerciseLevelTextView.setText(exercise.getLevel().toString());
        ImageViewFromUri.loadImage(exercise.getImageUri(), userProfileExerciseImageView);
        trash.setOnCheckedChangeListener(listener);
    }

}
