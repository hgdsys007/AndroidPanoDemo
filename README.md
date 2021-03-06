## 主要特点：
1. 合成照片质量可自由设置，可以做到分辨率无损失合成
2. 不需要电脑端后期处理，全部合成动作都在手机上完成
3. SDK集成步骤简单，体积较小，最后体积大约增加10M左右
4. 不需要联网，完全是本地化合成

## 集成步骤：
1. 将pano Module导入到你的项目
2. 在application里添加SDK初始化代码：
```
    public void onCreate() {
        super.onCreate();
        
        ImagesStitch.init(this);
    }
```
3. 将你的应用名称修改成"360PanoDemo"进行测试
4. 混淆代码 -keep public class com.lerp.pano.ImagesStitch { *; }

## API使用说明
```
    /**
     * @param path        输入图片绝对路径
     * @param outPath     输出图片绝对路径
     * @param panoType    全景照片类型，0球面，1圆柱，2球形,3直线
     * @param correction  波段修正，水平或垂直，拼接竖直照片的时候需要设置成垂直修正
     * @param widthRatio  拼接后的照片四周会有黑边，这个参数用来消除宽度上的黑边，
     *                    表示宽度最多裁掉的比例，范围0~1，为0表示宽度不需要裁剪
     * @param heightRatio 拼接后的照片四周会有黑边，这个参数用来消除高度上的黑边，
     *                    高度最多裁掉的比例,范围0~1，为0表示高度不需要裁剪
     * @param length      裁剪系数，和widthRatio和HeightRatio一起使用，
     *                    值越小裁剪的越多，参考值50，单位是pixel
     * @param scale       压缩系数，是否需要压缩照片质量，范围0~1，为1时表示以原画质进行合成，
     *                    当内存不够或者拼接时间过长的时候，请适当调小该参数
     * @param rotate      拼接之后的图片旋转角度，0,90,180，270,
     * @return 返回长度为3的字节数组
     * [0]合成结果状态码
     * [1]合成后宽度
     * [2]合成后的高度
     */
    public native static int[] stitchImages(String path[], String outPath,
                                            int panoType, int correction,
                                            float widthRatio, float heightRatio,
                                            int length, float scale, int rotate);
```

## 合成示例
- 原始照片
![](/result/images.jpg)

- 合成广角照片
![](/result/2x3.jpg)

- 合成球形照片
![](/result/stereo.jpg)

- 合成360全景
![](/result/panorama.jpg)

## Demo下载
[点击下载](https://www.pgyer.com/BQr0)，密码:123456

## 联系我
- 电话/微信 17512006887
- QQ 495572997
