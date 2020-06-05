package com.lerp.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lerp.pano.ImagesStitch;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityMain extends AppCompatActivity {

    public static String DIR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DIR = getExternalMediaDirs()[0].getPath() + "/360pano/";

        File file = new File(DIR);
        if (!file.exists()) file.mkdirs();

        String name = "sky.jpg";
        copyFileFromAssets(this, name, DIR + name);

        ImagesStitch.init(this);


        findViewById(R.id.btn_vertical).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityMain.this.startActivity(new Intent(ActivityMain.this, VerticalActivity.class));
            }
        });

        findViewById(R.id.btn_3x3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityMain.this.startActivity(new Intent(ActivityMain.this, WideActivity.class));
            }
        });

        findViewById(R.id.btn_360).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityMain.this.startActivity(new Intent(ActivityMain.this, PanoramaActivity.class));
            }
        });

        findViewById(R.id.btn_ste).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityMain.this.startActivity(new Intent(ActivityMain.this, StereographicActivity.class));
            }
        });
    }

    public static File copyFileFromAssets(final Context context, final String name, String path) {
        final File file = new File(path);

        if (!file.exists()) {
            try {
                InputStream inputStream = context.getAssets().open(name);
                OutputStream outputStream = new FileOutputStream(file);

                byte[] buffer = new byte[102400];
                int length;
                while ((length = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, length);
                }
                inputStream.close();
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return file;
    }
}
