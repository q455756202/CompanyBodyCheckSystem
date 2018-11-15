package team.yingyingmonster.ccbs.template;

import com.lowagie.text.DocumentException;
import lombok.Cleanup;
import org.apache.commons.io.IOUtils;
import org.xhtmlrenderer.pdf.ITextFontContext;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.List;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 23:36 2018/11/14
 * -
 **/
public class PdfUtil {
    /**
     * 将一个HTML渲染为一个PDF，并输出至输出流中。
     * @param path HTML文件路径
     * @param outputStream 输出流
     * @throws IOException
     * @throws DocumentException
     */
    public static void createPdfFromHtmlFile(String path, OutputStream outputStream) throws IOException, DocumentException {
        // 使用lombok的注解，使其自动完成close操作。
        @Cleanup FileInputStream input = new FileInputStream(new File(path));
        List<String> lines = IOUtils.readLines(input, "UTF-8");

        String html = String.join("\n", lines);
        createPdfFromHtmlString(html, outputStream);
    }

    /**
     * 将一个HTML渲染为一个PDF，并输出至输出流中。
     * @param html HTML文本
     * @param outputStream 输出流
     * @throws DocumentException
     */
    public static void createPdfFromHtmlString(String html, OutputStream outputStream) throws DocumentException {
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(outputStream);
    }
}
