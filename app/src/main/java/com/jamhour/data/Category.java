package com.jamhour.data;

import java.time.Duration;
import java.util.List;

public record Category(
        String name,
        String description,
        Duration duration,
        List<Exercise> exercises
) {
    public int numberOfExercises() {
        return exercises.size();
    }
}
