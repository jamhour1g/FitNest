package com.jamhour.android_util.recycler.profile;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jamhour.R;
import com.jamhour.data.core.Exercise;
import com.jamhour.data.generators.UserFactory;

import java.util.List;

public class ProfileRecyclerAdapter extends RecyclerView.Adapter<ProfileRecyclerViewHolder> {

    private final List<Exercise> exercises;

    public ProfileRecyclerAdapter(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public ProfileRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        var itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.profile_exercise_card, parent, false);

        return new ProfileRecyclerViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileRecyclerViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        holder.updateViewForExercise(exercise,
                (callerView, isChecked) -> {
                    UserFactory.getDefaultUser().removeExercise(exercise);
                    notifyItemRemoved(position);
                }
        );
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }
}