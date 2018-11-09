package team.yingyingmonster.ccbs.controller.action;


import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
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
@RequestMapping("/read-qr-code")
public class ReadQRcodeAction {
    public static final String FORMAT = "png";
    public static final String CHARTSET = "utf-8";
    /**
     * 读取二维码信息
     * @param filePath
     * @return
     */
    @RequestMapping("/get-qr-result")
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
