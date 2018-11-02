package team.yingyingmonster.ccs.controller.action;



import com.alibaba.fastjson.JSON;
import com.google.zxing.*;

import com.google.zxing.client.j2se.BufferedImageLuminanceSource;

import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.ibatis.javassist.NotFoundException;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import java.io.File;

import java.io.IOException;

import java.util.HashMap;


/**

 * @author Zhao Han Wei <br/>

 * - project: CompanyCheckSystem

 * - create: 21:03 2018/10/30

 * - 读取二维码信息的类

 **/



@Controller

@RequestMapping("/qrcode")

public class ReadQRcodeAction {

    public static final int WIDTH = 300;

    public static final int HEIGHT = 300;

    public static final String FORMAT = "png";

    public static final String CHARTSET = "utf-8";

    /**

     * 创建二维码信息

     * @param filePath

     * @return

     */

    @RequestMapping("/create")

    public String createQRcode(Long userId) {

        String filePath;

        String contents = JSON.toJSONString(userId) ;

        HashMap<EncodeHintType, Object> hints = new HashMap<>();

        hints.put(EncodeHintType.CHARACTER_SET, CHARTSET);

        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);

        hints.put(EncodeHintType.MARGIN, 2);

        try {

            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);

            BufferedImage bufferedImage=MatrixToImageWriter.toBufferedImage(bitMatrix);

            System.out.println("创建二维码完成");

        } catch (Exception e) {

            e.printStackTrace();

        }

        return "";

    }



    /**

     * 读取二维码信息

     * @param filePath

     * @return

     */

    @RequestMapping("/read")

    public String getQRresult(String filePath){

        Result result=QRresult(filePath);

        if (result != null) {

            System.out.println("二维码内容：" + result.getText());

            if (result.getText() != null) {

                Long userId = Long.valueOf(result.getText());

                System.out.println(userId);

            }

            System.out.println("二维码格式：" + result.getBarcodeFormat());

        }



        return "";

    }



    public Result QRresult(String filePath){

        Result result = null;

        try {

            File file = new File(filePath);



            BufferedImage bufferedImage = ImageIO.read(file);

            BinaryBitmap bitmap = new BinaryBitmap(

                    new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));

            HashMap hints = new HashMap<>();

            hints.put(EncodeHintType.CHARACTER_SET, CHARTSET);

            result = new MultiFormatReader().decode(bitmap, hints);

        } catch (IOException e) {

            e.printStackTrace();

        } catch (com.google.zxing.NotFoundException e) {

            e.printStackTrace();

        }

        return result;

    }





}