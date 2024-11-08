package com.jamhour.data.generators;

import com.jamhour.data.core.Category;
import com.jamhour.data.core.DataSource;
import com.jamhour.data.core.Exercise;
import com.jamhour.data.impl.CategoryImpl;
import com.jamhour.data.impl.ExerciseImpl;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Stream;

class RandomDataSource implements DataSource {

    static final Random RANDOM = new Random();

    static final List<String> BODY_PARTS = Arrays.asList(
            "Biceps", "Triceps", "Forearms", "Upper Chest", "Lower Chest",
            "Middle Chest", "Upper Back", "Lower Back", "Mid Back",
            "Sides of Abs", "Abs", "Glutes", "Hamstrings",
            "Thighs", "Calves", "Inner Thighs", "Outer Thighs",
            "Hip Flexors", "Neck", "Wrists", "Ankles",
            "Back of Shoulders", "Front of Shoulders", "Side of Shoulders",
            "Muscles Under Ribs", "Lower Core",
            "Lower Spine", "Shins", "Upper Ankles", "Shoulder Stabilizers"
    );


    static final List<String> IMAGE_URLS = List.of(
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

    private final int numberOfCategories;
    private final int numberOfExercises;

    public RandomDataSource(int numberOfCategories, int numberOfExercises) {
        this.numberOfCategories = numberOfCategories;
        this.numberOfExercises = numberOfExercises;
    }

    @Override
    public List<Category> getCategories() {
        return RandomCategory.createCategoriesList(numberOfCategories, numberOfExercises);
    }

    private static class RandomExercise {
        private static final List<String> EXERCISE_NAMES = Arrays.asList(
                "Bench Press", "Deadlift", "Squats", "Overhead Press", "Barbell Rows", "Lunges", "Leg Press",
                "Pull-ups", "Dips", "Chest Flyes", "Running", "Cycling", "Rowing", "Jump Rope", "Swimming",
                "Boxing", "Treadmill Intervals", "Hiking", "Yoga", "Stretching", "Pilates", "Hamstring Stretch",
                "Hip Flexor Stretch", "Spinal Twists", "Cat-Cow Stretch", "Quad Stretch", "Burpees", "Jump Squats",
                "Mountain Climbers", "High Knees", "Push-ups", "Jump Lunges", "Plank Jacks", "Skater Jumps", "Plank",
                "Russian Twist", "Bicycle Crunches", "Leg Raises", "Flutter Kicks", "Side Plank", "Toe Touches",
                "V-ups", "Single-leg Deadlift", "Stability Ball Pass", "Heel-to-Toe Walk", "Bosu Ball Squats",
                "Tai Chi", "Walking Lunges"
        );

        private static Exercise createExercise() {

            int numOfParts = RANDOM.nextInt(BODY_PARTS.size());
            StringJoiner joiner = new StringJoiner(", ");
            for (int i = 0; i < numOfParts; i++) {
                joiner.add(BODY_PARTS.get(RANDOM.nextInt(BODY_PARTS.size())));
            }
            String parts = joiner.toString();

            return new ExerciseImpl(
                    EXERCISE_NAMES.get(numOfParts),
                    parts,
                    IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())),
                    Duration.ofMinutes(RANDOM.nextInt(60)),
                    Exercise.ExerciseLevel.values()[RANDOM.nextInt(Exercise.ExerciseLevel.values().length)]
            );
        }

        public static List<Exercise> createExercisesList(int count) {
            return Stream.generate(RandomExercise::createExercise)
                    .limit(count)
                    .toList();
        }
    }

    private static class RandomCategory {

        static final List<String> CATEGORY_NAMES = List.of(
                "Strength Training",
                "Cardio Blast",
                "Flexibility and Mobility",
                "Core Conditioning",
                "HIIT (High-Intensity Interval Training)",
                "Endurance Training",
                "Balance and Stability",
                "Full Body Workout",
                "Upper Body Strength",
                "Lower Body Power",
                "Yoga and Mindfulness",
                "Speed and Agility",
                "Functional Training",
                "Bodyweight Exercises",
                "Powerlifting",
                "Plyometrics",
                "CrossFit",
                "Martial Arts Training",
                "Low-Impact Cardio",
                "Aerobic Conditioning",
                "Circuit Training",
                "Recovery and Stretching",
                "Resistance Band Exercises",
                "Olympic Lifting",
                "Dance Fitness",
                "Sports-Specific Training",
                "Barre Workouts",
                "Posture and Alignment",
                "Rehabilitation and Injury Prevention",
                "Senior Fitness",
                "Prenatal and Postnatal Training",
                "Boot Camp",
                "Metabolic Conditioning",
                "Obstacle Course Training",
                "Swim Training"
        );

        private static Category createCategory(int numOfExercises) {
            return new CategoryImpl(
                    CATEGORY_NAMES.get(RANDOM.nextInt(CATEGORY_NAMES.size())),
                    BODY_PARTS.get(RANDOM.nextInt(BODY_PARTS.size())),
                    IMAGE_URLS.get(RANDOM.nextInt(IMAGE_URLS.size())),
                    Duration.ofMinutes(RANDOM.nextInt(60)),
                    RandomExercise.createExercisesList(numOfExercises)
            );
        }

        public static List<Category> createCategoriesList(int numberOfCategories, int numberOfExercises) {
            return Stream.generate(() -> RandomCategory.createCategory(numberOfExercises))
                    .limit(numberOfCategories)
                    .toList();
        }

    }

}
