package com.jamhour.data.impl;

import android.os.Parcel;

import com.jamhour.data.core.Category;
import com.jamhour.data.core.Exercise;

import java.time.Duration;
import java.util.List;

public record CategoryImpl(
        String name,
        String description,
        String imageUri,
        Duration duration,
        List<Exercise> exercises
) implements Category {

    public CategoryImpl(Parcel in) {
        this(
                in.readString(),
                in.readString(),
                in.readString(),
                Duration.parse(in.readString()),
                in.createTypedArrayList(Exercise.CREATOR)
        );
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(imageUri);
        dest.writeString(duration.toString());
        dest.writeTypedList(exercises);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getImageUri() {
        return imageUri;
    }

    @Override
    public Duration getDuration() {
        return duration;
    }

    @Override
    public List<Exercise> getExercises() {
        return exercises;
    }
}
