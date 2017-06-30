package com.example.xyzreader.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.xyzreader.R;
import com.squareup.picasso.Picasso;

public class EmptyActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        imageView = (ImageView)findViewById(R.id.large_image);

        Intent intent = getIntent();
        if ((intent != null) && (intent.hasExtra(Intent.EXTRA_TEXT))) {
            String imageURL = intent.getStringExtra(Intent.EXTRA_TEXT);
            Picasso.with(this).load(imageURL).into(imageView);
        }
    }

    public void goback(View view){
        finishAfterTransition();
    }
}
