package com.jamhour.data.core;

import java.util.List;

public interface DataSource {

    List<Category> getCategories();

    default List<Exercise> getExercises() {
        return getCategories().stream()
                .flatMap(category -> category.getExercises().stream())
                .toList();
    }
}
