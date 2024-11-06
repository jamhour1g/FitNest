package com.jamhour.data;

import java.time.Duration;

public record Exercise(
        String name,
        String trainingBodyPart,
        Duration duration,
        ExerciseLevel level
) {

    public enum ExerciseLevel {
        BEGINNER,
        INTERMEDIATE,
        ADVANCED
    }
}
