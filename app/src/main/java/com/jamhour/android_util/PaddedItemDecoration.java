package com.jamhour.android_util;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PaddedItemDecoration extends RecyclerView.ItemDecoration {

    private final int space;

    public PaddedItemDecoration(int padding) {
        this.space = padding;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect,
                               @NonNull View view,
                               @NonNull RecyclerView parent,
                               @NonNull RecyclerView.State state
    ) {

        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = space;
        }

        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;

    }
}