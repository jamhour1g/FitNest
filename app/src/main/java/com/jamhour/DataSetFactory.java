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
            "https://img.freepik.com/free-vector/workout-concept-illustration_114360-1065.jpg?ga=GA1.1.912492376.1685430241&semt=ais_hybrid",
            "https://img.freepik.com/free-vector/flat-illustration-international-yoga-day-celebration_23-2150371893.jpg?ga=GA1.1.912492376.1685430241&semt=ais_hybrid",
            "https://img.freepik.com/free-vector/man-practicing-dance-fitness-home_23-2148890578.jpg?ga=GA1.1.912492376.1685430241&semt=ais_hybrid",
            "https://img.freepik.com/free-vector/workout-concept-illustration_114360-28397.jpg?ga=GA1.1.912492376.1685430241&semt=ais_hybrid",
            "https://img.freepik.com/free-vector/man-practicing-dance-fitness-home_23-2148890578.jpg?ga=GA1.1.912492376.1685430241&semt=ais_hybrid",
            "https://img.freepik.com/free-vector/male-friends-exercising-gym-together_74855-7600.jpg?ga=GA1.1.912492376.1685430241&semt=ais_hybrid",
            "https://img.freepik.com/free-vector/man-weight-lifting-with-sports-icons_24877-51360.jpg?ga=GA1.1.912492376.1685430241&semt=ais_hybrid"
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
                            new ExerciseImpl("Squats", "Legs", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(10), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("Overhead Press", "Shoulders", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(10), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("Barbell Rows", "Back", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(12), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("Lunges", "Legs", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(10), Exercise.ExerciseLevel.BEGINNER),
                            new ExerciseImpl("Leg Press", "Legs", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(12), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("Pull-ups", "Back", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(10), Exercise.ExerciseLevel.ADVANCED),
                            new ExerciseImpl("Dips", "Chest and Triceps", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(8), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("Chest Flyes", "Chest", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(10), Exercise.ExerciseLevel.BEGINNER)
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
                            new ExerciseImpl("Rowing", "Back and Arms", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(15), Exercise.ExerciseLevel.ADVANCED),
                            new ExerciseImpl("Jump Rope", "Full Body", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(10), Exercise.ExerciseLevel.BEGINNER),
                            new ExerciseImpl("Swimming", "Full Body", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(30), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("Boxing", "Full Body", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(20), Exercise.ExerciseLevel.ADVANCED),
                            new ExerciseImpl("Treadmill Intervals", "Full Body", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(15), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("Hiking", "Legs", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(30), Exercise.ExerciseLevel.BEGINNER)
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
                            new ExerciseImpl("Pilates", "Core", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(15), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("Hamstring Stretch", "Legs", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.BEGINNER),
                            new ExerciseImpl("Hip Flexor Stretch", "Legs", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.BEGINNER),
                            new ExerciseImpl("Spinal Twists", "Full Body", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.BEGINNER),
                            new ExerciseImpl("Cat-Cow Stretch", "Full Body", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.BEGINNER),
                            new ExerciseImpl("Quad Stretch", "Legs", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(4), Exercise.ExerciseLevel.BEGINNER)
                    )
            ),
            new CategoryImpl(
                    "HIIT",
                    "High-intensity interval training to burn fat",
                    imageUrls.get(random.nextInt(imageUrls.size())),
                    Duration.ofMinutes(40),
                    List.of(
                            new ExerciseImpl("Burpees", "Full Body", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("Jump Squats", "Legs", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.BEGINNER),
                            new ExerciseImpl("Mountain Climbers", "Core", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("High Knees", "Full Body", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(4), Exercise.ExerciseLevel.BEGINNER),
                            new ExerciseImpl("Push-ups", "Chest", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("Jump Lunges", "Legs", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("Plank Jacks", "Core", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(4), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("Skater Jumps", "Full Body", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.ADVANCED)
                    )
            ),
            new CategoryImpl(
                    "Core Strength",
                    "Strengthen core muscles for stability",
                    imageUrls.get(random.nextInt(imageUrls.size())),
                    Duration.ofMinutes(30),
                    List.of(
                            new ExerciseImpl("Plank", "Core", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(3), Exercise.ExerciseLevel.BEGINNER),
                            new ExerciseImpl("Russian Twist", "Core", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("Bicycle Crunches", "Core", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(4), Exercise.ExerciseLevel.ADVANCED),
                            new ExerciseImpl("Leg Raises", "Core", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("Flutter Kicks", "Core", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(4), Exercise.ExerciseLevel.BEGINNER),
                            new ExerciseImpl("Side Plank", "Core", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(4), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("Toe Touches", "Core", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.BEGINNER),
                            new ExerciseImpl("V-ups", "Core", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.ADVANCED)
                    )
            ),
            new CategoryImpl(
                    "Balance and Stability",
                    "Improve balance and core stability",
                    imageUrls.get(random.nextInt(imageUrls.size())),
                    Duration.ofMinutes(25),
                    List.of(
                            new ExerciseImpl("Single-leg Deadlift", "Legs", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(3), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("Stability Ball Pass", "Core", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(4), Exercise.ExerciseLevel.ADVANCED),
                            new ExerciseImpl("Heel-to-Toe Walk", "Full Body", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.BEGINNER),
                            new ExerciseImpl("Bosu Ball Squats", "Legs", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.INTERMEDIATE),
                            new ExerciseImpl("Tai Chi", "Full Body", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(10), Exercise.ExerciseLevel.BEGINNER),
                            new ExerciseImpl("Walking Lunges", "Legs", imageUrls.get(random.nextInt(imageUrls.size())), Duration.ofMinutes(5), Exercise.ExerciseLevel.BEGINNER)
                    )
            )
    );


    private DataSetFactory() {
    }

    public static List<Category> getCategories() {
        return categories;
    }


}

