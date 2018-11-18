package team.yingyingmonster.ccbs.template;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.lowagie.text.DocumentException;
import org.junit.Test;
import team.yingyingmonster.ccbs.web.WebUtil;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 23:50 2018/11/14
 * -
 **/
public class PdfUtilTest {
    @Test
    public void createPdfTest() throws IOException, DocumentException, InterruptedException {
        HtmlPage page = WebUtil.getAjaxHtml("", 10000, null);
        System.out.println(page.asXml());
        FileOutputStream outputStream = new FileOutputStream("D:/test.pdf");
        PdfUtil.createPdfFromHtmlString(page.asXml(), outputStream);
    }
}
