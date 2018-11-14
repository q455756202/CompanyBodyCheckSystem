package team.yingyingmonster.ccbs.image;

import com.google.zxing.WriterException;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 9:57 2018/11/14
 * -
 **/
public class QrCodeUtilTest {
    @Test
    public void createQrCode() throws IOException, WriterException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        QrCodeUtil.createQrCode(outputStream, "test", 500, "png");
        System.out.println(Base64.getEncoder().encodeToString(outputStream.toByteArray()));
        BufferedImage image = ImageIO.read(new ByteArrayInputStream(outputStream.toByteArray()));

    }
}
