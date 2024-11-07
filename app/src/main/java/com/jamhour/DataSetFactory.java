package com.jamhour;

import com.jamhour.data.core.Category;
import com.jamhour.data.core.Exercise;
import com.jamhour.data.impl.CategoryImpl;
import com.jamhour.data.impl.ExerciseImpl;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public final class DataSetFactory {

    private static final Random random = new Random();

    private static final List<String> imageUrls = List.of(
            "https://img.freepik.com/free-vector/young-woman-fitness-dancing-home-illustrated_23-2148886738.jpg?ga=GA1.1.912492376.1685430241&semt=ais_hybrid",
            "https://img.freepik.com/free-vector/training-home-concept_23-2148479238.jpg?ga=GA1.1.912492376.1685430241&semt=ais_hybrid",
            "https://img.freepik.com/free-vector/coach-concept-illustration_114360-28592.jpg?ga=GA1.1.912492376.1685430241&semt=ais_hybrid",
            "https://img.freepik.com/premium-vector/man-doing-yoga-mat-front-laptop_25030-49534.jpg?ga=GA1.1.912492376.1685430241&semt=ais_hybrid",
            "https://img.freepik.com/free-vector/flat-illustration-international-yoga-day-celebration_23-2150371893.jpg?ga=GA1.1.912492376.1685430241&semt=ais_hybrid",
            "https://img.freepik.com/free-vector/man-practicing-dance-fitness-home_23-2148890578.jpg?ga=GA1.1.912492376.1685430241&semt=ais_hybrid",
            "https://img.freepik.com/premium-vector/flat-workout-concept-illustration-idea-with-fitness-exercise-activity-healthy-body-wellness_594665-63.jpg?ga=GA1.1.912492376.1685430241&semt=ais_hybrid",
            "https://img.freepik.com/free-vector/man-practicing-dance-fitness-home_23-2148890578.jpg?ga=GA1.1.912492376.1685430241&semt=ais_hybrid"
    );

    private static final List<Category> categories = List.of(
            new CategoryImpl(
                    "Strength Training",
                    "Build muscle and increase strength",
                    imageUrls.get(random.nextInt(imageUrls.size())),
                    Duration.ofMinutes(60),
                    List.of(
                            new ExerciseImpl("Bench Press", "Chest", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(10), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("Deadlift", "Back", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(15), Exercise.ExerciseLevel.ADVANCED),
                            new ExerciseImpl("Squats", "Legs", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(10), Exercise.ExerciseLevel.INTERMEDIATE)
                    )
            ),
            new CategoryImpl(
                    "Cardio",
                    "Improve cardiovascular endurance",
                    imageUrls.get(random.nextInt(imageUrls.size())),
                    Duration.ofMinutes(45),
                    List.of(
                            new ExerciseImpl("Running", "Full Body", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(30), Exercise.ExerciseLevel.BEGINNER),
                            new ExerciseImpl("Cycling", "Legs", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(20), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("Rowing", "Back and Arms", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(15), Exercise.ExerciseLevel.ADVANCED)
                    )
            ),
            new CategoryImpl(
                    "Flexibility",
                    "Increase flexibility and mobility",
                    imageUrls.get(random.nextInt(imageUrls.size())),
                    Duration.ofMinutes(30),
                    List.of(
                            new ExerciseImpl("Yoga", "Full Body", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(20), Exercise.ExerciseLevel.BEGINNER),
                            new ExerciseImpl("Stretching", "Legs", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(10), Exercise.ExerciseLevel.BEGINNER),
                            new ExerciseImpl("Pilates", "Core", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(15), Exercise.ExerciseLevel.INTERMEDIATE)
                    )
            )
    );


    private DataSetFactory() {
    }

    public static List<Category> getCategories() {
        return categories;
    }

}

