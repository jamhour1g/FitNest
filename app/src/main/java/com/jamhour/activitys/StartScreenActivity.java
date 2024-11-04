package com.jamhour.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.jamhour.R;

public class StartScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen_activity);

        ImageView nextButton = findViewById(R.id.next_screen_icon);
        nextButton.setOnClickListener(v ->
                startActivity(new Intent(this, HomeActivity.class))
        );
    }
}