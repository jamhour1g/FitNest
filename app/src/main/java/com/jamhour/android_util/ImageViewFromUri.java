package com.jamhour.android_util;

import static android.os.Looper.getMainLooper;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public final class ImageViewFromUri {

    private ImageViewFromUri() {
    }

    public static void loadImage(String uri, ImageView imageViewToUpdate) {
        Handler handler = new Handler(getMainLooper());

        CompletableFuture.supplyAsync(
                () -> {
                    int checkSelfPermission = ContextCompat.checkSelfPermission(
                            imageViewToUpdate.getContext(),
                            Manifest.permission.INTERNET
                    );

                    if (checkSelfPermission == PackageManager.PERMISSION_GRANTED) {
                        try (var imageInputStream = new URI(uri).toURL().openStream()) {
                            return Optional.of(BitmapFactory.decodeStream(imageInputStream));
                        } catch (URISyntaxException | IOException e) {
                            return Optional.<Bitmap>empty();
                        }
                    }
                    return Optional.<Bitmap>empty();
                }
        ).whenComplete((image, throwable) -> {
            if (throwable != null) {
                Log.e("SEVERE", "loadImage: failed loading image from imageUri: " + uri + "asynchronously", throwable);
            } else {
                handler.post(() ->
                        image.ifPresentOrElse(
                                imageViewToUpdate::setImageBitmap,
                                () -> Log.e("SEVERE", "loadImage: failed loading image from imageUri: " + uri + "asynchronously")
                        )
                );
            }
        });
    }
}
