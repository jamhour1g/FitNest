package com.jamhour.android_util.category_recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jamhour.DataSetFactory;
import com.jamhour.R;
import com.jamhour.activities.ExercisesActivity;
import com.jamhour.data.core.Category;

import java.util.List;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewHolder> {

    private final List<Category> categories = DataSetFactory.getCategories();

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

                    var intent = new Intent(context, ExercisesActivity.class)
                            .putExtra(Category.PARCELABLE_KEY, categories.get(position));

                    context.startActivity(intent);
                }
        );
    }

}
