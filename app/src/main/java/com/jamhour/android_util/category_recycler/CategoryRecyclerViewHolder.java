package com.jamhour.android_util.category_recycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jamhour.R;
import com.jamhour.android_util.ImageViewFromUri;
import com.jamhour.data.core.Category;

import java.time.Duration;

public final class CategoryRecyclerViewHolder extends RecyclerView.ViewHolder {

    private final TextView categoryNameTextView;
    private final TextView categoryDurationTextView;
    private final TextView numberOfExercisesTextView;
    private final ImageView categoryImageView;

    public CategoryRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        categoryNameTextView = itemView.findViewById(R.id.categoryNameTextView);
        categoryDurationTextView = itemView.findViewById(R.id.categoryDurationTextView);
        numberOfExercisesTextView = itemView.findViewById(R.id.numOfExercisesTextView);
        categoryImageView = itemView.findViewById(R.id.categoryImageView);
    }

    public void updateViewForCategory(Category category, View.OnClickListener onClickListener) {
        setCategoryName(category.getName());
        setCategoryDuration(category.getDuration());
        setNumberOfExercises(category.getNumberOfExercises());
        ImageViewFromUri.loadImage(category.getImageUri(), categoryImageView);
        setOnItemClickListener(onClickListener);
    }

    private void setCategoryName(String name) {
        categoryNameTextView.setText(name);
    }

    private void setCategoryDuration(Duration duration) {
        categoryDurationTextView.setText(
                "%2dH, %2dM"
                        .formatted(
                                duration.toHours(),
                                duration.toMinutesPart()
                        )
        );
    }

    private void setNumberOfExercises(int numberOfExercises) {
        numberOfExercisesTextView.setText(String.valueOf(numberOfExercises));
    }

    private void setOnItemClickListener(View.OnClickListener listener) {
        itemView.setOnClickListener(listener);
    }

}
