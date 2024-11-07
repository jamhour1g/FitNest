package com.jamhour.data.core;

import android.os.Parcel;
import android.os.Parcelable;

import com.jamhour.data.impl.CategoryImpl;

import java.time.Duration;
import java.util.List;

public interface Category extends Parcelable {

    String getName();

    String getDescription();

    String getImageUri();

    Duration getDuration();

    List<Exercise> getExercises();

    String PARCELABLE_KEY = Category.class.getName();

    default int getNumberOfExercises() {
        return getExercises().size();
    }

    @Override
    default int describeContents() {
        return 0;
    }

    Creator<Category> CREATOR = new Creator<>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new CategoryImpl(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new CategoryImpl[size];
        }
    };
}
