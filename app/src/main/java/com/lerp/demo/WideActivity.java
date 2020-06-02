package com.lerp.demo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lerp.pano.ImagesStitch;
import com.shizhefei.view.largeimage.LargeImageView;
import com.shizhefei.view.largeimage.factory.FileBitmapDecoderFactory;

import androidx.appcompat.app.AppCompatActivity;

public class WideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.large_view);

        final LargeImageView largeImageView = findViewById(R.id.activity_layout);
        final View progressBar = findViewById(R.id.progress_bar);
        TextView tvMessage = findViewById(R.id.tv_message);
        tvMessage.setText("合成一张2*3的照片");

        new Thread(new Runnable() {
            @Override
            public void run() {
                //示例图片便宜比较大，这里用6张就够了
                Bitmap[] bitmaps = new Bitmap[6];
                bitmaps[0] = BitmapUtils.getBitmap(WideActivity.this, "medium04.jpg");
                bitmaps[1] = BitmapUtils.getBitmap(WideActivity.this, "medium05.jpg");
                bitmaps[2] = BitmapUtils.getBitmap(WideActivity.this, "medium07.jpg");
                bitmaps[3] = BitmapUtils.getBitmap(WideActivity.this, "medium08.jpg");
                bitmaps[4] = BitmapUtils.getBitmap(WideActivity.this, "medium10.jpg");
                bitmaps[5] = BitmapUtils.getBitmap(WideActivity.this, "medium11.jpg");

                final String result = ActivityMain.DIR + "wide.jpg";
                int[] ints = ImagesStitch.stitchImagesFromBitmaps(bitmaps, result,
                        ImagesStitch.TYPE_SPHERICAL, ImagesStitch.WAVE_DEFAULT,
                        0.1f, 0.1f, 50, 1f, 0);

                if (ints[0] == 0 && !WideActivity.this.isDestroyed()) {
                    WideActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.GONE);
                            largeImageView.setImage(new FileBitmapDecoderFactory(result));
                        }
                    });
                }
            }
        }).start();

    }
}
