package com.lerp.demo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.lerp.pano.ImagesStitch;
import com.lerp.view.GLPanorama;
import com.shizhefei.view.largeimage.LargeImageView;
import com.shizhefei.view.largeimage.factory.FileBitmapDecoderFactory;

import androidx.appcompat.app.AppCompatActivity;

import static com.lerp.pano.ImagesStitch.TYPE_PLANE;

public class PanoramaActivity extends AppCompatActivity {

    private FrameLayout mViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.large_view);

        final LargeImageView largeImageView = findViewById(R.id.activity_layout);
        final View progressBar = findViewById(R.id.progress_bar);
        mViewGroup = findViewById(R.id.root_view);

        TextView tvMessage = findViewById(R.id.tv_message);
        tvMessage.setText("合成一张360度全景照片，具体拍摄的方式可以自己设定，不同的相机需要自己调整参数。先竖向拼接，再横向拼接成一张，最后处理成一张2:1的全景照片。" +
                "也可以将所有照片一次性传进去，造成的结果就是拼接时间长和内存溢出。");

        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap[] bitmaps = new Bitmap[2];
                bitmaps[0] = BitmapUtils.getBitmap(PanoramaActivity.this, "medium01.jpg");
                bitmaps[1] = BitmapUtils.getBitmap(PanoramaActivity.this, "medium02.jpg");

                final String image_1 = ActivityMain.DIR + "image_1.jpg";
                ImagesStitch.stitchImagesFromBitmaps(bitmaps, image_1,
                        TYPE_PLANE, ImagesStitch.WAVE_VERT,
                        0.16f, 0.05f, 200, 0.8f,90);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        largeImageView.setImage(new FileBitmapDecoderFactory(image_1));
                    }
                });

                bitmaps[0] = BitmapUtils.getBitmap(PanoramaActivity.this, "medium04.jpg");
                bitmaps[1] = BitmapUtils.getBitmap(PanoramaActivity.this, "medium05.jpg");
                final String image_2 = ActivityMain.DIR + "image_2.jpg";

                ImagesStitch.stitchImagesFromBitmaps(bitmaps, image_2,
                        TYPE_PLANE, ImagesStitch.WAVE_VERT,
                        0.16f, 0.05f, 200, 0.8f,90);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        largeImageView.setImage(new FileBitmapDecoderFactory(image_2));
                    }
                });

                bitmaps[0] = BitmapUtils.getBitmap(PanoramaActivity.this, "medium07.jpg");
                bitmaps[1] = BitmapUtils.getBitmap(PanoramaActivity.this, "medium08.jpg");
                final String image_3 = ActivityMain.DIR + "image_3.jpg";

                ImagesStitch.stitchImagesFromBitmaps(bitmaps, image_3,
                        TYPE_PLANE, ImagesStitch.WAVE_VERT,
                        0.16f, 0.05f, 200, 0.8f,90);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        largeImageView.setImage(new FileBitmapDecoderFactory(image_3));
                    }
                });

                bitmaps[0] = BitmapUtils.getBitmap(PanoramaActivity.this, "medium10.jpg");
                bitmaps[1] = BitmapUtils.getBitmap(PanoramaActivity.this, "medium11.jpg");
                final String image_4 = ActivityMain.DIR + "image_4.jpg";

                ImagesStitch.stitchImagesFromBitmaps(bitmaps, image_4,
                        TYPE_PLANE, ImagesStitch.WAVE_VERT,
                        0.16f, 0.05f, 200, 0.8f,90);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        largeImageView.setImage(new FileBitmapDecoderFactory(image_4));
                    }
                });

                bitmaps[0] = BitmapUtils.getBitmap(PanoramaActivity.this, "medium13.jpg");
                bitmaps[1] = BitmapUtils.getBitmap(PanoramaActivity.this, "medium14.jpg");
                final String image_5 = ActivityMain.DIR + "image_5.jpg";

                ImagesStitch.stitchImagesFromBitmaps(bitmaps, image_5,
                        TYPE_PLANE, ImagesStitch.WAVE_VERT,
                        0.16f, 0.05f, 200, 0.8f,90);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        largeImageView.setImage(new FileBitmapDecoderFactory(image_5));
                    }
                });

                bitmaps[0] = BitmapUtils.getBitmap(PanoramaActivity.this, "medium16.jpg");
                bitmaps[1] = BitmapUtils.getBitmap(PanoramaActivity.this, "medium17.jpg");
                final String image_6 = ActivityMain.DIR + "image_6.jpg";

                ImagesStitch.stitchImagesFromBitmaps(bitmaps, image_6,
                        TYPE_PLANE, ImagesStitch.WAVE_VERT,
                        0.16f, 0.05f, 200, 0.8f,90);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        largeImageView.setImage(new FileBitmapDecoderFactory(image_6));
                    }
                });

                bitmaps = new Bitmap[12];
                bitmaps[0] = BitmapFactory.decodeFile(image_1);
                bitmaps[1] = BitmapFactory.decodeFile(image_2);
                bitmaps[2] = BitmapFactory.decodeFile(image_3);
                bitmaps[3] = BitmapFactory.decodeFile(image_4);
                bitmaps[4] = BitmapFactory.decodeFile(image_5);
                bitmaps[5] = BitmapFactory.decodeFile(image_6);
                bitmaps[6] = BitmapUtils.getBitmap(PanoramaActivity.this, "medium03.jpg");
                bitmaps[7] = BitmapUtils.getBitmap(PanoramaActivity.this, "medium06.jpg");
                bitmaps[8] = BitmapUtils.getBitmap(PanoramaActivity.this, "medium09.jpg");
                bitmaps[9] = BitmapUtils.getBitmap(PanoramaActivity.this, "medium12.jpg");
                bitmaps[10] = BitmapUtils.getBitmap(PanoramaActivity.this, "medium15.jpg");
                bitmaps[11] = BitmapUtils.getBitmap(PanoramaActivity.this, "medium18.jpg");

                final String result = ActivityMain.DIR + "result.jpg";
                ImagesStitch.stitchImagesFromBitmaps(bitmaps, result,
                        ImagesStitch.TYPE_SPHERICAL, ImagesStitch.WAVE_DEFAULT,
                        0.005f, 0f, 50, 0.6f,0);

                final String result360 = ActivityMain.DIR + "result360.jpg";
                final String sky = ActivityMain.DIR + "sky.jpg";

                ImagesStitch.replaceSky(result, result360, sky);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);

                        Bitmap bitmap = BitmapFactory.decodeFile(result360);
//                        largeImageView.setImage(bitmap);
                        GLPanorama glPanorama = new GLPanorama(PanoramaActivity.this);
                        glPanorama.setGLBitmap(bitmap);
                        mViewGroup.addView(glPanorama);
                    }
                });
            }
        }).start();

    }
}
