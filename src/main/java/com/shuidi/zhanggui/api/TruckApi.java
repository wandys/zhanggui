package com.shuidi.zhanggui.api;

import com.shuidi.zhanggui.api.resource.TruckBaseResource;
import com.shuidi.zhanggui.service.bl.TruckBaseService;
import com.shuidi.zhanggui.service.dal.entity.TruckBase;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.ImageHelper;
import net.sourceforge.tess4j.util.LoadLibs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.net.URL;
import java.util.Arrays;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by wandy on 2017-05-08.
 */
@RestController
@RequestMapping(value = "/truck")
@ExposesResourceFor(TruckBase.class)
@EnableEntityLinks
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class TruckApi {
    @Autowired
    private TruckBaseService truckBaseService;

    @Autowired
    private EntityLinks entityLinks;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity init(@PathVariable Long id) {
        try {
            TruckBase truckBase = truckBaseService.getById(id);
            TruckBaseResource resource = new TruckBaseResource(truckBase);
            Link selfLink = entityLinks.linkToSingleResource(TruckBase.class, id);
            Link basesLink = entityLinks.linkToCollectionResource(TruckBase.class).withRel("collects").expand("{[$.id]}");
            Link trucksLink = linkTo(methodOn(this.getClass()).getTrucks()).withRel("aa");
            resource.add(selfLink, basesLink, trucksLink);
            return new ResponseEntity<TruckBaseResource>(resource, HttpStatus.OK);

        } catch (Exception e) {
            System.out.print(e);
            e.printStackTrace();
            return ResponseEntity.ok(e);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity getTrucks() {
        try {
            TruckBase truckBase = truckBaseService.getById(4292L);
            TruckBaseResource resource = new TruckBaseResource(truckBase);
            Link selfLink = entityLinks.linkToSingleResource(TruckBase.class, 1L);
            resource.add(selfLink);
            return new ResponseEntity<TruckBaseResource>(resource, HttpStatus.OK);

        } catch (Exception e) {
            System.out.print(e);
            e.printStackTrace();
            return ResponseEntity.ok(e);
        }
    }

    public static void main(String[] args) {
        try {
            File imageFile = new File("C:\\Users\\wandy\\Desktop\\shenfenzheng2.png");
            ITesseract instance = new Tesseract();  // JNA Interface Mapping
            // ITesseract instance = new Tesseract1(); // JNA Direct Mapping
            //instrance.setDatapath("C:\\Users\\wandy\\work\\workspace\\shuidi\\tessdata");
            URL url = ClassLoader.getSystemResource("tessdata");
            String path = url.getPath().substring(1);
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            //灰度处理
            bufferedImage = ImageHelper.convertImageToGrayscale(bufferedImage);
            //ImageIO.write(bufferedImage,"png",new File("C:\\Users\\wandy\\Desktop\\shenfenzheng2_huidu.png"));
            //图片锐化-结果降低了识别度
            bufferedImage = ImageHelper.convertImageToBinary(bufferedImage);
            //ImageIO.write(bufferedImage,"png",new File("C:\\Users\\wandy\\Desktop\\shenfenzheng2_ruihua.png"));
            //放大图片提高分辨率 有一定效果
            bufferedImage = ImageHelper.getScaledInstance(bufferedImage, bufferedImage.getWidth() * 10, bufferedImage.getHeight() * 10);
            //ImageIO.write(bufferedImage, "png", new File("C:\\Users\\wandy\\Desktop\\shenfenzheng2_fangda10.png"));

            //中值滤波--效果不好
            //medianFiltering(bufferedImage);
            //ImageIO.write(bufferedImage, "png", new File("C:\\Users\\wandy\\Desktop\\shenfenzheng2_中值滤波.png"));
            //对称近邻域均值
            //snnFiltering(bufferedImage);
            //ImageIO.write(bufferedImage, "png", new File("C:\\Users\\wandy\\Desktop\\shenfenzheng2_对称近邻域.png"));
            //中值滤波
            avrFiltering(bufferedImage);
            ImageIO.write(bufferedImage, "png", new File("C:\\Users\\wandy\\Desktop\\shenfenzheng2_中值滤波.png"));

            File tessDataFolder = LoadLibs.extractTessResources("tessdata");
            instance.setDatapath(tessDataFolder.getAbsolutePath());
            instance.setLanguage("chi_sim");
            // System.out.println(System.getProperty("java.library.path"));

            String result = instance.doOCR(bufferedImage);
            System.out.println("识别结果：" + result);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    /**
     * 中值滤波
     */
    public static void medianFiltering(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();
        int[] pix = new int[w*h];
        img.getRGB(0, 0, w, h, pix, 0, w);
        int newpix[] = medianFiltering(pix, w, h);
        img.setRGB(0, 0, w, h, newpix, 0, w);
    }
    /**
     * 中值滤波
     * @param pix 像素矩阵数组
     * @param w 矩阵的宽
     * @param h 矩阵的高
     * @return 处理后的数组
     */
    public static int[] medianFiltering(int pix[], int w, int h) {
        int newpix[] = new int[w*h];
        int[] temp = new int[9];
        ColorModel cm = ColorModel.getRGBdefault();
        int r=0;
        for(int y=0; y<h; y++) {
            for(int x=0; x<w; x++) {
                if(x!=0 && x!=w-1 && y!=0 && y!=h-1) {
                    //g = median[(x-1,y-1) + f(x,y-1)+ f(x+1,y-1)
                    //  + f(x-1,y) + f(x,y) + f(x+1,y)
                    //  + f(x-1,y+1) + f(x,y+1) + f(x+1,y+1)]
                    temp[0] = cm.getRed(pix[x-1+(y-1)*w]);
                    temp[1] = cm.getRed(pix[x+(y-1)*w]);
                    temp[2] = cm.getRed(pix[x+1+(y-1)*w]);
                    temp[3] = cm.getRed(pix[x-1+(y)*w]);
                    temp[4] = cm.getRed(pix[x+(y)*w]);
                    temp[5] = cm.getRed(pix[x+1+(y)*w]);
                    temp[6] = cm.getRed(pix[x-1+(y+1)*w]);
                    temp[7] = cm.getRed(pix[x+(y+1)*w]);
                    temp[8] = cm.getRed(pix[x+1+(y+1)*w]);
                    Arrays.sort(temp);
                    r = temp[4];
                    newpix[y*w+x] = 255<<24 | r<<16 | r<<8 |r;
                } else {
                    newpix[y*w+x] = pix[y*w+x];
                }
            }
        }
        return newpix;
    }


    /**
     * 对称近邻均值滤波
     */
    public static void snnFiltering(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();
        int[] pix = new int[w*h];
        img.getRGB(0, 0, w, h, pix, 0, w);
        int newpix[] = medianFiltering(pix, w, h);
        img.setRGB(0, 0, w, h, newpix, 0, w);
    }
    /**
     * 对称近邻均值滤波
     * @param pix 像素矩阵数组
     * @param w 矩阵的宽
     * @param h 矩阵的高
     * @return 处理后的数组
     */
    public static int[] snnFiltering(int pix[], int w, int h) {
        int newpix[] = new int[w*h];
        int n = 9;
        int temp, i1,i2, sum;
        int[] temp1 = new int[n];
        int[] temp2 = new int[n/2];
        ColorModel cm = ColorModel.getRGBdefault();
        int r=0;
        for(int y=0; y<h; y++) {
            for(int x=0; x<w; x++) {
                if(x!=0 && x!=w-1 && y!=0 && y!=h-1) {
                    sum = 0;
                    temp1[0] = cm.getRed(pix[x-1+(y-1)*w]);
                    temp1[1] = cm.getRed(pix[x+(y-1)*w]);
                    temp1[2] = cm.getRed(pix[x+1+(y-1)*w]);
                    temp1[3] = cm.getRed(pix[x-1+(y)*w]);
                    temp1[4] = cm.getRed(pix[x+(y)*w]);
                    temp1[5] = cm.getRed(pix[x+1+(y)*w]);
                    temp1[6] = cm.getRed(pix[x-1+(y+1)*w]);
                    temp1[7] = cm.getRed(pix[x+(y+1)*w]);
                    temp1[8] = cm.getRed(pix[x+1+(y+1)*w]);
                    for(int k=0; k<n/2; k++) {
                        i1 = Math.abs(temp1[n/2] - temp1[k]);
                        i2 = Math.abs(temp1[n/2] - temp1[n-k-1]);
                        temp2[k] = i1<i2 ? temp1[k] : temp1[n-k-1];  //选择最接近原像素值的一个邻近像素
                        sum = sum + temp2[k];
                    }
                    r = sum/(n/2);
                    //System.out.println("pix:" + temp1[4] + "  r:" + r);
                    newpix[y*w+x] = 255<<24 | r<<16 | r<<8 |r;
                } else {
                    newpix[y*w+x] = pix[y*w+x];
                }
            }
        }
        return newpix;
    }

    /**
     * 均值滤波
     */
    public static void avrFiltering(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();
        int[] pix = new int[w*h];
        img.getRGB(0, 0, w, h, pix, 0, w);
        int newpix[] = medianFiltering(pix, w, h);
        img.setRGB(0, 0, w, h, newpix, 0, w);
    }
    /**
     * 均值滤波
     * @param pix 像素矩阵数组
     * @param w 矩阵的宽
     * @param h 矩阵的高
     * @return 处理后的数组
     */
    public static int[] avrFiltering(int pix[], int w, int h) {
        int newpix[] = new int[w*h];
        ColorModel cm = ColorModel.getRGBdefault();
        int r=0;
        for(int y=0; y<h; y++) {
            for(int x=0; x<w; x++) {
                if(x!=0 && x!=w-1 && y!=0 && y!=h-1) {
                    //g = (f(x-1,y-1) + f(x,y-1)+ f(x+1,y-1)
                    //  + f(x-1,y) + f(x,y) + f(x+1,y)
                    //  + f(x-1,y+1) + f(x,y+1) + f(x+1,y+1))/9
                    r = (cm.getRed(pix[x-1+(y-1)*w]) + cm.getRed(pix[x+(y-1)*w])+ cm.getRed(pix[x+1+(y-1)*w])
                            + cm.getRed(pix[x-1+(y)*w]) + cm.getRed(pix[x+(y)*w]) + cm.getRed(pix[x+1+(y)*w])
                            + cm.getRed(pix[x-1+(y+1)*w]) + cm.getRed(pix[x+(y+1)*w]) + cm.getRed(pix[x+1+(y+1)*w]))/9;
                    newpix[y*w+x] = 255<<24 | r<<16 | r<<8 |r;

                } else {
                    newpix[y*w+x] = pix[y*w+x];
                }
            }
        }
        return newpix;
    }


}
