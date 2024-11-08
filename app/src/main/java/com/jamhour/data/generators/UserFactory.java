package com.jamhour.data.generators;

import com.jamhour.data.core.User;
import com.jamhour.data.impl.UserImpl;

public final class UserFactory {

    private static final User DEFAULT_USER = new UserImpl(
            "jamhour1g",
            "jamhour1g@example.org",
            "https://github.com/jamhour1g.png"
    );

    private UserFactory() {
    }

    public static User getDefaultUser() {
        return DEFAULT_USER;
    }

}
