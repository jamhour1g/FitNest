package com.jamhour.data.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface User {

    String getName();

    String getEmail();

    Optional<String> getImageUri();

    default List<Exercise> favoriteExercises() {
        return new ArrayList<>();
    }

    default void addExercise(Exercise exercise) {
        favoriteExercises().add(exercise);
    }

    default void removeExercise(Exercise exercise) {
        favoriteExercises().remove(exercise);
    }

}
