package com.lerp.pano;

import android.content.Context;
import android.graphics.Bitmap;

public class ImagesStitch {
    public final static int OK = 0;
    public final static int ERR_NEED_MORE_IMGS = 1;
    public final static int ERR_HOMOGRAPHY_EST_FAIL = 2;
    public final static int ERR_CAMERA_PARAMS_ADJUST_FAIL = 3;

    public final static int TYPE_SPHERICAL = 0;
    public final static int TYPE_CYLINDRICAL = 1;
    public final static int TYPE_STEREOGRAPHIC = 2;
    public final static int TYPE_LINEAR = 3;

    public final static int CORRECTION_DEFAULT = 0;
    public final static int CORRECTION_HORI = 1;
    public final static int CORRECTION_VERT = 2;

    static {
        System.loadLibrary("libstitch");
    }

    public native static boolean init(Context context);

    /**
     * @param path           输入图片绝对路径
     * @param outPath        输出图片绝对路径
     * @param panoType       全景照片类型，0球面，1圆柱，2小行星,3直线
     * @param correction     波段修正，水平或垂直，拼接竖直照片的时候需要设置成垂直修正
     * @param widthRatio     拼接后的照片四周会有黑边，这个参数用来消除宽度上的黑边，
     *                       表示宽度最多裁掉的比例，范围0~1，为0表示宽度不需要裁剪
     * @param heightRatio    拼接后的照片四周会有黑边，这个参数用来消除高度上的黑边，
     *                       高度最多裁掉的比例,范围0~1，为0表示高度不需要裁剪
     * @param length         裁剪系数，和widthRatio和HeightRatio一起使用，
     *                       值越小裁剪的越多，参考值300，单位是pixel
     * @param scale          压缩系数，是否需要压缩照片质量，范围0~1，为1时表示以原画质进行合成，
     *                       当内存不够或者拼接时间过长的时候，请适当调小该参数
     * @return 返回长度为3的字节数组
     * [0]合成结果状态码
     * [1]合成后宽度
     * [2]合成后的高度
     */
    public native static int[] stitchImages(String path[], String outPath,
                                            int panoType, int correction,
                                            float widthRatio, float heightRatio,
                                            int length, float scale);

    public native static int[] stitchImagesFromBitmaps(Bitmap bitmaps[], String outPath,
                                                       int panoType, int correction,
                                                       float widthRatio, float heightRatio,
                                                       int length, float scale);

    /**
     * 360全景照片都是2:1的，但是stitchImages拼接之后并不满足2:1，
     * 这个函数可以将合成好的360全景照片扩充成2:1，即所谓的“补天”
     *
     * @param input  输入图片绝对路径
     * @param output 输出图片绝对路径
     * @param topRatio 合成之后的图片顶部会有一定黑块，这个参数表示在去除顶部黑块的时候，最多裁剪的比例，建议使用默认值0.2
     * @param mode   顶部像素扩充的方式：
     *               BORDER_DEFAULT    = 0, 智能模式，根据天气自动补充一个纯色
     *               BORDER_REPLICATE   = 1, //!< `aaaaaa|abcdefgh|hhhhhhh`
     *               BORDER_REFLECT     = 2, //!< `fedcba|abcdefgh|hgfedcb`
     *               BORDER_WRAP        = 3, //!< `cdefgh|abcdefgh|abcdefg`
     *               BORDER_REFLECT_101 = 4, //!< `gfedcb|abcdefgh|gfedcba`
     *               BORDER_TRANSPARENT = 5, //!< `uvwxyz|absdefgh|ijklmno`
     */
    public native static void toPano360(String input, String output, float topRatio, int mode);
}
