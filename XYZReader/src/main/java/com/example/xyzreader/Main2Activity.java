package com.example.xyzreader;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.xyzreader.data.ArticleLoader;
import com.example.xyzreader.ui.ArticleListActivity;
import com.example.xyzreader.ui.EmptyActivity;
import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {
    private String imageSrc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView img = (ImageView) findViewById(R.id.main2_image);

        imageSrc = "https://static.pexels.com/photos/33109/fall-autumn-red-season.jpg";
        Picasso.with(this).load(imageSrc).into(img);
    }

    public void toDetail(View view){
        ImageView img = (ImageView) findViewById(R.id.main2_image);

        Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this,
                img, img.getTransitionName()
        ).toBundle();

        Intent intent = new Intent(this, EmptyActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, imageSrc);
        startActivity(intent, bundle);
    }
}
