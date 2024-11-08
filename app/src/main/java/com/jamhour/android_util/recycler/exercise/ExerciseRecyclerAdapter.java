package com.jamhour.android_util.recycler.exercise;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jamhour.R;
import com.jamhour.data.core.Exercise;

import java.util.List;

public class ExerciseRecyclerAdapter extends RecyclerView.Adapter<ExerciseRecyclerViewHolder> {

    private final List<Exercise> exercises;

    public ExerciseRecyclerAdapter(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public ExerciseRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        var itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.exercise_card, parent, false);

        return new ExerciseRecyclerViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseRecyclerViewHolder holder, int position) {
        holder.updateViewForExercise(exercises.get(position));
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }
}
