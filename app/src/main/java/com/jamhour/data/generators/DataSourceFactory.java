package com.jamhour.data.generators;

import com.jamhour.data.core.Category;
import com.jamhour.data.core.DataSource;

import java.util.List;

public final class DataSourceFactory {

    private static final DataSource DEFAULT_DATA_SOURCE = getPreDefinedDataSource();

    private DataSourceFactory() {
    }

    public static List<Category> getCategories() {
        return getDefaultDataSource().getCategories();
    }

    public static DataSource getDefaultDataSource() {
        return DEFAULT_DATA_SOURCE;
    }

    public static DataSource getPreDefinedDataSource() {
        return new PreDefinedDataSource();
    }

    public static DataSource getRandomDataSource(int numberOfCategories, int numberOfExercises) {
        return new RandomDataSource(numberOfCategories, numberOfExercises);
    }

}

