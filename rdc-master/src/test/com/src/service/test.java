package com.src.service;

import com.rdc.dao.IpDao;
import com.rdc.entity.IpMap;
import com.rdc.entity.User;
import com.rdc.exception.DataTooLongException;
import com.rdc.service.UserService;
import com.src.test.AbstractTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import java.awt.image.*;
import java.io.IOException;
import java.util.Iterator;

@Transactional
public class test extends AbstractTest {

    @Autowired
    private UserService userService;
    @Autowired
    private IpDao ipDao;

    private Integer targetLength = 100;
    private Integer targetWidth = 100;
    private Integer circleR = 2;
    private Integer r1 = 2;

    @Test
    @Rollback(false)
    public void test1() throws DataTooLongException {
//        User user = new User();
//        user.setName("1213");
//        user.setNumber("3117004876");
//        user.setSex("男");
//        user.setMajorAndClass("一年级");
//        user.setPhone("15521157238");
//        System.out.println(userService.saveUser(user));
        IpMap ipMap = ipDao.getIpMap("1 or 1=1");
        System.out.println(ipMap.getId());

//        User user = new User();
//        user.setName("一二三四五六七八九十一二三四五六七八九十");
//        user.setNumber("3117004876");
//        user.setSex("男");
//        user.setMajorAndClass("一年级");
//        user.setPhone("15521157238");
//        user.setOrganize("前端");
//        user.setShortNumber("1234567890123456789012345678901");
//        userService.saveUser(user);
    }

//    private int[][] getBlockData() {
//        int[][] data = new int[targetLength][targetWidth];
//        double x2 = targetLength-circleR-2;
//        //随机生成圆的位置
//        double h1 = circleR + Math.random() * (targetWidth-3*circleR-r1);
//        double po = circleR*circleR;
//
//        double xbegin = targetLength-circleR-r1;
//        double ybegin = targetWidth-circleR-r1;
//
//        for (int i = 0; i < targetLength; i++) {
//            for (int j = 0; j < targetWidth; j++) {
//                //右边○
//                double d3 = Math.pow(i - x2,2) + Math.pow(j - h1,2);
//
//                if (d1 <= po
//                        || (j >= ybegin && d2 >= po)
//                        || (i >= xbegin && d3 >= po)
//                        ) {
//                    data[i][j] = 0;
//
//                }  else {
//                    data[i][j] = 1;
//                }
//            }
//        }
//        return data;
//    }
//
//    private void cutByTemplate(BufferedImage oriImage, BufferedImage targetImage, int[][] templateImage, int x,
//                               int y){
//        for (int i = 0; i < targetLength; i++) {
//            for (int j = 0; j < targetWidth; j++) {
//                int rgb = templateImage[i][j];
//                // 原图中对应位置变色处理
//
//                int rgb_ori = oriImage.getRGB(x + i, y + j);
//
//                if (rgb == 1) {
//                    //抠图上复制对应颜色值
//                    targetImage.setRGB(i, y + j, rgb_ori);
//                    int r = (0xff & rgb_ori);
//                    int g = (0xff & (rgb_ori >> 8));
//                    int b = (0xff & (rgb_ori >> 16)));
//                    rgb_ori = r + (g << 8) + (b << 16) + (200 << 24);
//                    //原图对应位置颜色变化
//                    oriImage.setRGB(x + i, y + j, rgb_ori);
//                }
//            }
//        }
//    }
//
//    public static ConvolveOp getGaussianBlurFilter(int radius,
//                                                   boolean horizontal) {
//        if (radius < 1) {
//            throw new IllegalArgumentException("Radius must be >= 1");
//        }
//
//        int size = radius * 2 + 1;
//        float[] data = new float[size];
//
//        float sigma = radius / 3.0f;
//        float twoSigmaSquare = 2.0f * sigma * sigma;
//        float sigmaRoot = (float) Math.sqrt(twoSigmaSquare * Math.PI);
//        float total = 0.0f;
//
//        for (int i = -radius; i <= radius; i++) {
//            float distance = i * i;
//            int index = i + radius;
//            data[index] = (float) Math.exp(-distance / twoSigmaSquare) / sigmaRoot;
//            total += data[index];
//        }
//
//        for (int i = 0; i < data.length; i++) {
//            data[i] /= total;
//        }
//
//        Kernel kernel = null;
//        if (horizontal) {
//            kernel = new Kernel(size, 1, data);
//        } else {
//            kernel = new Kernel(1, size, data);
//        }
//        return new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
//    }
//
//    public static void simpleBlur(BufferedImage src,BufferedImage dest) {
//        BufferedImageOp op = getGaussianBlurFilter(2,false);
//        op.filter(src, dest);
//    }
//
//    public static byte[] fromBufferedImage2(BufferedImage img,String imagType) throws IOException {
//        bos.reset();
//        // 得到指定Format图片的writer
//        Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName(imagType);
//        ImageWriter writer = (ImageWriter) iter.next();
//
//        // 得到指定writer的输出参数设置(ImageWriteParam )
//        ImageWriteParam iwp = writer.getDefaultWriteParam();
//        iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT); // 设置可否压缩
//        iwp.setCompressionQuality(1f); // 设置压缩质量参数
//
//        iwp.setProgressiveMode(ImageWriteParam.MODE_DISABLED);
//
//        ColorModel colorModel = ColorModel.getRGBdefault();
//        // 指定压缩时使用的色彩模式
//        iwp.setDestinationType(new javax.imageio.ImageTypeSpecifier(colorModel,
//                colorModel.createCompatibleSampleModel(16, 16)));
//
//        writer.setOutput(ImageIO
//                .createImageOutputStream(bos));
//        IIOImage iIamge = new IIOImage(img, null, null);
//        writer.write(null, iIamge, iwp);
//
//        byte[] d = bos.toByteArray();
//        return d;
//    }
}
