package com.jamhour.data.core;

import android.os.Parcel;
import android.os.Parcelable;

import com.jamhour.data.impl.ExerciseImpl;

import java.time.Duration;

public interface Exercise extends Parcelable {

    String getName();

    String getImageUri();

    String getTrainingBodyParts();

    Duration getDuration();

    ExerciseLevel getLevel();

    enum ExerciseLevel {
        BEGINNER,
        INTERMEDIATE,
        ADVANCED
    }

    String PARCELABLE_KEY = Exercise.class.getName();

    @Override
    default int describeContents() {
        return 0;
    }

    Creator<Exercise> CREATOR = new Creator<>() {
        @Override
        public Exercise createFromParcel(Parcel in) {
            return new ExerciseImpl(in);
        }

        @Override
        public Exercise[] newArray(int size) {
            return new ExerciseImpl[size];
        }
    };
}
