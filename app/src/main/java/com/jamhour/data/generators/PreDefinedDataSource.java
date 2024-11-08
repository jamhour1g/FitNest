package com.jamhour.data.generators;

import static com.jamhour.data.generators.RandomDataSource.IMAGE_URLS;
import static com.jamhour.data.generators.RandomDataSource.RANDOM;

import com.jamhour.data.core.Category;
import com.jamhour.data.core.DataSource;
import com.jamhour.data.core.Exercise;
import com.jamhour.data.impl.CategoryImpl;
import com.jamhour.data.impl.ExerciseImpl;

import java.time.Duration;
import java.util.List;

class PreDefinedDataSource implements DataSource {

    private static final List<Category> categories = getCategoryList();

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    private static List<Category> getCategoryList() {
        return List.of(
                new CategoryImpl(
                        "Strength Training",
                        "Build muscle and increase strength",
                        IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())),
                        Duration.ofMinutes(60),
                        List.of(
                                new ExerciseImpl("Bench Press", "Chest", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(10), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("Deadlift", "Back", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(15), Exercise.ExerciseLevel.ADVANCED),
                                new ExerciseImpl("Squats", "Legs", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(10), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("Overhead Press", "Shoulders", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(10), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("Barbell Rows", "Back", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(12), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("Lunges", "Legs", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(10), Exercise.ExerciseLevel.BEGINNER),
                                new ExerciseImpl("Leg Press", "Legs", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(12), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("Pull-ups", "Back", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(10), Exercise.ExerciseLevel.ADVANCED),
                                new ExerciseImpl("Dips", "Chest and Triceps", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(8), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("Chest Flyes", "Chest", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(10), Exercise.ExerciseLevel.BEGINNER)
                        )
                ),
                new CategoryImpl(
                        "Cardio",
                        "Improve cardiovascular endurance",
                        IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())),
                        Duration.ofMinutes(45),
                        List.of(
                                new ExerciseImpl("Running", "Full Body", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(30), Exercise.ExerciseLevel.BEGINNER),
                                new ExerciseImpl("Cycling", "Legs", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(20), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("Rowing", "Back and Arms", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(15), Exercise.ExerciseLevel.ADVANCED),
                                new ExerciseImpl("Jump Rope", "Full Body", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(10), Exercise.ExerciseLevel.BEGINNER),
                                new ExerciseImpl("Swimming", "Full Body", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(30), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("Boxing", "Full Body", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(20), Exercise.ExerciseLevel.ADVANCED),
                                new ExerciseImpl("Treadmill Intervals", "Full Body", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(15), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("Hiking", "Legs", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(30), Exercise.ExerciseLevel.BEGINNER)
                        )
                ),
                new CategoryImpl(
                        "Flexibility",
                        "Increase flexibility and mobility",
                        IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())),
                        Duration.ofMinutes(30),
                        List.of(
                                new ExerciseImpl("Yoga", "Full Body", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(20), Exercise.ExerciseLevel.BEGINNER),
                                new ExerciseImpl("Stretching", "Legs", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(10), Exercise.ExerciseLevel.BEGINNER),
                                new ExerciseImpl("Pilates", "Core", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(15), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("Hamstring Stretch", "Legs", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.BEGINNER),
                                new ExerciseImpl("Hip Flexor Stretch", "Legs", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.BEGINNER),
                                new ExerciseImpl("Spinal Twists", "Full Body", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.BEGINNER),
                                new ExerciseImpl("Cat-Cow Stretch", "Full Body", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.BEGINNER),
                                new ExerciseImpl("Quad Stretch", "Legs", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(4), Exercise.ExerciseLevel.BEGINNER)
                        )
                ),
                new CategoryImpl(
                        "HIIT",
                        "High-intensity interval training to burn fat",
                        IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())),
                        Duration.ofMinutes(40),
                        List.of(
                                new ExerciseImpl("Burpees", "Full Body", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("Jump Squats", "Legs", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.BEGINNER),
                                new ExerciseImpl("Mountain Climbers", "Core", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("High Knees", "Full Body", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(4), Exercise.ExerciseLevel.BEGINNER),
                                new ExerciseImpl("Push-ups", "Chest", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("Jump Lunges", "Legs", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("Plank Jacks", "Core", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(4), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("Skater Jumps", "Full Body", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.ADVANCED)
                        )
                ),
                new CategoryImpl(
                        "Core Strength",
                        "Strengthen core muscles for stability",
                        IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())),
                        Duration.ofMinutes(30),
                        List.of(
                                new ExerciseImpl("Plank", "Core", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(3), Exercise.ExerciseLevel.BEGINNER),
                                new ExerciseImpl("Russian Twist", "Core", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("Bicycle Crunches", "Core", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(4), Exercise.ExerciseLevel.ADVANCED),
                                new ExerciseImpl("Leg Raises", "Core", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("Flutter Kicks", "Core", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(4), Exercise.ExerciseLevel.BEGINNER),
                                new ExerciseImpl("Side Plank", "Core", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(4), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("Toe Touches", "Core", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.BEGINNER),
                                new ExerciseImpl("V-ups", "Core", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.ADVANCED)
                        )
                ),
                new CategoryImpl(
                        "Balance and Stability",
                        "Improve balance and core stability",
                        IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())),
                        Duration.ofMinutes(25),
                        List.of(
                                new ExerciseImpl("Single-leg Deadlift", "Legs", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(3), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("Stability Ball Pass", "Core", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(4), Exercise.ExerciseLevel.ADVANCED),
                                new ExerciseImpl("Heel-to-Toe Walk", "Full Body", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.BEGINNER),
                                new ExerciseImpl("Bosu Ball Squats", "Legs", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.INTERMEDIATE),
                                new ExerciseImpl("Tai Chi", "Full Body", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(10), Exercise.ExerciseLevel.BEGINNER),
                                new ExerciseImpl("Walking Lunges", "Legs", IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.BEGINNER)
                        )
                )
        );
    }

}
