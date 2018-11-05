package team.yingyingmonster.ccbs.image;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 15:46 2018/11/2
 * -
 **/
public class ImageUtil {
    /**
     * 将一张图片转换为字节数组。
     * @param image 图片对象
     * @param formatName 图片的格式（JPEG、PNG等）
     * @return 转换后的字节数组。
     * @throws IOException
     */
    public static byte[] imageToBytes (RenderedImage image, String formatName) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ImageIO.write(image, formatName, output);
        return ((ByteArrayOutputStream) output).toByteArray();
    }
}
