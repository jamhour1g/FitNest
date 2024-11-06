package com.jamhour.android_util;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jamhour.R;
import com.jamhour.activities.StartScreenActivity;
import com.jamhour.data.Category;
import com.jamhour.data.Exercise;

import java.time.Duration;
import java.util.List;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewHolder> {

    private final List<Category> categories = List.of(
            new Category(
                    "Strength Training",
                    "Build muscle and increase strength",
                    Duration.ofMinutes(60),
                    List.of(
                            new Exercise("Bench Press", "Chest", Duration.ofMinutes(10), Exercise.ExerciseLevel.INTERMEDIATE),
                            new Exercise("Deadlift", "Back", Duration.ofMinutes(15), Exercise.ExerciseLevel.ADVANCED),
                            new Exercise("Squats", "Legs", Duration.ofMinutes(10), Exercise.ExerciseLevel.INTERMEDIATE)
                    )
            ),
            new Category(
                    "Cardio",
                    "Improve cardiovascular endurance",
                    Duration.ofMinutes(45),
                    List.of(
                            new Exercise("Running", "Full Body", Duration.ofMinutes(30), Exercise.ExerciseLevel.BEGINNER),
                            new Exercise("Cycling", "Legs", Duration.ofMinutes(20), Exercise.ExerciseLevel.INTERMEDIATE),
                            new Exercise("Rowing", "Back and Arms", Duration.ofMinutes(15), Exercise.ExerciseLevel.ADVANCED)
                    )
            ),
            new Category(
                    "Flexibility",
                    "Increase flexibility and mobility",
                    Duration.ofMinutes(30),
                    List.of(
                            new Exercise("Yoga", "Full Body", Duration.ofMinutes(20), Exercise.ExerciseLevel.BEGINNER),
                            new Exercise("Stretching", "Legs", Duration.ofMinutes(10), Exercise.ExerciseLevel.BEGINNER),
                            new Exercise("Pilates", "Core", Duration.ofMinutes(15), Exercise.ExerciseLevel.INTERMEDIATE)
                    )
            )
    );


    @Override
    public int getItemCount() {
        return categories.size();
    }

    @NonNull
    @Override
    public CategoryRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_card, parent, false);

        return new CategoryRecyclerViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRecyclerViewHolder holder, int position) {
        holder.updateViewForCategory(
                categories.get(position),
                callerView -> {
                    Context context = callerView.getContext();
                    context.startActivity(new Intent(context, StartScreenActivity.class));
                }
        );
    }

}
