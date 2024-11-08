package com.jamhour.data.impl;

import com.jamhour.data.core.Exercise;
import com.jamhour.data.core.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class UserImpl implements User {

    private final String name;
    private final String email;
    private final String imageUri;
    private final List<Exercise> favoriteExercises = new ArrayList<>();

    public UserImpl(String name, String email, String imageUri, List<Exercise> favoriteExercises) {
        this.name = Objects.requireNonNull(name);
        this.email = Objects.requireNonNull(email);
        this.imageUri = imageUri;
        this.favoriteExercises.addAll(Objects.requireNonNull(favoriteExercises));
    }

    public UserImpl(String name, String email, String imageUri) {
        this(name, email, imageUri, List.of());
    }

    public UserImpl(String name, String email) {
        this(name, email, null, List.of());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Optional<String> getImageUri() {
        return Optional.ofNullable(imageUri);
    }

    @Override
    public List<Exercise> favoriteExercises() {
        return favoriteExercises;
    }

}
