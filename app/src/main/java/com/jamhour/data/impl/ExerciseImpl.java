package com.jamhour.data.impl;

import android.os.Parcel;

import androidx.annotation.NonNull;

import com.jamhour.data.core.Exercise;

import java.time.Duration;

public record ExerciseImpl(
        String name,
        String trainingBodyPart,
        String imageUri,
        Duration duration,
        ExerciseLevel level
) implements Exercise {

    public static final String PARCELABLE_KEY = ExerciseImpl.class.getName();

    public ExerciseImpl(Parcel in) {
        this(
                in.readString(),
                in.readString(),
                in.readString(),
                Duration.parse(in.readString()),
                ExerciseLevel.valueOf(in.readString())
        );
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(trainingBodyPart);
        dest.writeString(imageUri);
        dest.writeString(duration.toString());
        dest.writeString(level.toString());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getImageUri() {
        return imageUri;
    }

    @Override
    public String getTrainingBodyParts() {
        return trainingBodyPart;
    }

    @Override
    public Duration getDuration() {
        return duration;
    }

    @Override
    public Exercise.ExerciseLevel getLevel() {
        return level;
    }

}
